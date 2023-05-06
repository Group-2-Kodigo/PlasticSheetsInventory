package com.inventory.Inventory.exception;

public class UsersException extends RuntimeException {
    public UsersException(String message) {
        super(message);
    }

    public static boolean isUserNameValid(String userName) {
        return userName.matches("[a-zA-Z0-9]+");
    }

    public String getDetailedMessage() {
        return "User name should not contain special characters.";
    }
}
