package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Materials;

import java.util.List;

public interface MaterialService {

    Materials saveMaterial(Materials materials);

    public List<Materials> getAllMaterial();

    Materials getMaterialById(Integer id_material);

    Materials updateMaterial(Materials newMaterials, Integer id_material);

    String deleteMaterial(Integer id_material);

}
