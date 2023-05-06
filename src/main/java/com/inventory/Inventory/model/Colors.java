package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data

public class Colors {
    @Id
    @GeneratedValue
    @Column(name = "id_color")
    private Long id_color;
    private String color;

    public Long getId_color() {
        return id_color;
    }

    public void setId_color(Long id_color) {
        this.id_color = id_color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
