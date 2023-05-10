package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movements, Integer> {
}
