package com.assignment.strategies;

import com.assignment.models.cart.Cart;

public interface PromotionStrategy {
    void applyPromotions(Cart cart);
}
