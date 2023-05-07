package com.inventory.Inventory.exception;

public class SupplierNotFoundException extends RuntimeException{
    public SupplierNotFoundException(Long id_supplier){
        super ("Could not found the supplier with id "+id_supplier);
    }
}