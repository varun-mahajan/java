package com.proto.blog;

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
    comments = "Source: blog/blog.proto")
public final class BlogServiceGrpc {

  private BlogServiceGrpc() {}

  public static final String SERVICE_NAME = "blog.BlogService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.blog.CreateBlogRequest,
      com.proto.blog.CreateBlogResponse> METHOD_CREATE_BLOG =
      io.grpc.MethodDescriptor.<com.proto.blog.CreateBlogRequest, com.proto.blog.CreateBlogResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "blog.BlogService", "CreateBlog"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.CreateBlogRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.CreateBlogResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.blog.ReadBlogRequest,
      com.proto.blog.ReadBlogResponse> METHOD_READ_BLOG =
      io.grpc.MethodDescriptor.<com.proto.blog.ReadBlogRequest, com.proto.blog.ReadBlogResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "blog.BlogService", "ReadBlog"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.ReadBlogRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.ReadBlogResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.blog.UpdateBlogRequest,
      com.proto.blog.UpdateBlogResponse> METHOD_UPDATE_BLOG =
      io.grpc.MethodDescriptor.<com.proto.blog.UpdateBlogRequest, com.proto.blog.UpdateBlogResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "blog.BlogService", "UpdateBlog"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.UpdateBlogRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.UpdateBlogResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.blog.DeleteBlogRequest,
      com.proto.blog.DeleteBlogResponse> METHOD_DELETE_BLOG =
      io.grpc.MethodDescriptor.<com.proto.blog.DeleteBlogRequest, com.proto.blog.DeleteBlogResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "blog.BlogService", "DeleteBlog"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.DeleteBlogRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.DeleteBlogResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.proto.blog.ListBlogRequest,
      com.proto.blog.ListBlogResponse> METHOD_LIST_BLOG =
      io.grpc.MethodDescriptor.<com.proto.blog.ListBlogRequest, com.proto.blog.ListBlogResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "blog.BlogService", "ListBlog"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.ListBlogRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.proto.blog.ListBlogResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlogServiceStub newStub(io.grpc.Channel channel) {
    return new BlogServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BlogServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BlogServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BlogServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createBlog(com.proto.blog.CreateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.CreateBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_BLOG, responseObserver);
    }

    /**
     */
    public void readBlog(com.proto.blog.ReadBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.ReadBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ_BLOG, responseObserver);
    }

    /**
     */
    public void updateBlog(com.proto.blog.UpdateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.UpdateBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_BLOG, responseObserver);
    }

    /**
     */
    public void deleteBlog(com.proto.blog.DeleteBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.DeleteBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_BLOG, responseObserver);
    }

    /**
     */
    public void listBlog(com.proto.blog.ListBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.ListBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_BLOG, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_BLOG,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.CreateBlogRequest,
                com.proto.blog.CreateBlogResponse>(
                  this, METHODID_CREATE_BLOG)))
          .addMethod(
            METHOD_READ_BLOG,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.ReadBlogRequest,
                com.proto.blog.ReadBlogResponse>(
                  this, METHODID_READ_BLOG)))
          .addMethod(
            METHOD_UPDATE_BLOG,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.UpdateBlogRequest,
                com.proto.blog.UpdateBlogResponse>(
                  this, METHODID_UPDATE_BLOG)))
          .addMethod(
            METHOD_DELETE_BLOG,
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.DeleteBlogRequest,
                com.proto.blog.DeleteBlogResponse>(
                  this, METHODID_DELETE_BLOG)))
          .addMethod(
            METHOD_LIST_BLOG,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.blog.ListBlogRequest,
                com.proto.blog.ListBlogResponse>(
                  this, METHODID_LIST_BLOG)))
          .build();
    }
  }

  /**
   */
  public static final class BlogServiceStub extends io.grpc.stub.AbstractStub<BlogServiceStub> {
    private BlogServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlogServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlogServiceStub(channel, callOptions);
    }

    /**
     */
    public void createBlog(com.proto.blog.CreateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.CreateBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_BLOG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBlog(com.proto.blog.ReadBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.ReadBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ_BLOG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateBlog(com.proto.blog.UpdateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.UpdateBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_BLOG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBlog(com.proto.blog.DeleteBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.DeleteBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_BLOG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listBlog(com.proto.blog.ListBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.ListBlogResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_BLOG, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BlogServiceBlockingStub extends io.grpc.stub.AbstractStub<BlogServiceBlockingStub> {
    private BlogServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlogServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlogServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.blog.CreateBlogResponse createBlog(com.proto.blog.CreateBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_BLOG, getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.ReadBlogResponse readBlog(com.proto.blog.ReadBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ_BLOG, getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.UpdateBlogResponse updateBlog(com.proto.blog.UpdateBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_BLOG, getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.DeleteBlogResponse deleteBlog(com.proto.blog.DeleteBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_BLOG, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.proto.blog.ListBlogResponse> listBlog(
        com.proto.blog.ListBlogRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_BLOG, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BlogServiceFutureStub extends io.grpc.stub.AbstractStub<BlogServiceFutureStub> {
    private BlogServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlogServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlogServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.CreateBlogResponse> createBlog(
        com.proto.blog.CreateBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_BLOG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.ReadBlogResponse> readBlog(
        com.proto.blog.ReadBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ_BLOG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.UpdateBlogResponse> updateBlog(
        com.proto.blog.UpdateBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_BLOG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.DeleteBlogResponse> deleteBlog(
        com.proto.blog.DeleteBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_BLOG, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BLOG = 0;
  private static final int METHODID_READ_BLOG = 1;
  private static final int METHODID_UPDATE_BLOG = 2;
  private static final int METHODID_DELETE_BLOG = 3;
  private static final int METHODID_LIST_BLOG = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BlogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BlogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BLOG:
          serviceImpl.createBlog((com.proto.blog.CreateBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.CreateBlogResponse>) responseObserver);
          break;
        case METHODID_READ_BLOG:
          serviceImpl.readBlog((com.proto.blog.ReadBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.ReadBlogResponse>) responseObserver);
          break;
        case METHODID_UPDATE_BLOG:
          serviceImpl.updateBlog((com.proto.blog.UpdateBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.UpdateBlogResponse>) responseObserver);
          break;
        case METHODID_DELETE_BLOG:
          serviceImpl.deleteBlog((com.proto.blog.DeleteBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.DeleteBlogResponse>) responseObserver);
          break;
        case METHODID_LIST_BLOG:
          serviceImpl.listBlog((com.proto.blog.ListBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.ListBlogResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class BlogServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.blog.BlogOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BlogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlogServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_BLOG)
              .addMethod(METHOD_READ_BLOG)
              .addMethod(METHOD_UPDATE_BLOG)
              .addMethod(METHOD_DELETE_BLOG)
              .addMethod(METHOD_LIST_BLOG)
              .build();
        }
      }
    }
    return result;
  }
}
