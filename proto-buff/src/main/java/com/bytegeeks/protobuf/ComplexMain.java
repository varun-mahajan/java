package com.bytegeeks.protobuf;

import example.complex.Complex.ComplexMessage;
import example.complex.Complex.DummyMessage;

public class ComplexMain {

  public ComplexMessage init()
  {
    ComplexMessage.Builder complexMsgBuilder = ComplexMessage.newBuilder();
    DummyMessage.Builder dummyMsgBuilder = DummyMessage.newBuilder();
    
    complexMsgBuilder.setOneDummy(dummyMsgBuilder.setId(1).setName("Varun"));
    System.out.println(dummyMsgBuilder.build());
    
    complexMsgBuilder.addMultipleDummy(0, dummyMsgBuilder.setId(2).setName("Varun2"));
    complexMsgBuilder.addMultipleDummy(1, dummyMsgBuilder.setId(3).setName("Varun3"));

    ComplexMessage cMsg = complexMsgBuilder.build();
    return cMsg;
  }
  
  public static void main(String[] args) {
    
    System.out.println("*************** Reading from object, name: " + new ComplexMain().init());
    
  }
}
