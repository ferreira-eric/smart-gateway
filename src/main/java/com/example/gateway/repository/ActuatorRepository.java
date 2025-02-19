package com.example.gateway.repository;

import com.example.gateway.repository.entity.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActuatorRepository extends JpaRepository<Actuator, Long> {
    Optional<Actuator> findByName(String name);
}
