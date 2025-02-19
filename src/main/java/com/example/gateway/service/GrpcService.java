package com.example.gateway.service;

import com.example.gateway.ActuatorRequest;
import com.example.gateway.ActuatorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrpcService {

    private final ActuatorServiceGrpc.ActuatorServiceBlockingStub actuatorServiceBlockingStub;

    public GrpcService() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        actuatorServiceBlockingStub = ActuatorServiceGrpc.newBlockingStub(channel);
    }

    public boolean turnOn(ActuatorRequest request) {
        ActuatorRequest actuatorRequest = ActuatorRequest.newBuilder(request).build();
        return actuatorServiceBlockingStub.turnOnDevice(actuatorRequest).getSuccess();
    }
}
