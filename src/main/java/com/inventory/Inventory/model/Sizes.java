package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_size")
    private int id_size;
    private String size;
}
