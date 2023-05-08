package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_supplier")
    private Long id;
    private String supplier;
    private String NIT;
    private String email;
    private String phoneNumber;
    private String agent;
    private String supplierAddress;
}
