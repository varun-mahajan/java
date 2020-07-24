package com.proto.greet;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: greet/greet.proto")
public final class GreetServiceGrpc {

  private GreetServiceGrpc() {}

  public static final String SERVICE_NAME = "greet.GreetService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.greet.GreetRequest,
      com.proto.greet.GreetResponse> METHOD_GREET =
      io.grpc.MethodDescriptor.<com.proto.greet.GreetRequest, com.proto.greet.GreetResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "greet.GreetService", "Greet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.greet.GreetManyTimesRequest,
      com.proto.greet.GreetManyTimesResponse> METHOD_GREET_MANY_TIMES =
      io.grpc.MethodDescriptor.<com.proto.greet.GreetManyTimesRequest, com.proto.greet.GreetManyTimesResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "greet.GreetService", "GreetManyTimes"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetManyTimesRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetManyTimesResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.greet.LongGreetRequest,
      com.proto.greet.LongGreetResponse> METHOD_LONG_GREET =
      io.grpc.MethodDescriptor.<com.proto.greet.LongGreetRequest, com.proto.greet.LongGreetResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "greet.GreetService", "LongGreet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.LongGreetRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.LongGreetResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.greet.GreetEveryoneRequest,
      com.proto.greet.GreetEveryoneResponse> METHOD_GREET_EVERYONE =
      io.grpc.MethodDescriptor.<com.proto.greet.GreetEveryoneRequest, com.proto.greet.GreetEveryoneResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "greet.GreetService", "GreetEveryone"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetEveryoneRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetEveryoneResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.greet.GreetWithDeadlineRequest,
      com.proto.greet.GreetWithDeadlineResponse> METHOD_GREET_WITH_DEADLINE =
      io.grpc.MethodDescriptor.<com.proto.greet.GreetWithDeadlineRequest, com.proto.greet.GreetWithDeadlineResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "greet.GreetService", "GreetWithDeadline"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetWithDeadlineRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.greet.GreetWithDeadlineResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreetServiceStub newStub(io.grpc.Channel channel) {
    return new GreetServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreetServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreetServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreetServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreetServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GreetServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void greet(com.proto.greet.GreetRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.GreetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GREET, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void greetManyTimes(com.proto.greet.GreetManyTimesRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.GreetManyTimesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GREET_MANY_TIMES, responseObserver);
    }

    /**
     * <pre>
     * Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.greet.LongGreetRequest> longGreet(
        io.grpc.stub.StreamObserver<com.proto.greet.LongGreetResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_LONG_GREET, responseObserver);
    }

    /**
     * <pre>
     * BiDi Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.greet.GreetEveryoneRequest> greetEveryone(
        io.grpc.stub.StreamObserver<com.proto.greet.GreetEveryoneResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GREET_EVERYONE, responseObserver);
    }

    /**
     * <pre>
     * Rpc with Deadline
     * this Rpc will complete in no less than 300ms
     * </pre>
     */
    public void greetWithDeadline(com.proto.greet.GreetWithDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.GreetWithDeadlineResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GREET_WITH_DEADLINE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GREET,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.greet.GreetRequest,
                com.proto.greet.GreetResponse>(
                  this, METHODID_GREET)))
          .addMethod(
            METHOD_GREET_MANY_TIMES,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.greet.GreetManyTimesRequest,
                com.proto.greet.GreetManyTimesResponse>(
                  this, METHODID_GREET_MANY_TIMES)))
          .addMethod(
            METHOD_LONG_GREET,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.proto.greet.LongGreetRequest,
                com.proto.greet.LongGreetResponse>(
                  this, METHODID_LONG_GREET)))
          .addMethod(
            METHOD_GREET_EVERYONE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.greet.GreetEveryoneRequest,
                com.proto.greet.GreetEveryoneResponse>(
                  this, METHODID_GREET_EVERYONE)))
          .addMethod(
            METHOD_GREET_WITH_DEADLINE,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.greet.GreetWithDeadlineRequest,
                com.proto.greet.GreetWithDeadlineResponse>(
                  this, METHODID_GREET_WITH_DEADLINE)))
          .build();
    }
  }

  /**
   */
  public static final class GreetServiceStub extends io.grpc.stub.AbstractStub<GreetServiceStub> {
    private GreetServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void greet(com.proto.greet.GreetRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.GreetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GREET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void greetManyTimes(com.proto.greet.GreetManyTimesRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.GreetManyTimesResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GREET_MANY_TIMES, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.greet.LongGreetRequest> longGreet(
        io.grpc.stub.StreamObserver<com.proto.greet.LongGreetResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_LONG_GREET, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * BiDi Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.greet.GreetEveryoneRequest> greetEveryone(
        io.grpc.stub.StreamObserver<com.proto.greet.GreetEveryoneResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GREET_EVERYONE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Rpc with Deadline
     * this Rpc will complete in no less than 300ms
     * </pre>
     */
    public void greetWithDeadline(com.proto.greet.GreetWithDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.GreetWithDeadlineResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GREET_WITH_DEADLINE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GreetServiceBlockingStub extends io.grpc.stub.AbstractStub<GreetServiceBlockingStub> {
    private GreetServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.proto.greet.GreetResponse greet(com.proto.greet.GreetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GREET, getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public java.util.Iterator<com.proto.greet.GreetManyTimesResponse> greetManyTimes(
        com.proto.greet.GreetManyTimesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GREET_MANY_TIMES, getCallOptions(), request);
    }

    /**
     * <pre>
     * Rpc with Deadline
     * this Rpc will complete in no less than 300ms
     * </pre>
     */
    public com.proto.greet.GreetWithDeadlineResponse greetWithDeadline(com.proto.greet.GreetWithDeadlineRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GREET_WITH_DEADLINE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GreetServiceFutureStub extends io.grpc.stub.AbstractStub<GreetServiceFutureStub> {
    private GreetServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.greet.GreetResponse> greet(
        com.proto.greet.GreetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GREET, getCallOptions()), request);
    }

    /**
     * <pre>
     * Rpc with Deadline
     * this Rpc will complete in no less than 300ms
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.greet.GreetWithDeadlineResponse> greetWithDeadline(
        com.proto.greet.GreetWithDeadlineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GREET_WITH_DEADLINE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GREET = 0;
  private static final int METHODID_GREET_MANY_TIMES = 1;
  private static final int METHODID_GREET_WITH_DEADLINE = 2;
  private static final int METHODID_LONG_GREET = 3;
  private static final int METHODID_GREET_EVERYONE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GREET:
          serviceImpl.greet((com.proto.greet.GreetRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.greet.GreetResponse>) responseObserver);
          break;
        case METHODID_GREET_MANY_TIMES:
          serviceImpl.greetManyTimes((com.proto.greet.GreetManyTimesRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.greet.GreetManyTimesResponse>) responseObserver);
          break;
        case METHODID_GREET_WITH_DEADLINE:
          serviceImpl.greetWithDeadline((com.proto.greet.GreetWithDeadlineRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.greet.GreetWithDeadlineResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LONG_GREET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.longGreet(
              (io.grpc.stub.StreamObserver<com.proto.greet.LongGreetResponse>) responseObserver);
        case METHODID_GREET_EVERYONE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.greetEveryone(
              (io.grpc.stub.StreamObserver<com.proto.greet.GreetEveryoneResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class GreetServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.greet.Greet.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreetServiceDescriptorSupplier())
              .addMethod(METHOD_GREET)
              .addMethod(METHOD_GREET_MANY_TIMES)
              .addMethod(METHOD_LONG_GREET)
              .addMethod(METHOD_GREET_EVERYONE)
              .addMethod(METHOD_GREET_WITH_DEADLINE)
              .build();
        }
      }
    }
    return result;
  }
}
