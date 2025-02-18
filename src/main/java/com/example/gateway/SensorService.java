package com.example.gateway;

import com.example.gateway.repository.SensorRepository;
import com.example.gateway.repository.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Scheduled(fixedRate = 60000) //60 s
    public void checkAndDeactivateInactiveSensors() {
        LocalDateTime threshold = LocalDateTime.now().minusMinutes(1); // Define a limit time: 1 min
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
            sensorUpdate.setValue(deviceStatus.getValue());
            sensorUpdate.setActive(true);
            sensorUpdate.setUpdatedAt(LocalDateTime.now());
            sensorRepository.save(sensorUpdate);
        } else {
            var sensorSave = Sensor.builder()
                    .value(deviceStatus.getValue())
                    .active(true)
                    .unit(deviceStatus.getUnit())
                    .name(deviceStatus.getName())
                    .updatedAt(LocalDateTime.now())
                    .build();

            sensorRepository.save(sensorSave);
        }
    }

    public List<Sensor> getAllSensorsActive() {
        return sensorRepository.findAll();
    }
}
