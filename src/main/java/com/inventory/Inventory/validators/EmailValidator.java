package com.inventory.Inventory.validators;

public class EmailValidator {
    public static boolean isValidEmail(String email){
        return email != null && email.matches(".+@.+\\..+");
    }
}
