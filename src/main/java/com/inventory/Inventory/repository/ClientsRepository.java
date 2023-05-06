package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientsRepository extends JpaRepository<Clients, Integer> {

    Clients findByEmail(String email);
}
