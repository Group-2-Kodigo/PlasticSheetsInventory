package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data

public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_color")
    private int id_color;
    private String color;

}
