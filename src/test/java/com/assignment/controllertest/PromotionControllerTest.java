package com.assignment.controllertest;

import com.assignment.controllers.PromotionsController;
import com.assignment.dba.PromotionDB;
import com.assignment.models.promotion.PromotionEntryForm;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class PromotionControllerTest {
    private final PromotionsController promotionsController;
    PromotionControllerTest(){
        PromotionDB promotionDB = PromotionDB.getInstance();
        promotionsController = new PromotionsController(promotionDB);
    }
    @Test
    public void whenCorrectTypeOnePromo_addPromotion(){
        PromotionEntryForm promotionEntryForm = new PromotionEntryForm();
        promotionEntryForm.setPromotionType(1);
        promotionEntryForm.setMultiple(4);
        promotionEntryForm.setOfferPrice(120);
        promotionEntryForm.setProductA("A");
        String response = promotionsController.addPromotion(promotionEntryForm);
        assertTrue(response.contains("Promotion with ID "));
    }
}
