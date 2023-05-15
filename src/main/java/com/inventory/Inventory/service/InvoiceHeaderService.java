package com.inventory.Inventory.service;

import com.inventory.Inventory.model.InvoiceHeader;

import java.util.List;

public interface InvoiceHeaderService {

    String saveInvoice(InvoiceHeader invoiceHeader);

    public List<InvoiceHeader> getAllInvoices();

    InvoiceHeader getInvoiceById(Long id_invoice);

    InvoiceHeader updateInvoice(InvoiceHeader newInvoice, Long id_invoice);

    String deletInvoice(Long id_invoice);
}
