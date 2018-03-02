package org.bytegeeks.audit;

import java.util.Arrays;
import java.util.List;

import org.bytegeeks.audit.MatchingStrategy.STRATEGY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

public class ModelComparatorTest {

  ModelComparator modelComparator;
  ObjectMapper mapper;

  Logger LOG = LoggerFactory.getLogger(ModelComparatorTest.class);
  
  @BeforeMethod
  public void setup() {
    modelComparator = new ModelComparator();
    modelComparator.initConf();
    mapper = new ObjectMapper();
  }
  
  /**
   * Test basic difference of objects
   * @throws Exception
   */
  @Test
  public void testNFVDeploymentObject() throws Exception {
    String baseResource = "testNFVDeploymentObject";
    
    JsonNode beforeNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_left.json")); 
    JsonNode afterNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_right.json"));
    List<ObjectDiff> expectedDiff = mapper.readValue(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_expectedDiff.json"), List.class);
    
    List<ObjectDiff> actualDiff =  modelComparator.diff(beforeNode, afterNode);
    
    Assert.assertEquals(mapper.writeValueAsString(expectedDiff), mapper.writeValueAsString(actualDiff));
  }
  
  /**
   * Test by putting a model specific EXCLUDE rule
   * @throws Exception
   */
  @Test
  public void testNFVDeploymentObjectIgnoreAdminRule() throws Exception {
    String baseResource = "testNFVDeploymentObjectIgnoreAdminRule";

    MatchingStrategy s = new MatchingStrategy();
    s.setAttributes(Arrays.asList("adminRules"));
    s.setMatchStrategy(STRATEGY.EXCLUDE);
    modelComparator.getModelExclusions().put("com.cisco.esa.model.Deployment",s);
    
    JsonNode beforeNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_left.json")); 
    JsonNode afterNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_right.json"));
    List<ObjectDiff> expectedDiff = mapper.readValue(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_expectedDiff.json"), List.class);
    
    List<ObjectDiff> actualDiff =  modelComparator.diff(beforeNode, afterNode);
    
    Assert.assertEquals(mapper.writeValueAsString(expectedDiff), mapper.writeValueAsString(actualDiff));
  }
  
  /**
   * Test by including model specific INCLUDE rule
   * @throws Exception
   */
  @Test
  public void testNFVDeploymentObjectIncludeDescription() throws Exception {
    String baseResource = "testNFVDeploymentObjectIncludeDescription";

    MatchingStrategy s = new MatchingStrategy();
    s.setModelClass("com.cisco.esa.model.Deployment");
    s.setAttributes(Arrays.asList("description"));
    s.setMatchStrategy(STRATEGY.INCLUDE);
    modelComparator.getModelExclusions().put("com.cisco.esa.model.Deployment",s);
    
    JsonNode beforeNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_left.json")); 
    JsonNode afterNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_right.json"));
    List<ObjectDiff> expectedDiff = mapper.readValue(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_expectedDiff.json"), List.class);
    
    List<ObjectDiff> actualDiff =  modelComparator.diff(beforeNode, afterNode);
    LOG.info(mapper.writeValueAsString(actualDiff));
    Assert.assertEquals(mapper.writeValueAsString(expectedDiff), mapper.writeValueAsString(actualDiff));
  }
  
  /**
   * Test global INCLUDE
   * @throws Exception
   */
  @Test
  public void testNFVDeploymentObjectGlobalInclude() throws Exception {
    String baseResource = "testNFVDeploymentObjectGlobalInclude";

    MatchingStrategy s = new MatchingStrategy();
    s.setAttributes(Arrays.asList("instanceUuid"));
    s.setMatchStrategy(STRATEGY.INCLUDE);
    modelComparator.getModelExclusions().put("global_exclusion_model_attributes",s);
    modelComparator.getGlobalExclusions().clear();
    modelComparator.getGlobalExclusions().add("instanceUuid");
    modelComparator.setGlobalStrategy(STRATEGY.INCLUDE);


    JsonNode beforeNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_left.json")); 
    JsonNode afterNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_right.json"));
    List<ObjectDiff> expectedDiff = mapper.readValue(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_expectedDiff.json"), List.class);
    
    List<ObjectDiff> actualDiff =  modelComparator.diff(beforeNode, afterNode);
    
    Assert.assertEquals(mapper.writeValueAsString(expectedDiff), mapper.writeValueAsString(actualDiff));
  }
  
  /**
   * Plain list index mismatch test
   * @throws Exception
   */
  @Test
  public void testPlainListIndex() throws Exception {
    String baseResource = "testPlainListIndex";

    JsonNode beforeNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_left.json")); 
    JsonNode afterNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_right.json"));
    List<ObjectDiff> expectedDiff = mapper.readValue(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_expectedDiff.json"), List.class);
    
    List<ObjectDiff> actualDiff =  modelComparator.diff(beforeNode, afterNode);
    
    Assert.assertEquals(mapper.writeValueAsString(expectedDiff), mapper.writeValueAsString(actualDiff));
  }
}
