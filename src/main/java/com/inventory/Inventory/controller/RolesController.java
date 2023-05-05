package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Roles;
import com.inventory.Inventory.model.Sizes;
import com.inventory.Inventory.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @PostMapping("/add")
    public String add(@RequestBody Roles roles){
        return rolesService.saveRoles(roles);
    }

    @GetMapping("/getAll")
    public List<Roles> getAllRolles(){
        return rolesService.getAllRoles();
    }

    @GetMapping("/getRolesById/{id_rol}")
    public Roles getSizeById(@PathVariable Integer id_rol){
        return rolesService.getRolesByID(id_rol);
    }

    @PutMapping("/updateRol/{id_rol}")
    public Roles updateRol(@RequestBody Roles newRol, @PathVariable Integer id_rol){
        return rolesService.updateRoles(newRol, id_rol);
    }

    @DeleteMapping("/deleteRol/{id_rol}")
    public String deleteRol(@PathVariable Integer id_rol){
        return rolesService.deleteRoles(id_rol);
    }
}
