package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.InvoiceHeader;
import com.inventory.Inventory.service.InvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoiceHeader")
public class InvoiceHeaderController {
    @Autowired
    private InvoiceHeaderService invoiceHeaderService;

    @PostMapping("/add")
    public String add(@Validated @RequestBody InvoiceHeader invoiceHeader){
        return invoiceHeaderService.saveInvoice(invoiceHeader);
    }

    @GetMapping("/getAll")
    public List<InvoiceHeader> getAllInvoices(){
        return invoiceHeaderService.getAllInvoices();
    }

    @GetMapping("/getInvoiceById/{id_invoice}")
    public InvoiceHeader getInvoiceById(@PathVariable Long id_invoice){
        return invoiceHeaderService.getInvoiceById(id_invoice);
    }

    @PutMapping("/updateInvoice/{id_invoice}")
    public InvoiceHeader updateInvoice(@RequestBody InvoiceHeader newInvoice, @PathVariable Long id_invoice){
        return invoiceHeaderService.updateInvoice(newInvoice, id_invoice);
    }

    @DeleteMapping("/deleteInvoice/{id_invoice}")
    public String deleteInvoice(@PathVariable Long id_invoice){
        return invoiceHeaderService.deletInvoice(id_invoice);
    }

}
