package com.inventory.Inventory.validators;


import com.inventory.Inventory.exception.UsersException;
import com.inventory.Inventory.model.Users;

public class UserValidator {
    public static boolean validateUser(Users user) throws UsersException {
        if (user == null) {
            throw new UsersException("User cannot be null.");
        }

        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new UsersException("User name cannot be null or empty.");
        }

        if (user.getUserPassword() == null || user.getUserPassword().isEmpty()) {
            throw new UsersException("Password cannot be null or empty.");
        }

        if (!user.getUserName().matches("[a-zA-Z0-9]+")) {
            throw new UsersException("User name should not contain special characters.");
        }

        return true;
    }
}
