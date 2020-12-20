package com.assignment.service;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.models.promotion.Promotion;

import java.util.Map;

public interface PromotionService {
    Promotion getPromotionByType(int promotionType);
    void applyPromotions(Cart cart);
}
