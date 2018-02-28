package org.bytegeeks.audit;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

public class ModelComparatorTest {

  ModelComparator modelComparator;
  ObjectMapper mapper;

  @BeforeMethod
  public void setup() {
    modelComparator = new ModelComparator();
    modelComparator.initConf();
    mapper = new ObjectMapper();
  }
  
  @Test
  public void testNFVDeploymentObject() throws Exception {
    String baseResource = "testNFVDeploymentObject";
    
    JsonNode beforeNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_left.json")); 
    JsonNode afterNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_right.json"));
    List<ObjectDiff> expectedDiff = mapper.readValue(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_expectedDiff.json"), List.class);
    
    List<ObjectDiff> actualDiff =  modelComparator.diff(beforeNode, afterNode);
    
    Assert.assertEquals(mapper.writeValueAsString(expectedDiff), mapper.writeValueAsString(actualDiff));
  }
  
  @Test
  public void testNFVDeploymentObjectIgnoreAdminRule() throws Exception {
    String baseResource = "testNFVDeploymentObjectIgnoreAdminRule";

    modelComparator.getModelExclusions().get("com.cisco.esa.model.Deployment").add("adminRules");
    
    JsonNode beforeNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_left.json")); 
    JsonNode afterNode = mapper.readTree(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_right.json"));
    List<ObjectDiff> expectedDiff = mapper.readValue(Thread.currentThread().getContextClassLoader().getResource(baseResource+"_expectedDiff.json"), List.class);
    
    List<ObjectDiff> actualDiff =  modelComparator.diff(beforeNode, afterNode);
    
    Assert.assertEquals(mapper.writeValueAsString(expectedDiff), mapper.writeValueAsString(actualDiff));
  }
  
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
