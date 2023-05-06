package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
