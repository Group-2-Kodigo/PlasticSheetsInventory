package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data


public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_material")
    private int id_material;
    @Column(name = "material")
    private String materials;
}
