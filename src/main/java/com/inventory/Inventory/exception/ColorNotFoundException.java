package com.inventory.Inventory.exception;

public class ColorNotFoundException extends RuntimeException{
    public ColorNotFoundException(Integer id_color){
        super ("Color with ID " + id_color +  " not found");
    }
}
