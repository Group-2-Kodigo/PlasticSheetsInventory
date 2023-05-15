package com.inventory.Inventory.service;

import com.inventory.Inventory.model.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailService {

    String saveInvoiceDetail(InvoiceDetail invoiceDetail);

    public List<InvoiceDetail> getAllInvoiceDetail();

    InvoiceDetail getInvoiceDetailById(Long id_invoiceDetail);

    InvoiceDetail updateInvoiceDetail(InvoiceDetail newInvoiceDetail, Long id_invoiceDetail);

    String deleteInvoiceDetail(Long id_invoiceDetail);
}
