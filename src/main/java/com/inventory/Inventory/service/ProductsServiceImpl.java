package com.inventory.Inventory.service;
import com.inventory.Inventory.exception.ProductsNotFoundException;
import com.inventory.Inventory.model.Products;
import com.inventory.Inventory.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public Products saveProducts(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProductsById(Integer id_product) {
        return productsRepository.findById(id_product).orElseThrow(()-> new ProductsNotFoundException(id_product));
    }

    @Override
    public Products updateProducts(Products newProducts, Integer id_product) {
        return productsRepository.findById(id_product).map(products -> {
            products.setProduct(newProducts.getProduct());
            return productsRepository.save(products);
        }).orElseThrow(()->new ProductsNotFoundException(id_product));
    }

    @Override
    public String deleteProducts(Integer id_product) {
        if (!productsRepository.existsById(id_product)){
            throw new ProductsNotFoundException(id_product);
        }
        productsRepository.deleteById(id_product);
        return "Product with id " + id_product + " has been deleted success";
    }

}
