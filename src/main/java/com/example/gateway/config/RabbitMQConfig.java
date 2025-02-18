package com.example.gateway.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.lamp.name}")
    public String LAMP_QUEUE;

    @Bean
    public Queue sensorQueue() {
        return new Queue(LAMP_QUEUE, true);
    }
}
