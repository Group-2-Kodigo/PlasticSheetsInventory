package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data @Table(name = "statusu")
public class StatusU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private int id_status;
    @Column(name = "status_name")
    private String statusName;
}
