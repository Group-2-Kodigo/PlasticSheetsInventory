package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @Getter @Setter
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int id_product;

    private String product;

    private float unitPrice;

    private String thickness;

    private float sellingPrice;

    private int Stock;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private Colors colors;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Sizes sizes;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    public Products(int id_product, String product, float unitPrice, String thickness, float sellingPrice, int stock, Material material, Sizes sizes, Colors colors) {
        super();
        this.id_product = id_product;
        this.product = product;
        this.unitPrice = unitPrice;
        this.thickness = thickness;
        this.sellingPrice = sellingPrice;
        Stock = stock;
        this.material = material;
        this.sizes = sizes;
        this.colors = colors;
    }

    public Products(String product, float unitPrice, String thickness, float sellingPrice, int stock, Material material, Sizes sizes, Colors colors) {
        super();
        this.product = product;
        this.unitPrice = unitPrice;
        this.thickness = thickness;
        this.sellingPrice = sellingPrice;
        Stock = stock;
        this.material = material;
        this.sizes = sizes;
        this.colors = colors;
    }

    public Products(String product) {
        super();
        this.product = product;
    }
}
