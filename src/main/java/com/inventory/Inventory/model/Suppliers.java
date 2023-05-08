package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Suppliers {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name= "id_supplier")
private Long id;
private String supplier;
private  String NIT;
private String email;

@Column(name = "phone_number") private String phoneNumber;
private String agent;
@Column(name = "supplier_adress")private String supplierAdress;
}
