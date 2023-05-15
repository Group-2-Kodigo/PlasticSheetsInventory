package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Roles;
import com.inventory.Inventory.model.Users;

import java.util.List;

public interface UsersService {

    String saveUser(Users users);

    public List<Users> getAllUsers();

    Users getUsersById(Integer id_user);

    Users updateUsers(Users newUser, Integer id_user);

    String deleteUser(Integer id_user);

    Users usersByCredential(Users users);


}
