package com.inventory.Inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Material {

    @Id
    @GeneratedValue
    @Column(name = "id_material")
    private int id_material;
    private String materials;
}
