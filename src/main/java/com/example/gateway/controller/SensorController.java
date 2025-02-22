package com.example.gateway.controller;

import com.example.gateway.dto.SensorDTO;
import com.example.gateway.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @GetMapping()
    public List<SensorDTO> getAllSensor() {
        return ok(sensorService.getAllSensors()).getBody();
    }
}
