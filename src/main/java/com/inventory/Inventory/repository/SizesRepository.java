package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesRepository extends JpaRepository<Sizes, Integer> {
}
