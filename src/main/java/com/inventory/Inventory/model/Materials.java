package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "materials")
public class Materials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private int id_material;
    @Column(name = "material")
    private String materials;
}
