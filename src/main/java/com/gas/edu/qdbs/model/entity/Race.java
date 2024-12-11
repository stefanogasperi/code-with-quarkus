package com.gas.edu.qdbs.model.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Race extends PanacheEntity {
    private String eventName;
    private LocalDate eventDate;

    private String eventCity;

//    private Uni<String> uniEventCity;
}
