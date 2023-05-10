package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Movements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movement")
    private int id_movement;
    private String movement;
}
