package com.inventory.Inventory.model;

import com.inventory.Inventory.service.StatusService;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
@Table(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int id_client;
    @Column(name = "client_name") private String clientName;
    @Column(name = "phone_number") private String phoneNumber;
    @Column(name = "email") private String email;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusU statusU;
}
