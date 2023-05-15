package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
}
