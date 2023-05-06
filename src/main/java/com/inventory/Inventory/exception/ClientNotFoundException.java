package com.inventory.Inventory.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Integer id_client){
        super("Could not found the client with id " + id_client);
    }
}
