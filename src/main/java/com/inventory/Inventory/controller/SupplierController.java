package com.inventory.Inventory.controller;
import com.inventory.Inventory.model.Suppliers;
import com.inventory.Inventory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Suppliers")
@CrossOrigin
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    public String newSupplier(@RequestBody Suppliers newSuppliers){
        supplierService.saveSupplier(newSuppliers);
        return "New Supplier Added";
    }

    @GetMapping("/getallsupplier")
    public List<Suppliers> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/getsupplierbyid/{id_supplier}")
    public Suppliers getSupplierById(@PathVariable Long id_supplier) {
        return supplierService.getSupplierById(id_supplier);
    }

    @PutMapping("/updateSupplier/{id_supplier}")
    public Suppliers updateSupplier(@RequestBody Suppliers newSupplier, @PathVariable Long id_supplier){
        return supplierService.updateSupplier(newSupplier, id_supplier);
    }

    @DeleteMapping("/deletesupplier/{id_supplier}")
    public String deleteSupplier (@PathVariable Long id_supplier){
        return supplierService.deleteSupplier(id_supplier);
    }

}
