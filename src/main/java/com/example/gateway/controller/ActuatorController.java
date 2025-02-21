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
@RequestMapping("/api/actuators")
public class ActuatorController {

    @Autowired
    private GrpcService grpcService;

    @Autowired
    private ActuatorService actuatorService;

    @PostMapping("/actuator_temperature/{value}")
    public ResponseEntity<?> setValueActuatorTemperature(@PathVariable Float value) {
        String name = "actuator_temperature";
        return ok(grpcService.setValueTemperatureActuator(actuatorService.getActuatorRequest(name, value)));
    }

    @PostMapping("/actuator_light/{value}")
    public ResponseEntity<?> setValueActuatorLight(@PathVariable Float value) {
        String name = "actuator_light";
        return ok(grpcService.setValueLightActuator(actuatorService.getActuatorRequest(name, value)));
    }

    @PostMapping("/actuator_humidity/{value}")
    public ResponseEntity<?> setValueActuatorHumidity(@PathVariable Float value) {
        String name = "actuator_humidity";
        return ok(grpcService.setValueHumidityActuator(actuatorService.getActuatorRequest(name, value)));
    }

}
