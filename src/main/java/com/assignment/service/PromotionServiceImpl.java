package com.assignment.service;

import com.assignment.dba.PromotionDB;
import com.assignment.factories.PromotionFactory;
import com.assignment.models.promotion.Promotion;
import com.assignment.strategies.PromotionStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService{
    private PromotionDB promotionDB;
    private PromotionStrategy promotionStrategy;

    public PromotionServiceImpl(PromotionDB promotionDB,@Qualifier("defaultPromotionStrategy") PromotionStrategy promotionStrategy) {
        this.promotionDB = promotionDB;
        this.promotionStrategy = promotionStrategy;
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

    public PromotionStrategy getPromotionStrategy() {
        return promotionStrategy;
    }

    public void setPromotionStrategy(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }
}
