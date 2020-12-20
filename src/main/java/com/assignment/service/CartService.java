package com.assignment.service;

import com.assignment.models.CartEntry;
import com.assignment.models.Product;

import java.util.List;

public interface CartService {
    void addProductToCart(Product product);
    List<CartEntry> getCart();
}
