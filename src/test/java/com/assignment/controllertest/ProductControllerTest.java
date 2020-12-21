package com.assignment.controllertest;

import com.assignment.controllers.ProductController;
import com.assignment.dba.ProductDB;
import com.assignment.models.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductControllerTest {
    ProductDB db;
    ProductController productController;

    ProductControllerTest(){
        db = ProductDB.getInstance();
        productController = new ProductController(db);
    }

    @Test
    public void whenPriceIsNumber_createsProductWithID(){
        String productId = "A";
        Product product = new Product(productId,24);
        String message = productController.addProduct(product);
        assertTrue(message.contains(productId));
    }
}
