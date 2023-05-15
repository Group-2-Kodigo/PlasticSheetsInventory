package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Users;
import com.inventory.Inventory.service.UsersService;
import com.inventory.Inventory.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/add")
    public String add(@RequestBody Users users){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash= argon2.hash(1,1024,1,users.getUserPassword());
        users.setUserPassword(hash);
        return usersService.saveUser(users);
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers(@RequestHeader(value = "Authorization")String token) {

        String userId = jwtUtil.getKey(token);
        if (userId == null){
            return new ArrayList<>();
        }

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
