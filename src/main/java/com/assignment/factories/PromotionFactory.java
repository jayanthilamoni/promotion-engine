package com.assignment.factories;

import com.assignment.enums.PromotionType;
import com.assignment.models.promotion.ComboOfTwoProductsPromotion;
import com.assignment.models.promotion.NItemsOfSingleProductPromotion;
import com.assignment.models.promotion.Promotion;
import org.springframework.stereotype.Component;

@Component
public class PromotionFactory {
    public static Promotion getPromotion(int promotionType){
        if(promotionType == PromotionType.N_ITEMS_OF_SINGLE_PRODUCT.getTypeCode()){
            return new NItemsOfSingleProductPromotion();
        }else if(promotionType==PromotionType.COMBO_OF_TWO_PRODUCTS.getTypeCode()){
            return new ComboOfTwoProductsPromotion();
        }else{
            return null;
        }
    }
}
