package com.inventory.Inventory.exception;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String email){
        super("The Email Address entered is not valid");
    }
}
