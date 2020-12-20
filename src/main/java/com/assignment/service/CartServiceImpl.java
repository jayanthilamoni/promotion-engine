package com.assignment.service;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.models.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    private final Cart cart;

    public CartServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addProductToCart(Product product) {
        CartEntry cartEntry = new CartEntry(product);
        cart.getCartEntries().add(cartEntry);
    }

    @Override
    public List<CartEntry> getCart() {
        return cart.getCartEntries();
    }
}
