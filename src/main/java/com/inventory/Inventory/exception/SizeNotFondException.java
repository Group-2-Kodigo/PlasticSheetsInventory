package com.inventory.Inventory.exception;

public class SizeNotFondException extends RuntimeException{
    public SizeNotFondException(Integer id_size){
        super("Could not found the size with id " + id_size);
    }
}
