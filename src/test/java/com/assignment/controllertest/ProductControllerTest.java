package com.assignment.controllertest;

import com.assignment.controllers.ProductController;
import com.assignment.dba.ProductDB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductControllerTest {
    ProductDB db;
    ProductController productController;

    ProductControllerTest(){
        db = ProductDB.getInstance();
        productController = new ProductController(db);
    }

    @Test
    public void whenPriceNotNumber_throwsNumberFormatException(){
        Exception exception = assertThrows(NumberFormatException.class,
                ()-> productController.addProduct("A","W"));
        assertNotNull(exception);
    }

    @Test
    public void whenPriceIsNumber_createsProductWithID(){
        String productId = "A";
        String message = productController.addProduct(productId,"24");
        assertTrue(message.contains(productId));
    }
}
