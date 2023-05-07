package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.MaterialNotFoundException;
import com.inventory.Inventory.exception.SupplierNotFoundException;
import com.inventory.Inventory.model.Material;
import com.inventory.Inventory.model.Suppliers;
import com.inventory.Inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public Suppliers saveSupplier(Suppliers suppliers) {
        return supplierRepository.save(suppliers);
    }

    @Override
    public List<Suppliers> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Suppliers getSupplierById(Long id_supplier) {
        return supplierRepository.findById(id_supplier).orElseThrow(()->new SupplierNotFoundException(id_supplier));
    }

    @Override
    public Suppliers updateSupplier(Suppliers newSupplier, Long id_supplier) {
        return supplierRepository.findById(id_supplier).map(suppliers -> {
            suppliers.setSupplier(newSupplier.getSupplier());
            suppliers.setEmail(newSupplier.getEmail());
            suppliers.setPhoneNumber(newSupplier.getPhoneNumber());
            suppliers.setAgent(newSupplier.getAgent());
            suppliers.setSupplierAdress(newSupplier.getSupplierAdress());
            suppliers.setNIT(newSupplier.getNIT());
            return supplierRepository.save(suppliers);
        }).orElseThrow(() -> new SupplierNotFoundException(id_supplier));
    }

    @Override
    public String deleteSupplier(Long id_supplier) {
        if (!supplierRepository.existsById(id_supplier)){
            throw new SupplierNotFoundException(id_supplier);
        }
        supplierRepository.deleteById(id_supplier);
        return "Supplier with id " + id_supplier + " has been deleted success";
    }
}
