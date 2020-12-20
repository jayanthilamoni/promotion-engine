package com.assignment.factories;

import com.assignment.models.promotion.ComboOfTwoProductsPromotion;
import com.assignment.models.promotion.NItemsOfSingleProductPromotion;
import com.assignment.models.promotion.Promotion;
import org.springframework.stereotype.Component;

@Component
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
