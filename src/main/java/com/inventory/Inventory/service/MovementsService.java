package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Movements;

import java.util.List;

public interface MovementsService {

    String saveMovement(Movements movements);

    public List<Movements> getAllMovements();

    Movements getMovementById(Integer id_movement);

    Movements updateMovement(Movements newMovement, Integer id_movement);

    String deleteMovement(Integer id_movement);
}
