package com.inventory.Inventory.exception;

public class ColorNotFoundException extends RuntimeException{
    public ColorNotFoundException(Integer id_color){
        super ("No se encontró el color con id "+id_color);
    }
}
