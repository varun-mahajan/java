package org.bytegeeks.controller;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import org.bytegeeks.audit.ModelComparator;
import org.bytegeeks.audit.ObjectDiff;
import org.bytegeeks.audit.ObjectDiff.ObjectDiffFlags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.DiffFlags;
import com.flipkart.zjsonpatch.JsonDiff;

@Controller
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    private List<String> GLOBAL_IGNORE_ATTRIBUTE_LIST = Arrays.asList("instanceUuid", "instanceId");

    @Autowired
    private ModelComparator modelComparator;
    
    private ObjectMapper mapper = new ObjectMapper();
    
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<String> test() {
        LOG.info("All OK");
        return new ResponseEntity<String>("All OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/zson-diff/{file1}/{file2}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<List<ObjectDiff>> zsonDiff(@PathVariable String file1,  @PathVariable String file2) throws JsonParseException, JsonMappingException, IOException {
        LOG.debug("Calling flipkart zson-patch diff");
        JsonNode beforeNode = mapper.readTree(new File(file1)); 
        JsonNode afterNode = mapper.readTree(new File(file2));
        
        List<ObjectDiff> diff =  modelComparator.diff(beforeNode, afterNode);

        return new ResponseEntity<List<ObjectDiff>>(diff, HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "/zson-diff/reload", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<String> reload() throws JsonParseException, JsonMappingException, IOException {

      modelComparator.reloadExclusions();

      return new ResponseEntity<String>("Done", HttpStatus.OK);
        
    }
    

    @RequestMapping(value = "/zson-diff-orig/{file1}/{file2}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<JsonNode> zsonDiffOrig(@PathVariable String file1,  @PathVariable String file2) throws JsonParseException, JsonMappingException, IOException {
        LOG.debug("Calling flipkart zson-patch diff");
        JsonNode beforeNode = mapper.readTree(new File(file1)); 
        JsonNode afterNode = mapper.readTree(new File(file2));
        
        JsonNode node =  JsonDiff.asJson(beforeNode, afterNode, DiffFlags.dontNormalizeOpIntoMoveAndCopy());

        return new ResponseEntity<JsonNode>(node, HttpStatus.OK);
        
    }
    
}
