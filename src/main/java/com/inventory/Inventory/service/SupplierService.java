package com.inventory.Inventory.service;
import com.inventory.Inventory.model.Suppliers;
import java.util.List;

public interface SupplierService {
    String saveSupplier(Suppliers suppliers);

    public List<Suppliers> getAllSuppliers();

    Suppliers getSupplierById(Long id_supplier);

    Suppliers updateSupplier(Suppliers newSupplier, Long id_supplier);

    String deleteSupplier(Long id_supplier);
}
