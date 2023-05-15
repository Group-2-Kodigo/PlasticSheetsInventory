package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data @Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Long id_supplier;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "NIT")
    private String nit;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "agent")
    private String agent;
    @Column(name = "supplier_address")
    private String supplierAddress;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusU statusU;
}
