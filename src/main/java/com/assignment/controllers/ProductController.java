package com.assignment.controllers;

import com.assignment.dba.ProductDB;
import com.assignment.exceptions.NoProductWithIDException;
import com.assignment.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/product/add/{productId}/{price}")
    public String addProduct(@PathVariable String productId, @PathVariable String price){
        double priceOfProduct;
        try{
            priceOfProduct = Double.parseDouble(price);
        }catch (NumberFormatException exception){
            return "Cannot create Product with price : "+price;
        }
        Product product = new Product(productId,priceOfProduct);
        productDB.addProduct(product);
        return "Product with ID : "+productId+" created successfully";
    }

    public ProductDB getProductDB() {
        return productDB;
    }

    public void setProductDB(ProductDB productDB) {
        this.productDB = productDB;
    }
}
