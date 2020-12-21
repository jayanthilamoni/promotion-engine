package com.assignment.service;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.strategies.PromotionStrategy;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private final Cart cart;
    private final PromotionStrategy promotionStrategy;

    public CartServiceImpl(Cart cart,PromotionStrategy promotionStrategy) {
        this.cart = cart;
        this.promotionStrategy = promotionStrategy;
    }

    @Override
    public void addProductToCart(CartEntry cartEntry) {
        cart.getCartEntries().add(cartEntry);
    }

    @Override
    public Cart getCart() {
        promotionStrategy.applyPromotions(cart);
        return cart;
    }
}
