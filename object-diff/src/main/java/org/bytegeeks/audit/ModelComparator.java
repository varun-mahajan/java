package org.bytegeeks.audit;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.bytegeeks.audit.ObjectDiff.ObjectClassifier;
import org.bytegeeks.audit.ObjectDiff.ObjectDiffFlags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipkart.zjsonpatch.DiffFlags;
import com.flipkart.zjsonpatch.JsonDiff;

/**
 * @author vamahaja
 *
 */
@Component
public class ModelComparator implements AuditComparator {

  private static final Logger LOG = LoggerFactory.getLogger(ModelComparator.class);

  private List<String> GLOBAL_IGNORE_ATTRIBUTE_LIST = new ArrayList<String>();

  private Map<String, List<String>> modelExclusions = new HashMap<String, List<String>>();

  private ObjectMapper mapper = new ObjectMapper();

  public void reloadExclusions() {
    modelExclusions = new HashMap();
    initConf();
  }
  
  @PostConstruct
  public void initConf() {
    try {
      File excludeFiles[] = getAttributeIgnoreFiles();
      for (int i = 0; i < excludeFiles.length; i++) {
        LOG.info("Parsing: {} file for exclusions", excludeFiles[i].getPath());
        LinkedHashMap<?, ?> map = mapper.readValue(excludeFiles[i], LinkedHashMap.class);
        modelExclusions.putAll((Map<? extends String, ? extends List<String>>) map);
      }
    } catch (Exception e) {
      LOG.error("Unable to parse global_exclusion_model_attributes.json file", e);
    }
    GLOBAL_IGNORE_ATTRIBUTE_LIST.addAll(modelExclusions.get("global_exclusion_model_attributes"));
    LOG.info("Final ignore map is: {}", modelExclusions);
  }

  public Map<String, List<String>> getModelExclusions() {
    return modelExclusions;
  }
  
  public List<String> getGlobalExclusions() {
    return GLOBAL_IGNORE_ATTRIBUTE_LIST;
  }
  
  private File[] getAttributeIgnoreFiles() {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    URL url = loader.getResource("attribute_exclusions");
    String path = url.getPath();
    return new File(path).listFiles();
  }
  
  public List<ObjectDiff> diff(Object leftObj, Object rightObj) {
    return diff(leftObj, rightObj, null);
  }

  public List<ObjectDiff> diff(Object leftObj, Object rightObj, EnumSet<ObjectDiffFlags> objectDiffFlags) {
    boolean enableStrictIndex = false;

    if(objectDiffFlags != null) {
      if(objectDiffFlags.contains(ObjectDiffFlags.ENABLE_STRICT_INDEX)) {
        enableStrictIndex = true;
      }
    }

    JsonNode left = (JsonNode)leftObj;
    JsonNode right = (JsonNode)rightObj;
    
    List<ObjectDiff> objectDiffList = new ArrayList<ObjectDiff>();

    EnumSet<DiffFlags> flags = EnumSet.of(DiffFlags.ADD_ORIGINAL_VALUE_ON_REPLACE, DiffFlags.OMIT_MOVE_OPERATION, DiffFlags.OMIT_COPY_OPERATION);

    //Step 0: Get RFC 6902 type diff using any lib
    JsonNode patchNode = JsonDiff.asJson(left, right, flags); 

    //Step 1: Cleanup ignored / data type changed attributes
    removeExcludedAttributes(patchNode, right);

    //Now we are only left with actual changes
    Iterator<JsonNode> iter = patchNode.iterator();
    while (iter.hasNext()) {
      JsonNode diffNode = iter.next();
      JsonNode pathNode = diffNode.get("path");
      String operation = diffNode.get("op").asText();
      String attributeName = pathNode.asText();

      //Step 2: Try normalize any list index mismatches
      if(!enableStrictIndex) {
        
         /*Step 2a: Check if the change is within a list and is for replace. That would mean, just index change
          * ex: 
          * source: "carray" : [1, 2, 4, "red", "blue"] 
          * destination: "carray" : ["red",1, 2, 4, "voilet", "blue"]
          * In above, we are supposed to ignore the replace request of "red" item as that is just index chagne
         */
        if(attributeName.matches("^.*\\d$")) {
          if("replace".equalsIgnoreCase(operation)) {
            LOG.debug("The requested change: {}, is just reshuffle of list items. Ignoring index changes. ENABLE_STRICT_INDEX: {}", diffNode, enableStrictIndex);
            continue;
          }
        }
        
        //Step 2b: List item is an object, try to match if that object is present at some other list index
        JsonNode diffNodeTargetContainer = getParentContainerNodeFromTarget(attributeName, right);
        JsonNode selfDiffNode = getImmediateParentObject(attributeName,left);
        boolean indexMisOrder = checkIfNodeExistsInList(selfDiffNode, diffNodeTargetContainer);
        if(indexMisOrder) {
          continue;
        }
      }

      // Step 3: Try resolving the object references by instanceUUID
      if("replace".equalsIgnoreCase(operation)) {
        if(isReferenceSame(diffNode.get("fromValue").asText(), diffNode.get("value"))) {
          LOG.debug("diffNode: '{}' is a soft reference", diffNode.get("path").asText());
          continue;
        }
      }

      // Step 4: Get our framework ObjectDiff
      ObjectDiff temp = getDiffObject(diffNode, right);
      
      objectDiffList.add(temp);
    }
    
    return objectDiffList;
  }

  private void removeExcludedAttributes(JsonNode patchNode, JsonNode right) {
    Iterator<JsonNode> iter = patchNode.iterator();

    while (iter.hasNext()) {
      JsonNode diffNode = iter.next();
      JsonNode pathNode = diffNode.get("path");
      String attributePath = pathNode.asText();
      String attributeName = getAttributeName(attributePath);
      JsonNode objectClass = right.at(pathNode.asText().substring(0,pathNode.asText().lastIndexOf("/")) + "/@class");
      boolean ignoreNode = false;

      String []tokenizedAttribPath = attributePath.split("/");
      for (int i = 0; i < tokenizedAttribPath.length; i++) {
        String tempPath = "/" + tokenizedAttribPath[i];
        JsonNode containerObj = null;
        containerObj = right.at(tempPath).get("@class");
        if(containerObj == null) {
          containerObj = right.get("@class");
        }
        if(containerObj!=null && containerObj.asText()!=null) {
          if((modelExclusions.get(containerObj.asText())!=null) && (modelExclusions.get(containerObj.asText()).contains(tokenizedAttribPath[i]))) {
            LOG.debug("Removing '{}' attribute from JSON diff output as it is marked to be ignored as model property of: '{}'", attributePath, containerObj.asText());
            ignoreNode = true;
            break;
          }
        }
      }
      
      if (!ignoreNode && GLOBAL_IGNORE_ATTRIBUTE_LIST.contains(attributeName)) {
        LOG.debug("Removing '{}' attribute from JSON diff output as it is marked to be ignored in GLOBAL_IGNORE_ATTRIBUTE_LIST", attributePath);
        ignoreNode = true;
      }
      else if(objectClass.asText()!=null && modelExclusions.get(objectClass.asText()) != null && modelExclusions.get(objectClass.asText()).contains(attributeName)) {
        LOG.debug("Removing '{}' attribute from JSON diff output as it is marked to be ignored as model property", attributePath);
        ignoreNode = true;
      }
      else if((diffNode.get("value")!=null) && 
          (diffNode.get("value").asText().equalsIgnoreCase("java.util.LinkedHashSet") || 
              diffNode.get("value").asText().equalsIgnoreCase("java.util.HashSet")))
      {
        ignoreNode = true;
      }

      if(ignoreNode) {
        iter.remove();
      }
    }
  }

  private ObjectDiff getDiffObject(JsonNode diffNode, JsonNode right) {
    
    JsonNode pathNode = diffNode.get("path");
    String operation = diffNode.get("op").asText();
    String attributeName = pathNode.asText().toLowerCase();
    
    ObjectDiff temp = new ObjectDiff();
    temp.setObjectClassifier(ObjectClassifier.MODEL);

    if(operation != null) {
      temp.setOp(operation);
      if(operation.equals("move")) {
        temp.setMoveFromPath(diffNode.get("from").asText());
      }
    }

    if(diffNode.get("fromValue") !=null)
      temp.setConfiguredValue(diffNode.get("fromValue"));

    if(diffNode.get("path") !=null)
      temp.setPath(diffNode.get("path").asText());

    if(diffNode.get("value") !=null)
      temp.setIntendedValue(diffNode.get("value"));

    JsonNode objectClass = right.at(pathNode.asText().substring(0,pathNode.asText().lastIndexOf("/")) + "/@class");
    if(objectClass != null) {
      temp.setObjectType(objectClass.asText());
    }
    else {
      LOG.error("Unable to determine Object type for node: {}", attributeName);
    }
    
    return temp;
  }

  private String getAttributeName(String attributePath) {
    
    if(attributePath.matches("^.*\\d$")) {
      return getAttributeName(StringUtils.substringBeforeLast(attributePath, "/"));
    }
    else {
      return StringUtils.substringAfterLast(attributePath, "/");
    }
  }

  /**
   * Try to identify from "intended" config node that which container (list) 
   * the diff path we have found belongs to 
   * @param diffAttributePath The full JSON path of the diff node
   * @param right The target JSON node
   * @return
   */
  private JsonNode getParentContainerNodeFromTarget(String diffAttributePath, JsonNode right) {
    //Get the immediate parent by removing last path
    String immediateParent = diffAttributePath.substring(0,diffAttributePath.lastIndexOf("/"));

    //If the immediate parent ends with number, that means it is a list indexed item.. so return list node
    if(immediateParent.matches("^.*\\d$")) {
      immediateParent = StringUtils.substringBeforeLast(immediateParent, "/");
    }

    return right.at(immediateParent);
  }

  /**
   * Get full Object of which @diffAttributePath belongs to
   * @param diffAttributePath
   * @param left
   * @return
   */
  private JsonNode getImmediateParentObject(String diffAttributePath, JsonNode left) {
    //Get the immediate parent by removing last path
    String immediateParent = diffAttributePath.substring(0,diffAttributePath.lastIndexOf("/"));

    return left.at(immediateParent);
  }

  private boolean checkIfNodeExistsInList(JsonNode source, JsonNode target) {
    boolean matchFound = false;

    JsonNode targetMatchingIndexNode = null;
    ArrayNode targetArrayNode = null;
    if(target instanceof ArrayNode) {
      targetArrayNode = (ArrayNode)target;
    }

    if(targetArrayNode == null || source == null || source instanceof MissingNode || target==null || target instanceof MissingNode) {
      return false;
    }

    //Remove any ignored properties from source object
    cleanIgnoredAttributes(source);

    Iterator<String> keys1 = source.fieldNames();
    while (keys1.hasNext()) {
      String key = (String) keys1.next();
      LOG.info("key: {} ", key);
    }
    //Iterate over all fields in source object, to see that if all of them are
    //present at same index in target node
    Iterator<String> keys = source.fieldNames();
    while (keys.hasNext()) {
      String key = (String) keys.next();
      JsonNode value = source.get(key);

      //For first time, targetMatchingIndexNode will be always null, try to idenitify potential matching index node in target
      if(targetMatchingIndexNode == null) {
        Iterator<JsonNode> tempIter = targetArrayNode.iterator();
        while(tempIter.hasNext()) {
          JsonNode tempTarget = tempIter.next();
          if(tempTarget.get(key) != null) {
            JsonNode tempValue = tempTarget.get(key);
            if(value!=null && value.equals(tempValue))
            {
              targetMatchingIndexNode = tempTarget;
              LOG.debug("Found initial match for key: '{}' at target: {}", key, tempTarget);
              break;
            }

          }

        }
      }
      if(targetMatchingIndexNode != null) {
        if(targetMatchingIndexNode.get(key) != null) {
          JsonNode tempValue = targetMatchingIndexNode.get(key);
          if(value!=null && value.equals(tempValue))
          {
            matchFound = true;
          }
          else if(value instanceof ArrayNode) {
            matchFound = true;
          }
          else {
            LOG.debug("Key: '{}' exists in target container but with different value. Expected value: '{}', found value: '{}'", key, value, tempValue);
            matchFound = false;
            break;
          }
        }
        else {
          LOG.debug("Key: '{}' doesn't exist in target: {}", key, targetMatchingIndexNode);
          matchFound = false;
          break;
        }
      }
      else {
        LOG.debug("No match found in target");
        matchFound = false;
        break;
      }
    }
    return matchFound;
  }


  /**
   * Remove any ignore object properties 
   * @param source
   */
  private void cleanIgnoredAttributes(JsonNode source) {
    for (String ignoreGlobalAttribute : GLOBAL_IGNORE_ATTRIBUTE_LIST) {
      if(source.has(ignoreGlobalAttribute)){
        ((ObjectNode)source).remove(ignoreGlobalAttribute);
      }
    }

    if(source.has("@class"))
    {
      ((ObjectNode)source).remove("@class");
    }
  }

  /**
   * Check if an object is same by comparing instanceUUIDs
   * @param configuredValue
   * @param intendedValue
   * @return
   */
  private boolean isReferenceSame(String configuredValue, JsonNode intendedValue) {
    boolean isSame = false;

    if(configuredValue!= null && isUUID(configuredValue)) {
      if(intendedValue.get("instanceUuid") != null) {
        if (configuredValue.equals(intendedValue.get("instanceUuid").asText())) {
          isSame = true;
        }
      }
    }
    else {
      isSame = false;
    }

    return isSame;
  }

  private boolean isUUID(String string) {
    try {
      UUID.fromString(string);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

}
