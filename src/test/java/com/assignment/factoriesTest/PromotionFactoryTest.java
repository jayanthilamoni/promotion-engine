package com.assignment.factoriesTest;

import static org.junit.jupiter.api.Assertions.*;

import com.assignment.factories.PromotionFactory;
import com.assignment.models.promotion.ComboOfTwoProductsPromotion;
import com.assignment.models.promotion.NItemsOfSingleProductPromotion;
import com.assignment.models.promotion.Promotion;
import org.junit.jupiter.api.Test;

public class PromotionFactoryTest {
    @Test
    public void whenTypeOne_returnNItemOfSingleProductPromotion(){
        Promotion promotion = PromotionFactory.getPromotion(1);
        assertTrue(promotion instanceof NItemsOfSingleProductPromotion);
    }

    @Test
    public void whenTypeTwo_returnComboOfTwoProductsPromotion(){
        Promotion promotion = PromotionFactory.getPromotion(2);
        assertTrue(promotion instanceof ComboOfTwoProductsPromotion);
    }

    @Test
    public void whenTypeNotPresent_returnNull(){
        Promotion promotion = PromotionFactory.getPromotion(5);
        assertNull(promotion);
    }
}
