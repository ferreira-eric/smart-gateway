package com.example.gateway.event;

import com.example.gateway.DeviceStatus;
import com.example.gateway.service.SensorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SensorEventListener {

    @Autowired
    private SensorService sensorService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.lamp.name}")
    public void receiveMessage(@Payload DeviceStatus deviceStatus) {
        log.info("Receive Message of the sensor {} with value: {}",
                deviceStatus.getName(), deviceStatus.getValue());

        sensorService.updateSensor(deviceStatus);
    }
}