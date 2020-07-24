package com.proto.calculator;

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
    comments = "Source: calculator/calculator.proto")
public final class CalculatorServiceGrpc {

  private CalculatorServiceGrpc() {}

  public static final String SERVICE_NAME = "calculator.CalculatorService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.calculator.SumRequest,
      com.proto.calculator.SumResponse> METHOD_SUM =
      io.grpc.MethodDescriptor.<com.proto.calculator.SumRequest, com.proto.calculator.SumResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "calculator.CalculatorService", "Sum"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.SumRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.SumResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionRequest,
      com.proto.calculator.PrimeNumberDecompositionResponse> METHOD_PRIME_NUMBER_DECOMPOSITION =
      io.grpc.MethodDescriptor.<com.proto.calculator.PrimeNumberDecompositionRequest, com.proto.calculator.PrimeNumberDecompositionResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "calculator.CalculatorService", "PrimeNumberDecomposition"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.PrimeNumberDecompositionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.PrimeNumberDecompositionResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.calculator.ComputeAverageRequest,
      com.proto.calculator.ComputeAverageResponse> METHOD_COMPUTE_AVERAGE =
      io.grpc.MethodDescriptor.<com.proto.calculator.ComputeAverageRequest, com.proto.calculator.ComputeAverageResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "calculator.CalculatorService", "ComputeAverage"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.ComputeAverageRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.ComputeAverageResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.calculator.FindMaximumRequest,
      com.proto.calculator.FindMaximumResponse> METHOD_FIND_MAXIMUM =
      io.grpc.MethodDescriptor.<com.proto.calculator.FindMaximumRequest, com.proto.calculator.FindMaximumResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "calculator.CalculatorService", "FindMaximum"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.FindMaximumRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.FindMaximumResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.calculator.SquareRootRequest,
      com.proto.calculator.SquareRootResponse> METHOD_SQUARE_ROOT =
      io.grpc.MethodDescriptor.<com.proto.calculator.SquareRootRequest, com.proto.calculator.SquareRootResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "calculator.CalculatorService", "SquareRoot"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.SquareRootRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.calculator.SquareRootResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorServiceStub newStub(io.grpc.Channel channel) {
    return new CalculatorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculatorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sum(com.proto.calculator.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUM, responseObserver);
    }

    /**
     */
    public void primeNumberDecomposition(com.proto.calculator.PrimeNumberDecompositionRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PRIME_NUMBER_DECOMPOSITION, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageRequest> computeAverage(
        io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_COMPUTE_AVERAGE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumRequest> findMaximum(
        io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_FIND_MAXIMUM, responseObserver);
    }

    /**
     * <pre>
     * error handling
     * this RPC will throw an exception if the sent number is negative
     * The error being sent is of type INVALID_ARGUMENT
     * </pre>
     */
    public void squareRoot(com.proto.calculator.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SquareRootResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SQUARE_ROOT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SUM,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.calculator.SumRequest,
                com.proto.calculator.SumResponse>(
                  this, METHODID_SUM)))
          .addMethod(
            METHOD_PRIME_NUMBER_DECOMPOSITION,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.calculator.PrimeNumberDecompositionRequest,
                com.proto.calculator.PrimeNumberDecompositionResponse>(
                  this, METHODID_PRIME_NUMBER_DECOMPOSITION)))
          .addMethod(
            METHOD_COMPUTE_AVERAGE,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.proto.calculator.ComputeAverageRequest,
                com.proto.calculator.ComputeAverageResponse>(
                  this, METHODID_COMPUTE_AVERAGE)))
          .addMethod(
            METHOD_FIND_MAXIMUM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.calculator.FindMaximumRequest,
                com.proto.calculator.FindMaximumResponse>(
                  this, METHODID_FIND_MAXIMUM)))
          .addMethod(
            METHOD_SQUARE_ROOT,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.calculator.SquareRootRequest,
                com.proto.calculator.SquareRootResponse>(
                  this, METHODID_SQUARE_ROOT)))
          .build();
    }
  }

  /**
   */
  public static final class CalculatorServiceStub extends io.grpc.stub.AbstractStub<CalculatorServiceStub> {
    private CalculatorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceStub(channel, callOptions);
    }

    /**
     */
    public void sum(com.proto.calculator.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SumResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void primeNumberDecomposition(com.proto.calculator.PrimeNumberDecompositionRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_PRIME_NUMBER_DECOMPOSITION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageRequest> computeAverage(
        io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_COMPUTE_AVERAGE, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumRequest> findMaximum(
        io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_FIND_MAXIMUM, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * error handling
     * this RPC will throw an exception if the sent number is negative
     * The error being sent is of type INVALID_ARGUMENT
     * </pre>
     */
    public void squareRoot(com.proto.calculator.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SquareRootResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SQUARE_ROOT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalculatorServiceBlockingStub extends io.grpc.stub.AbstractStub<CalculatorServiceBlockingStub> {
    private CalculatorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.calculator.SumResponse sum(com.proto.calculator.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUM, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.proto.calculator.PrimeNumberDecompositionResponse> primeNumberDecomposition(
        com.proto.calculator.PrimeNumberDecompositionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_PRIME_NUMBER_DECOMPOSITION, getCallOptions(), request);
    }

    /**
     * <pre>
     * error handling
     * this RPC will throw an exception if the sent number is negative
     * The error being sent is of type INVALID_ARGUMENT
     * </pre>
     */
    public com.proto.calculator.SquareRootResponse squareRoot(com.proto.calculator.SquareRootRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SQUARE_ROOT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculatorServiceFutureStub extends io.grpc.stub.AbstractStub<CalculatorServiceFutureStub> {
    private CalculatorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.calculator.SumResponse> sum(
        com.proto.calculator.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUM, getCallOptions()), request);
    }

    /**
     * <pre>
     * error handling
     * this RPC will throw an exception if the sent number is negative
     * The error being sent is of type INVALID_ARGUMENT
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.calculator.SquareRootResponse> squareRoot(
        com.proto.calculator.SquareRootRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SQUARE_ROOT, getCallOptions()), request);
    }
  }

  private static final int METHODID_SUM = 0;
  private static final int METHODID_PRIME_NUMBER_DECOMPOSITION = 1;
  private static final int METHODID_SQUARE_ROOT = 2;
  private static final int METHODID_COMPUTE_AVERAGE = 3;
  private static final int METHODID_FIND_MAXIMUM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUM:
          serviceImpl.sum((com.proto.calculator.SumRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.SumResponse>) responseObserver);
          break;
        case METHODID_PRIME_NUMBER_DECOMPOSITION:
          serviceImpl.primeNumberDecomposition((com.proto.calculator.PrimeNumberDecompositionRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionResponse>) responseObserver);
          break;
        case METHODID_SQUARE_ROOT:
          serviceImpl.squareRoot((com.proto.calculator.SquareRootRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.SquareRootResponse>) responseObserver);
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
        case METHODID_COMPUTE_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.computeAverage(
              (io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageResponse>) responseObserver);
        case METHODID_FIND_MAXIMUM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findMaximum(
              (io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CalculatorServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.calculator.Calculator.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalculatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorServiceDescriptorSupplier())
              .addMethod(METHOD_SUM)
              .addMethod(METHOD_PRIME_NUMBER_DECOMPOSITION)
              .addMethod(METHOD_COMPUTE_AVERAGE)
              .addMethod(METHOD_FIND_MAXIMUM)
              .addMethod(METHOD_SQUARE_ROOT)
              .build();
        }
      }
    }
    return result;
  }
}
