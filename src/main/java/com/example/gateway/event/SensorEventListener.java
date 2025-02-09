package com.example.gateway.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SensorEventListener {

    @RabbitListener(queues = "queue_sensors")
    public void receiveMessage(String mensagem) {
        System.out.println("Mensagem recebida do sensor: " + mensagem);
        //TODO
    }
}