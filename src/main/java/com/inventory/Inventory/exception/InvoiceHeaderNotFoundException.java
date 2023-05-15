package com.inventory.Inventory.exception;

public class InvoiceHeaderNotFoundException extends RuntimeException{
    public InvoiceHeaderNotFoundException(Long id_invoice){
        super("Could not found the invoice with id " + id_invoice);
    }
}
