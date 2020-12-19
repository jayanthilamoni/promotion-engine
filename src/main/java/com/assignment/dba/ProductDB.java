package com.assignment.dba;

import com.assignment.exceptions.NoProductWithIDException;
import com.assignment.models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDB {
    private static ProductDB productDB;
    private final Map<String, Product> products;
    private ProductDB(){
        products = new HashMap<>();
    }
    public static ProductDB getInstance(){
        if(productDB == null){
            productDB = new ProductDB();
        }
        return productDB;
    }

    public Product getProductById(String productId) throws NoProductWithIDException {
        if(!products.containsKey(productId)){
            throw  new NoProductWithIDException("Product With ID "+productId+" is not present");
        }
        return products.get(productId);
    }

    public void addProduct(Product product){
        products.put(product.getProductID(),product);
    }
}
