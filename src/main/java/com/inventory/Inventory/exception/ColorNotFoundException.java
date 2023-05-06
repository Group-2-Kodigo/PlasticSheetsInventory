package com.inventory.Inventory.exception;

public class ColorNotFoundException extends RuntimeException{
    public ColorNotFoundException(Long id){
        super ("No se encontró el color con id "+id);
    }
}
