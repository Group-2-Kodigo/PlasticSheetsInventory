package com.inventory.Inventory.service;


import com.inventory.Inventory.exception.DetailNotFoundException;
import com.inventory.Inventory.model.InvoiceDetail;
import com.inventory.Inventory.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
    @Override
    public String saveInvoiceDetail(InvoiceDetail invoiceDetail) {
        invoiceDetailRepository.save(invoiceDetail);
        return "New invoice has added";
    }

    @Override
    public List<InvoiceDetail> getAllInvoiceDetail() {
        return invoiceDetailRepository.findAll();
    }

    @Override
    public InvoiceDetail getInvoiceDetailById(Long id_invoiced) {
        return invoiceDetailRepository.findById(id_invoiced).orElseThrow(()->new DetailNotFoundException(id_invoiced));
    }


    @Override
    public InvoiceDetail updateInvoiceDetail(InvoiceDetail newInvoiceDetail, Long id_invoiced) {
        return invoiceDetailRepository.findById(id_invoiced).map(invoiceDetail -> {
            invoiceDetail.setInvoice_number(newInvoiceDetail.getInvoice_number());
            invoiceDetail.setProducts(newInvoiceDetail.getProducts());
            invoiceDetail.setInvoiceHeader(newInvoiceDetail.getInvoiceHeader());
            invoiceDetail.setQuantity(newInvoiceDetail.getQuantity());
            invoiceDetail.setSubtotal(newInvoiceDetail.getSubtotal());
            return invoiceDetailRepository.save(invoiceDetail);
        }).orElseThrow(() -> new DetailNotFoundException(id_invoiced));
    }
    @Override
    public String deleteInvoiceDetail(Long id_invoiced) {
        if (!invoiceDetailRepository.existsById(id_invoiced)){
            throw new DetailNotFoundException(id_invoiced);
        }
        invoiceDetailRepository.deleteById(id_invoiced);
        return "Invoice with id " + id_invoiced + " has been deleted success";
    }
}
