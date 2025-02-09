package com.example.gateway.controller;

import com.example.gateway.grpc.ActuatorRequest;
import com.example.gateway.grpc.ActuatorServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    @GrpcClient("actuatorServiceGrpc")
    private ActuatorServiceGrpc.ActuatorServiceBlockingStub actuatorStub;

    @PostMapping("/{id}/on")
    public ResponseEntity<?> turnOnDevice(@PathVariable Long id) {
        ActuatorRequest request = ActuatorRequest.newBuilder().setDeviceId(id).build();
        var actuator = actuatorStub.turnOnDevice(request);
        return new ResponseEntity<>(actuator, HttpStatus.OK);
    }

    @PostMapping("/{id}/off")
    public ResponseEntity<?> turnOffDevice(@PathVariable Long id) {
        ActuatorRequest request = ActuatorRequest.newBuilder().setDeviceId(id).build();
        var actuator = actuatorStub.turnOffDevice(request);
        return new ResponseEntity<>(actuator, HttpStatus.OK);
    }
}
