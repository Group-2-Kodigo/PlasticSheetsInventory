package com.inventory.Inventory.model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int id_product;

    private String product;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    private String thickness;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private Colors colors;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Sizes sizes;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;
    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Suppliers suppliers;
}
