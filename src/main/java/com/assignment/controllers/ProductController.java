package com.assignment.controllers;

import com.assignment.dba.ProductDB;
import com.assignment.exceptions.NoProductWithIDException;
import com.assignment.models.product.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductDB productDB;
    public ProductController(ProductDB productDB){
        this.productDB = productDB;
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable String productId){
        Product product = null;
        try {
            product = productDB.getProductById(productId);
        }catch (NoProductWithIDException exception){
            System.out.println(exception.getMessage());
        }
        return product;
    }

    @PutMapping("/product/add")
    public String addProduct(@RequestBody Product product){
        productDB.addProduct(product);
        return "Product with ID : "+product.getProductID()+" created successfully";
    }

    public ProductDB getProductDB() {
        return productDB;
    }

    public void setProductDB(ProductDB productDB) {
        this.productDB = productDB;
    }
}
