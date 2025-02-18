package com.example.gateway.repository;

import com.example.gateway.repository.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByActiveTrueAndUpdatedAtBefore(LocalDateTime threshold);

    Optional<Sensor> findByName(String name);

    @Query() //TODO QUERY
    List<Sensor> findByNameWhenActiveIsTrueActiveIsTrue(String name);
}
