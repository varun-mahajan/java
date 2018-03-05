package org.bytegeeks.audit;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchingStrategy {

  public enum STRATEGY {
    INCLUDE("include"), EXCLUDE("exclude");
    
    private final String strategy;
    
    STRATEGY(String strategy) {
      this.strategy = strategy;
    }

    public String getStrategy() {
      return strategy;
    }
    
  }
  
  private String modelClass;
  
  private STRATEGY matchStrategy = STRATEGY.EXCLUDE;
  
  private List<String> attributes = new ArrayList<String>();
  
  public String getModelClass() {
    return modelClass;
  }

  public void setModelClass(String modelClass) {
    this.modelClass = modelClass;
  }

  public STRATEGY getMatchStrategy() {
    return matchStrategy;
  }
  
  public void setMatchStrategy(STRATEGY matchStrategy) {
    this.matchStrategy = matchStrategy;
  }
  
  public List<String> getAttributes() {
    return attributes;
  }
  
  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String toString() {
    return "MatchingStrategy [modelClass=" + modelClass + ", matchStrategy=" + matchStrategy + ", attributes="
        + attributes + "]";
  }
  
}
