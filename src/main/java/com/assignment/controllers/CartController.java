package com.assignment.controllers;

import com.assignment.dba.ProductDB;
import com.assignment.exceptions.NoProductWithIDException;
import com.assignment.models.CartEntry;
import com.assignment.models.Product;
import com.assignment.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;
    private final ProductDB productDB;

    public CartController(CartService cartService,ProductDB productDB) {
        this.cartService = cartService;
        this.productDB = productDB;
    }

    @GetMapping("/cart")
    public List<CartEntry> getCart(){
        return cartService.getCart();
    }

    @PutMapping("/cart/add/{productId}")
    public String addCartEntry(@PathVariable String productId){
        Product product = null;
        try{
            product = productDB.getProductById(productId);
        }catch (NoProductWithIDException exception){
            return "No Product found with ID : "+productId;
        }
        cartService.addProductToCart(product);
        return "Product : "+productId+" added to cart";
    }
}
