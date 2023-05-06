package com.inventory.Inventory.repository;

import com.inventory.Inventory.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsersRepository extends JpaRepository<Users, Integer> {

}
