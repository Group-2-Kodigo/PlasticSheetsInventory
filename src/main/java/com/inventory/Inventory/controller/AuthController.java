package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Users;
import com.inventory.Inventory.service.UsersService;
import com.inventory.Inventory.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/verifyusers", method = RequestMethod.POST)
    public String Login(@RequestBody Users users){

        Users usersIsLogged = usersService.usersByCredential(users);
        if (usersIsLogged != null){

            String tokenJwt = jwtUtil.create(String.valueOf(usersIsLogged.getId_user()), usersIsLogged.getUserName());

            return tokenJwt;
        }
        return "Wrong User or password, please verify";
    }
}
