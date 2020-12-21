package com.assignment.service;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.models.product.Product;

import java.util.List;

public interface CartService {
    void addProductToCart(CartEntry cartEntry);
    Cart getCart();
}
