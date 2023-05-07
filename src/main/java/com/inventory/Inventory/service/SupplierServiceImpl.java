package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.InvalidEmailException;
import com.inventory.Inventory.exception.InvalidPhoneNumberException;
import com.inventory.Inventory.exception.SupplierNotFoundException;
import com.inventory.Inventory.model.Suppliers;
import com.inventory.Inventory.repository.SupplierRepository;
import com.inventory.Inventory.validators.EmailValidator;
import com.inventory.Inventory.validators.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public String saveSupplier(Suppliers suppliers) {
        if (!EmailValidator.isValidEmail(suppliers.getEmail())){
            throw new InvalidEmailException(suppliers.getEmail());
        }
        if (!PhoneNumberValidator.isValidPhoneNumber(suppliers.getPhoneNumber())){
            throw new InvalidPhoneNumberException(suppliers.getPhoneNumber());
        }
        supplierRepository.save(suppliers);
        return "New supplier Added";
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
        if (!EmailValidator.isValidEmail(newSupplier.getEmail())){
            throw new InvalidEmailException(newSupplier.getEmail());
        }
        if (!PhoneNumberValidator.isValidPhoneNumber(newSupplier.getPhoneNumber())){
            throw new InvalidPhoneNumberException(newSupplier.getPhoneNumber());
        }
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
