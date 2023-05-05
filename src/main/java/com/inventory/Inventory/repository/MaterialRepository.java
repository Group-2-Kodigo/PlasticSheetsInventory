package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
