package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Roles;

import java.util.List;

public interface RolesService {
    String saveRoles(Roles roles);

    public List<Roles> getAllRoles();

    Roles getRolesByID(Integer id_rol);

    Roles updateRoles(Roles newRol, Integer id_rol);

    String deleteRoles(Integer id_rol);
}
