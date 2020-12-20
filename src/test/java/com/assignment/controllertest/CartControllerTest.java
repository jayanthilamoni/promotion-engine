package com.assignment.controllertest;

import com.assignment.controllers.CartController;
import com.assignment.dba.ProductDB;
import com.assignment.models.Product;
import com.assignment.service.CartService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartControllerTest {

    @Mock
    private final CartController controller;

    static ProductDB db;
    @BeforeAll
    static void setup(){
        db = ProductDB.getInstance();
        Product productA = new Product("A",20);
        Product productB = new Product("B",75);
        db.addProduct(productA);
        db.addProduct(productB);
    }

    @Mock
    private CartService cartService;
    public CartControllerTest() {
        controller = new CartController(cartService,db);
    }

    @Test
    public void whenProductDoesNotExist_returnErrorMessage(){
        String message = controller.addCartEntry("C");
        assertTrue(message.contains("No Product"));
    }
}
