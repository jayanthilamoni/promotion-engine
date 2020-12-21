package com.assignment.strategies;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.models.promotion.Promotion;

import java.util.List;
import java.util.Map;

public interface PromotionStrategy {
    void applyPromotions(Cart cart);
    List<Promotion> getPotentialPromotions(Map<String, CartEntry> cartEntryMap);
}
