package com.inventory.Inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class Suppliers {
@Id
@GeneratedValue
@Column(name= "id_supplier")
private Long id;
private String supplier;
private  String NIT;
private String email;
private String phoneNumber;
private String agent;
private String supplierAdress;
}
