package com.example.gateway.event;

import com.example.gateway.DeviceStatus;
import com.example.gateway.service.SensorService;
import com.google.protobuf.InvalidProtocolBufferException;
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

    @RabbitListener(queues = "${spring.rabbitmq.queue.light.name}")
    public void receiveMessageLight(@Payload byte[] data) throws InvalidProtocolBufferException {
        DeviceStatus deviceStatus = DeviceStatus.parseFrom(data);
        log.info("Receive Message of the light sensor with value: {}",
                deviceStatus.getValue());

        sensorService.updateSensor(deviceStatus);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.humidity.name}")
    public void receiveMessageHumidity(@Payload byte[] data) throws InvalidProtocolBufferException {
        DeviceStatus deviceStatus = DeviceStatus.parseFrom(data);
        log.info("Receive Message of the humidity sensor with value: {}",
                deviceStatus.getValue());

        sensorService.updateSensor(deviceStatus);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.temperature.name}")
    public void receiveMessageTemperature(@Payload byte[] data) throws InvalidProtocolBufferException{
        DeviceStatus deviceStatus = DeviceStatus.parseFrom(data);
        log.info("Receive Message of the temperature sensor with value: {}",
                deviceStatus.getValue());

        sensorService.updateSensor(deviceStatus);
    }
}