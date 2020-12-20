package com.assignment.service;

import com.assignment.dba.PromotionDB;
import com.assignment.factories.PromotionFactory;
import com.assignment.models.promotion.Promotion;

public class PromotionServiceImpl implements PromotionService{
    private PromotionDB promotionDB;

    public PromotionServiceImpl(PromotionDB promotionDB) {
        this.promotionDB = promotionDB;
    }

    @Override
    public void addPromotion(Promotion promotion) {

    }

    @Override
    public Promotion getPromotionByType(int promotionType) {
        return PromotionFactory.getPromotion(promotionType);
    }

    public PromotionDB getPromotionDB() {
        return promotionDB;
    }

    public void setPromotionDB(PromotionDB promotionDB) {
        this.promotionDB = promotionDB;
    }
}
