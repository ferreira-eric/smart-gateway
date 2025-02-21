package com.example.gateway.service;

import com.example.gateway.ActuatorRequest;
import com.example.gateway.ActuatorServiceGrpc;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GrpcService {

    private final ActuatorServiceGrpc.ActuatorServiceBlockingStub temperatureStub;
    private final ActuatorServiceGrpc.ActuatorServiceBlockingStub lightStub;
    private final ActuatorServiceGrpc.ActuatorServiceBlockingStub humidityStub;

    public GrpcService(@Qualifier("temperatureStub") ActuatorServiceGrpc.ActuatorServiceBlockingStub temperatureStub,
                       @Qualifier("lightStub") ActuatorServiceGrpc.ActuatorServiceBlockingStub lightStub,
                       @Qualifier("humidityStub") ActuatorServiceGrpc.ActuatorServiceBlockingStub humidityStub) {
        this.temperatureStub = temperatureStub;
        this.lightStub = lightStub;
        this.humidityStub = humidityStub;
    }

    public String setValueTemperatureActuator(ActuatorRequest request) {
        return temperatureStub.setValue(request).getSuccess();
    }

    public String setValueLightActuator(ActuatorRequest request) {
        return lightStub.setValue(request).getSuccess();
    }

    public String setValueHumidityActuator(ActuatorRequest request) {
        return humidityStub.setValue(request).getSuccess();
    }
}

