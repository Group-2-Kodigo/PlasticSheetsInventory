package com.inventory.Inventory.service;
import com.inventory.Inventory.model.Products;
import java.util.List;
public interface ProductsService {
    Products saveProducts(Products products);
    public List<Products> getAllProducts();
    Products getProductsById(Integer id_product);
    Products updateProducts(Products newProducts, Integer id_product);
    String deleteProducts(Integer id_product);
}
