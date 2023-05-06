package com.inventory.Inventory.exception;

public class InvalidPhoneNumberException extends RuntimeException {

    public InvalidPhoneNumberException(String phoneNumber){
        super("The phone number entered is not valid.");
    }

}
