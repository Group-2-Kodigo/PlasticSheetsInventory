package com.inventory.Inventory.controller;
import com.inventory.Inventory.model.Products;
import com.inventory.Inventory.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping("/add")
    public String add(@RequestBody Products products){
        productsService.saveProducts(products);
        return "New product Added";
    }
    @GetMapping("/getAll")
    public List<Products> getAllProduct(){
        return productsService.getAllProducts();
    }
    @GetMapping("/getproductsbyid/{id_products}")
    public Products getProductsById(@PathVariable Integer id_products){
        return productsService.getProductsById(id_products);
    }

    @PutMapping("/updateproducts/{id_products}")
    public Products updateProducts(@RequestBody Products newProducts, @PathVariable Integer id_products){
        return productsService.updateProducts(newProducts, id_products);
    }

    @DeleteMapping("/deleteproducts/{id_products}")
    public String deleteProducts(@PathVariable Integer id_products){
        return productsService.deleteProducts(id_products);
    }

}
