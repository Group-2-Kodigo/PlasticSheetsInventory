package com.inventory.Inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Color {
    @Id
    @GeneratedValue
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
