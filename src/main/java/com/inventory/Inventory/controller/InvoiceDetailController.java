package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.InvoiceDetail;
import com.inventory.Inventory.model.InvoiceHeader;
import com.inventory.Inventory.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoiceDetail")
public class InvoiceDetailController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @PostMapping("/add")
    public String add(@RequestBody InvoiceDetail invoiceDetail){
        return invoiceDetailService.saveInvoiceDetail(invoiceDetail);
    }

    @GetMapping("/getAll")
    public List<InvoiceDetail> getAllDetails(){
        return invoiceDetailService.getAllInvoiceDetail();
    }

    @GetMapping("/getDetailById/{id_invoiced}")
    public InvoiceDetail getDetailById(@PathVariable Long id_invoiced){
        return invoiceDetailService.getInvoiceDetailById(id_invoiced);
    }

    @PutMapping("/updateDetail/{id_invoiced}")
    public InvoiceDetail updateDetail(@RequestBody InvoiceDetail newInvoiceDetail, @PathVariable Long id_invoiced){
        return invoiceDetailService.updateInvoiceDetail(newInvoiceDetail, id_invoiced);
    }

    @DeleteMapping("/deleteDetail/{id_invoiced}")
    public String deleteDetail(@PathVariable Long id_invoiced){
        return invoiceDetailService.deleteInvoiceDetail(id_invoiced);
    }
}
