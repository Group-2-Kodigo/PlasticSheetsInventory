package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.MaterialNotFoundException;
import com.inventory.Inventory.model.Materials;
import com.inventory.Inventory.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Materials saveMaterial(Materials materials) {
        return materialRepository.save(materials);
    }

    @Override
    public List<Materials> getAllMaterial() {
        return materialRepository.findAll();
    }

    @Override
    public Materials getMaterialById(Integer id_material) {
        return materialRepository.findById(id_material).orElseThrow(()-> new MaterialNotFoundException(id_material));
    }

    @Override
    public Materials updateMaterial(Materials newMaterials, Integer id_material) {
        return materialRepository.findById(id_material).map(material -> {
            material.setMaterials(newMaterials.getMaterials());
            return materialRepository.save(material);
        }).orElseThrow(()->new MaterialNotFoundException(id_material));
    }

    @Override
    public String deleteMaterial(Integer id_material) {
        if (!materialRepository.existsById(id_material)){
            throw new MaterialNotFoundException(id_material);
        }
        materialRepository.deleteById(id_material);
        return "Material with id " + id_material + " has been deleted success";
    }
}
