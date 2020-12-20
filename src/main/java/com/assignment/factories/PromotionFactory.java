package com.assignment.factories;

import com.assignment.enums.PromotionType;
import com.assignment.models.promotion.ComboOfTwoProductsPromotion;
import com.assignment.models.promotion.NItemsOfSingleProductPromotion;
import com.assignment.models.promotion.Promotion;

public class PromotionFactory {
    public static Promotion getPromotion(int promotionType){
        if(promotionType==1){
            return new NItemsOfSingleProductPromotion();
        }else if(promotionType==2){
            return new ComboOfTwoProductsPromotion();
        }else{
            return null;
        }
    }
}
