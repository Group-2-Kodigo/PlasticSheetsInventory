package com.inventory.Inventory.exception;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(Integer id_movement){
        super("Could not found the movement with id " + id_movement);
    }
}
