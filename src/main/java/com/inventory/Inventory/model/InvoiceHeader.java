package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity @Data
@Table(name = "invoiceheader")
public class InvoiceHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice")
    private Long id_invoice;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "date_invoice")
    private Date dateInvoice;

    @ManyToOne
    @JoinColumn(name = "id_movement")
    private Movements movements;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Suppliers suppliers;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Clients clients;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;



}
