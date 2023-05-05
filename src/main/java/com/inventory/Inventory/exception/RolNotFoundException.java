package com.inventory.Inventory.exception;

public class RolNotFoundException extends RuntimeException {
    public RolNotFoundException(Integer id_rol){
        super("Could not found the rol with id " + id_rol);
    }
}
