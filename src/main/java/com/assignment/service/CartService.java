package com.assignment.service;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;

public interface CartService {
    void addProductToCart(CartEntry cartEntry);
    Cart getCart();
}
