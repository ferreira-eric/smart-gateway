package com.example.gateway.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String SENSOR_QUEUE = "queue_sensors";

    @Bean
    public Queue sensorQueue() {
        return new Queue(SENSOR_QUEUE, true);
    }
}
