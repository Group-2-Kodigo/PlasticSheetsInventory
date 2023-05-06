package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
