package com.inventory.Inventory.controller;

import com.inventory.Inventory.exception.SupplierNotFoundException;
import com.inventory.Inventory.model.Suppliers;
import com.inventory.Inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;
    @PostMapping("/supplier")
    Suppliers newSupplier(@RequestBody Suppliers newSuppliers){
        return supplierRepository.save(newSuppliers);}

    @GetMapping("/supplier")
    List<Suppliers> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    @GetMapping("/supplier/{id}")
    Suppliers getSupplierById(@PathVariable Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(()->new SupplierNotFoundException(id));
    }

    @PutMapping("/supplier/{id}")
    Suppliers updateSupplier(@RequestBody Suppliers newSuppliers, @PathVariable Long id){
        return supplierRepository.findById(id)
                .map(suppliers -> {
                    suppliers.setSupplier(newSuppliers.getSupplier());
                    suppliers.setSupplierAdress(newSuppliers.getSupplierAdress());
                    suppliers.setAgent(newSuppliers.getAgent());
                    suppliers.setEmail(newSuppliers.getEmail());
                    suppliers.setNIT(newSuppliers.getNIT());
                    suppliers.setPhoneNumber(newSuppliers.getPhoneNumber());
                    return supplierRepository.save(suppliers);
                }).orElseThrow(()->new SupplierNotFoundException(id));
    }

    @DeleteMapping("/supplier/{id}")
    String deleteSupplier (@PathVariable Long id){
        if (!supplierRepository.existsById(id)){
            throw new SupplierNotFoundException(id);
        }
        supplierRepository.deleteById(id);
        return "Supplier con id "+id+ " ha sido eliminado correctamente.";
    }

}
