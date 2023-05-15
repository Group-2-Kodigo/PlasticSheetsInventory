package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Materials, Integer> {
}
