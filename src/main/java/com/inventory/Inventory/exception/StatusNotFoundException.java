package com.inventory.Inventory.exception;

public class StatusNotFoundException extends RuntimeException {
    public StatusNotFoundException(Integer id_status){
        super("No status found with id: " + id_status);
    }
}
