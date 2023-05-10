package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusU statusU;
}


