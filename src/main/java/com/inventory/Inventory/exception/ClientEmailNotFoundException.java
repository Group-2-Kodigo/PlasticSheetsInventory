package com.inventory.Inventory.exception;

public class ClientEmailNotFoundException extends RuntimeException {

    public ClientEmailNotFoundException(String email){
        super("No client found with email: " + email);
    }
}
