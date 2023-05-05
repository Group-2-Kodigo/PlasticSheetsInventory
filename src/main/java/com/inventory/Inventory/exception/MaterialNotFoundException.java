package com.inventory.Inventory.exception;

public class MaterialNotFoundException extends RuntimeException{

    public MaterialNotFoundException(Integer id_material){
        super("Could not found the material with id " + id_material);
    }
}
