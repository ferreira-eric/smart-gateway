package com.example.gateway.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "sensor")
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float value;
    private String unit;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PreUpdate
    @PrePersist
    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }
}
