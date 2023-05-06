package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.UsersException;
import com.inventory.Inventory.exception.UsersNotFoundException;
import com.inventory.Inventory.model.Users;
import com.inventory.Inventory.repository.UsersRepository;
import com.inventory.Inventory.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public String saveUser(Users users) {
        if (!UserValidator.validateUser(users)) {
            throw new UsersException("Invalid user.");
        }
        usersRepository.save(users);
        return "New User has added";
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUsersById(Integer id_user) {
        return usersRepository.findById(id_user).orElseThrow(() -> new UsersNotFoundException(id_user));
    }

    @Override
    public Users updateUsers(Users newUser, Integer id_user) {
        if (!UserValidator.validateUser(newUser)){
            throw new UsersException("Invalid User");
        }
        return usersRepository.findById(id_user).map(users -> {
            users.setUserName(newUser.getUserName());
            users.setUserPassword(newUser.getUserPassword());
            users.setRoles(newUser.getRoles());
            return usersRepository.save(users);
        }).orElseThrow(()->new UsersNotFoundException(id_user));
    }

    @Override
    public String deleteUser(Integer id_user) {
        if(!usersRepository.existsById(id_user)) {
            throw new UsersNotFoundException(id_user);
        }
        usersRepository.deleteById(id_user);
        return "Client with id " + id_user + " has been deleted success";
    }

}
