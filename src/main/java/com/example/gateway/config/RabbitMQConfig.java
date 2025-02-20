package com.example.gateway.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.light.name}")
    public String LIGHT_QUEUE;
    @Value("${spring.rabbitmq.queue.temperature.name}")
    public String TEMPERATURE_QUEUE;
    @Value("${spring.rabbitmq.queue.humidity.name}")
    public String HUMIDITY_QUEUE;

    @Bean
    public Queue ligthQueue() {
        return new Queue(LIGHT_QUEUE, false);
    }

    @Bean
    public Queue temepatureQueue() {
        return new Queue(TEMPERATURE_QUEUE, false);
    }

    @Bean
    public Queue humidityQueue() {
        return new Queue(HUMIDITY_QUEUE, false);
    }
}
