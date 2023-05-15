package com.inventory.Inventory.controller;

import com.inventory.Inventory.exception.SupplierNotFoundException;
import com.inventory.Inventory.model.Suppliers;
import com.inventory.Inventory.repository.SupplierRepository;
import com.inventory.Inventory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @PostMapping("/add")
    public String add(@RequestBody Suppliers suppliers){
        return supplierService.saveSupplier(suppliers);
    }

    @GetMapping("/getAll")
    public List<Suppliers> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/getSupplierById/{id_supplier}")
    public Suppliers getSupplierId(@PathVariable Long id_supplier){
        return supplierService.getSupplierByID(id_supplier);
    }

    @PutMapping("/updateSupplier/{id_supplier}")
    public Suppliers updateSupplier(@RequestBody Suppliers newSupplier, @PathVariable Long id_supplier){
        return supplierService.updateSupplier(newSupplier, id_supplier);
    }

    @DeleteMapping("/deleteSupplier/{id_supplier}")
    public String deleteSupplier(@PathVariable Long id_supplier){
        return supplierService.deleteSupplier(id_supplier);

    }
}
