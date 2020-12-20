package com.assignment.service;

import com.assignment.models.promotion.Promotion;

public interface PromotionService {
    void addPromotion(Promotion promotion);
    Promotion getPromotionByType(int promotionType);
}
