package com.example.gateway.controller;

import com.example.gateway.service.ActuatorService;
import com.example.gateway.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/actuator")
public class ActuatorController {

    @Autowired
    private GrpcService grpcService;

    @Autowired
    private ActuatorService actuatorService;

    @PostMapping("/{name}/on")
    public ResponseEntity<?> turnOnDevice(@PathVariable String name) {
        return ok(grpcService.turnOn(actuatorService.getActuatorRequest(name)));
    }

    @PostMapping("/{name}/off")
    public ResponseEntity<?> turnOffDevice(@PathVariable String name) {
        return ok(grpcService.turnOn(actuatorService.getActuatorRequest(name)));
    }
}
