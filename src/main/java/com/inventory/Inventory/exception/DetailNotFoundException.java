package com.inventory.Inventory.exception;

public class DetailNotFoundException extends RuntimeException {
    public DetailNotFoundException(Long id_invoiced){
        super("Could not find the id");
    }
}
