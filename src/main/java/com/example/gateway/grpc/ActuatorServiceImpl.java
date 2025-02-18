package com.example.gateway.grpc;

import com.example.gateway.ActuatorRequest;
import com.example.gateway.ActuatorResponse;
import com.example.gateway.ActuatorServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ActuatorServiceImpl extends ActuatorServiceGrpc.ActuatorServiceImplBase  {

    @Override
    public void turnOnDevice(ActuatorRequest request, StreamObserver<ActuatorResponse> responseObserver) {
        System.out.println("Turn On Device: " + request.getDeviceId() + request.getName());
        ActuatorResponse response = ActuatorResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void turnOffDevice(ActuatorRequest request, StreamObserver<ActuatorResponse> responseObserver) {
        System.out.println("Turn Off Device: " + request.getDeviceId());
        ActuatorResponse response = ActuatorResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}