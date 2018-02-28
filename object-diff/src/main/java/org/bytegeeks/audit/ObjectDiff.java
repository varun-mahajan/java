package org.bytegeeks.audit;

public class ObjectDiff {
  
  enum ObjectClassifier {
    MODEL
  }
  
  public enum ObjectDiffFlags {
    IGNORE_EXTRA_RUNNING_INFO, ENABLE_STRICT_INDEX
  }
  
  private String op;
  private Object configuredValue;
  private Object intendedValue;
  private String moveFromPath;

  private String path;
  private ObjectClassifier objectClassifier;
  private String objectType;
  
  public String getOp() {
    return op;
  }

  public void setOp(String op) {
    this.op = op;
  }

  public Object getConfiguredValue() {
    return configuredValue;
  }

  public void setConfiguredValue(Object configuredValue) {
    this.configuredValue = configuredValue;
  }

  public Object getIntendedValue() {
    return intendedValue;
  }

  public void setIntendedValue(Object intendedValue) {
    this.intendedValue = intendedValue;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ObjectClassifier getObjectClassifier() {
    return objectClassifier;
  }

  public void setObjectClassifier(ObjectClassifier objectClassifier) {
    this.objectClassifier = objectClassifier;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public String getMoveFromPath() {
    return moveFromPath;
  }

  public void setMoveFromPath(String moveFromPath) {
    this.moveFromPath = moveFromPath;
  }

  @Override
  public String toString() {
    return "ObjectDiff [op=" + op + ", configuredValue=" + configuredValue + ", intendedValue=" + intendedValue
        + ", moveFromPath=" + moveFromPath + ", path=" + path + ", objectClassifier=" + objectClassifier
        + ", objectType=" + objectType + "]";
  }
  

}
