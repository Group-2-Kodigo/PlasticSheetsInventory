package com.inventory.Inventory.exception;

import com.inventory.Inventory.model.Users;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Integer id_user){
        super("Could not found the User with id " + id_user);
    }
}
