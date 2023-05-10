package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Long id_supplier;
    private String supplier;
    @Column(name = "NIT")
    private String nit;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String agent;
    @Column(name = "supplier_address")
    private String supplierAddress;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusU statusU;
}
