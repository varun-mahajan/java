package com.bytegeeks.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import example.complex.Complex.ComplexMessage;
import example.enumerations.EnumExample.EnumMessage;
import example.simple.Simple.SimpleMessage;

public class ProtoToJsonMain {

  public static void main(String[] args) throws InvalidProtocolBufferException {
    SimpleMessage simpleMessage = new SimpleMain().init();
    String jsonMessage = JsonFormat.printer().print(simpleMessage);
    
    System.out.print("Simple message json **********\n " + jsonMessage);
    System.out.println("**********************");
    
    EnumMessage enumMessage = new EnumMain().init();
    jsonMessage = JsonFormat.printer().print(enumMessage);
    
    System.out.println("ENUM message json **********\n " + jsonMessage);
    System.out.println("**********************");
    
    ComplexMessage complexMessage = new ComplexMain().init();
    jsonMessage = JsonFormat.printer().print(complexMessage);
    
    System.out.println("COMPLEX message json **********\n " + jsonMessage);
    System.out.println("**********************");
    
    ComplexMessage.Builder cBuilder = ComplexMessage.newBuilder();
    JsonFormat.parser().ignoringUnknownFields().merge(jsonMessage, cBuilder);
    System.out.println("COMPLEX message to proto buf again**********\n " + cBuilder.getOneDummy());
    System.out.println("**********************");
    
  }
}
