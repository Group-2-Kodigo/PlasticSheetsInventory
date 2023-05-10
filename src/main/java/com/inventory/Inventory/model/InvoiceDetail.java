package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
@Table(name = "invoicedetail")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice_detail")
    private Long id_invoiced;

    @Column(name = "invoice_detail_number")
    private String invoice_number;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "id_invoice")
    private InvoiceHeader invoiceHeader;

    @Column(name = "invoice_quantity")
    private Integer quantity;

    @Column(name = "sub_total")
    private Double subtotal;
}
