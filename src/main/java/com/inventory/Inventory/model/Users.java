package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusU statusU;
}


