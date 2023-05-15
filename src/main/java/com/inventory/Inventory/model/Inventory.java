package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity @Data @Table(name = "inventory")

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventory")
    private Long id_inventory;
    @ManyToOne
    @JoinColumn(name = "id_movement")
    Movements movement;
    @ManyToOne
    @JoinColumn(name = "id_user")
    Users user;
    @ManyToOne
    @JoinColumn(name = "id_product")
    Products product;
    @ManyToOne
    @JoinColumn(name = "id_invoice")
    InvoiceHeader invoiceHeader;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "movement_date")
    private LocalDate movementDate;
    @Column(name = "movement_hour")
    private LocalTime movementHour;
}
