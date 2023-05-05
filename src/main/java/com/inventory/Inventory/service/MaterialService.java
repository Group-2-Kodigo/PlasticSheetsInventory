package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Material;

import java.util.List;

public interface MaterialService {

    Material saveMaterial(Material material);

    public List<Material> getAllMaterial();

    Material getMaterialById(Integer id_material);

    Material updateMaterial(Material newMaterial, Integer id_material);

    String deleteMaterial(Integer id_material);

}
