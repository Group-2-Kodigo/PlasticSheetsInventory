package com.inventory.Inventory.validators;

public class PhoneNumberValidator {
    public static boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber != null && phoneNumber.matches("\\d{8}");
    }
}
