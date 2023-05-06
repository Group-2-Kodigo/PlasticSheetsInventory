package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Colors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Colors, Integer> {
}
