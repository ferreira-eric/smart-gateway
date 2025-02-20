package com.example.gateway.service;

import com.example.gateway.DeviceStatus;
import com.example.gateway.dto.SensorDTO;
import com.example.gateway.repository.SensorRepository;
import com.example.gateway.repository.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Scheduled(fixedRate = 5000) //5 s
    public void checkAndDeactivateInactiveSensors() {
        LocalDateTime threshold = LocalDateTime.now().withSecond(5); // Define a limit time
        List<Sensor> inactiveSensors = sensorRepository.findByActiveTrueAndUpdatedAtBefore(threshold);

        if (!inactiveSensors.isEmpty()) {
            inactiveSensors.forEach(sensor ->
                    sensor.setActive(false));
            sensorRepository.saveAll(inactiveSensors);
        }
    }

    public void updateSensor(DeviceStatus deviceStatus) {
        Optional<Sensor> sensor = sensorRepository.findByName(deviceStatus.getName());

        if (sensor.isPresent()) {
            var sensorUpdate = sensor.get();
            sensorUpdate.setValueField(deviceStatus.getValue());
            sensorUpdate.setActive(true);
            sensorUpdate.setUpdatedAt(LocalDateTime.now());
            sensorRepository.save(sensorUpdate);
        } else {
            var sensorSave = Sensor.builder()
                    .valueField(deviceStatus.getValue())
                    .active(true)
                    .unit(deviceStatus.getUnit())
                    .name(deviceStatus.getName())
                    .updatedAt(LocalDateTime.now())
                    .build();

            sensorRepository.save(sensorSave);
        }
    }

    public List<SensorDTO> getAllSensorsActive() {
        return sensorRepository.findAllActiveSensors()
                .stream()
                .map(SensorDTO::deserialize)
                .collect(Collectors.toList());
    }
}
