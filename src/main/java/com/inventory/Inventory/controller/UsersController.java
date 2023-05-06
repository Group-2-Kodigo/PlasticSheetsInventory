package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Roles;
import com.inventory.Inventory.model.Users;
import com.inventory.Inventory.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public String add(@RequestBody Users users){
        return usersService.saveUser(users);
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/getUserById/{id_user}")
    public Users getUsersById(@PathVariable Integer id_user){
        return usersService.getUsersById(id_user);
    }

    @PutMapping("/updateUserById/{id_user}")
    public Users updateUserById(@RequestBody Users newUser, @PathVariable Integer id_user){
        return usersService.updateUsers(newUser, id_user);
    }

    @DeleteMapping("/deleteUser/{id_user}")
    public String deleteUser(@PathVariable Integer id_user){
        return usersService.deleteUser(id_user);
    }

}
