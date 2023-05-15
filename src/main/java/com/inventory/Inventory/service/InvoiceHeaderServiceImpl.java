package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.InvoiceHeaderNotFoundException;
import com.inventory.Inventory.model.InvoiceHeader;
import com.inventory.Inventory.repository.InvoiceHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceHeaderServiceImpl implements InvoiceHeaderService {

    @Autowired
    private InvoiceHeaderRepository invoiceHeaderRepository;

    @Override
    public String saveInvoice(InvoiceHeader invoiceHeader) {
        invoiceHeaderRepository.save(invoiceHeader);
        return "New invoice has added";
    }

    @Override
    public List<InvoiceHeader> getAllInvoices() {
        return invoiceHeaderRepository.findAll();
    }

    @Override
    public InvoiceHeader getInvoiceById(Long id_invoice) {
        return invoiceHeaderRepository.findById(id_invoice).orElseThrow(()->new InvoiceHeaderNotFoundException(id_invoice));
    }

    @Override
    public InvoiceHeader updateInvoice(InvoiceHeader newInvoice, Long id_invoice) {
        return invoiceHeaderRepository.findById(id_invoice).map(invoiceHeader -> {
            invoiceHeader.setInvoiceNumber(newInvoice.getInvoiceNumber());
            invoiceHeader.setMovements(invoiceHeader.getMovements());
            invoiceHeader.setSuppliers(invoiceHeader.getSuppliers());
            invoiceHeader.setClients(invoiceHeader.getClients());
            invoiceHeader.setUsers(invoiceHeader.getUsers());
            invoiceHeader.setDateInvoice(invoiceHeader.getDateInvoice());
            return invoiceHeaderRepository.save(invoiceHeader);
        }).orElseThrow(()-> new InvoiceHeaderNotFoundException(id_invoice));
    }

    @Override
    public String deletInvoice(Long id_invoice) {
        if (!invoiceHeaderRepository.existsById(id_invoice)){
            throw new InvoiceHeaderNotFoundException(id_invoice);
        }
        invoiceHeaderRepository.deleteById(id_invoice);
        return "Invoice with id " + id_invoice + " has been deleted success";
    }
}
