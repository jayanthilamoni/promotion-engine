package com.assignment.service;

import com.assignment.models.cart.Cart;
import com.assignment.models.promotion.Promotion;

public interface PromotionService {
    Promotion getPromotionByType(int promotionType);
}
