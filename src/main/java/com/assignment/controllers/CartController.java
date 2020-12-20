package com.assignment.controllers;

import com.assignment.dba.ProductDB;
import com.assignment.exceptions.NoProductWithIDException;
import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.models.cart.CartEntryForm;
import com.assignment.models.product.Product;
import com.assignment.service.CartService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/cart/add")
    public String addCartEntry(@RequestBody CartEntryForm cartEntryForm){
        Product product = null;
        try{
            product = productDB.getProductById(cartEntryForm.getProductId());
        }catch (NoProductWithIDException exception){
            return "No Product found with ID : "+cartEntryForm.getProductId();
        }
        CartEntry cartEntry = new CartEntry(product,cartEntryForm.getQuantity());
        cartService.addProductToCart(cartEntry);
        return "Product : "+cartEntryForm.getProductId()+" added to cart";
    }
}
