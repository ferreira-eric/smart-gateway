package com.example.gateway.config;

import com.example.gateway.ActuatorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean(name = "temperatureStub")
    public ActuatorServiceGrpc.ActuatorServiceBlockingStub actuatorTemperatureStub(
            @Value("${grpc.devices.actuator_temperature.host}") String host,
            @Value("${grpc.devices.actuator_temperature.port}") int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        return ActuatorServiceGrpc.newBlockingStub(channel);
    }

    @Bean(name = "lightStub")
    public ActuatorServiceGrpc.ActuatorServiceBlockingStub actuatorLightStub(
            @Value("${grpc.devices.actuator_light.host}") String host,
            @Value("${grpc.devices.actuator_light.port}") int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        return ActuatorServiceGrpc.newBlockingStub(channel);
    }

    @Bean(name = "humidityStub")
    public ActuatorServiceGrpc.ActuatorServiceBlockingStub actuatorHumidityStub(
            @Value("${grpc.devices.actuator_humidity.host}") String host,
            @Value("${grpc.devices.actuator_humidity.port}") int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        return ActuatorServiceGrpc.newBlockingStub(channel);
    }
}
