package com.assignment.dba;

import com.assignment.models.promotion.Promotion;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PromotionDB {
    private static PromotionDB promotionDB;
    private final Map<String, Promotion> promotions;
    private PromotionDB(){
        promotions = new HashMap<>();
    }
    public static PromotionDB getInstance(){
        if(promotionDB==null){
            promotionDB = new PromotionDB();
        }
        return promotionDB;
    }
    public void addPromotion(Promotion promotion){
        promotions.put(promotion.getPromoId(),promotion);
    }

    public Map<String, Promotion> getAllPromotions(){
        return promotions;
    }
}
