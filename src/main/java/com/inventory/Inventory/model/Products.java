package com.inventory.Inventory.model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Data @Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int id_product;
    @Column(name = "product")
    private String product;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "thickness")
    private String thickness;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    @Column(name = "stock") private int stock;
    @ManyToOne
    @JoinColumn(name = "id_color")
    Colors color;

    @ManyToOne
    @JoinColumn(name = "id_material")
    Material material;

    @ManyToOne
    @JoinColumn(name = "id_size")
    Sizes size;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    Suppliers supplier;
}
