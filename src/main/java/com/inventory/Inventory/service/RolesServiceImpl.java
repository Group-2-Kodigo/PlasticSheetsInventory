package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.RolNotFoundException;
import com.inventory.Inventory.model.Roles;
import com.inventory.Inventory.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public String saveRoles(Roles roles) {
        rolesRepository.save(roles);
        return "New rol has added";
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getRolesByID(Integer id_rol) {
        return rolesRepository.findById(id_rol).orElseThrow(()->new RolNotFoundException(id_rol));
    }

    @Override
    public Roles updateRoles(Roles newRol, Integer id_rol) {
        return rolesRepository.findById(id_rol).map(roles -> {
            roles.setRol(newRol.getRol());
            return rolesRepository.save(roles);
        }).orElseThrow(()->new RolNotFoundException(id_rol));
    }

    @Override
    public String deleteRoles(Integer id_rol) {
        if(!rolesRepository.existsById(id_rol)){
            throw new RolNotFoundException(id_rol);
        }
        rolesRepository.deleteById(id_rol);
        return "Rol with id " + id_rol + " has been deleted success";
    }
}
