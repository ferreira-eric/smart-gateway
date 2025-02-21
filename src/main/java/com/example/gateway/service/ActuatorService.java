package com.example.gateway.service;

import com.example.gateway.ActuatorRequest;
import com.example.gateway.repository.ActuatorRepository;
import com.example.gateway.repository.entity.Actuator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActuatorService {

    @Autowired
    private ActuatorRepository actuatorRepository;

    public ActuatorRequest getActuatorRequest(String name, Float value) {
        Optional<Actuator> actuator = actuatorRepository.findByName(name);

        if (actuator.isPresent()) {
            var actuatorFinal = actuator.get();
            return ActuatorRequest.newBuilder()
                    .setDeviceId(actuatorFinal.getId())
                    .setValue(value)
                    .setName(actuatorFinal.getName())
                    .setActive(actuatorFinal.getActive())
                    .build();
        }

        return null;
    }
}
