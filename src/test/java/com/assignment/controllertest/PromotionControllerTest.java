package com.assignment.controllertest;

import com.assignment.controllers.PromotionsController;
import com.assignment.dba.PromotionDB;
import com.assignment.models.promotion.PromotionEntryForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        promotionEntryForm.setPromotionId("APromo");
        String response = promotionsController.addPromotion(promotionEntryForm);
        assertTrue(response.contains("Promotion with ID "));
    }
    @Test
    public void whenCorrectTypeTwoPromo_addPromotion(){
        PromotionEntryForm promotionEntryForm = new PromotionEntryForm();
        promotionEntryForm.setPromotionType(2);
        promotionEntryForm.setOfferPrice(120);
        promotionEntryForm.setProductA("A");
        promotionEntryForm.setProductA("B");
        promotionEntryForm.setPromotionId("ComboPromo");
        String response = promotionsController.addPromotion(promotionEntryForm);
        assertTrue(response.contains("Promotion with ID "));
    }
    @Test
    public void whenPromoIdNotFound_returnErrorMessage(){
        PromotionEntryForm promotionEntryForm = new PromotionEntryForm();
        promotionEntryForm.setPromotionType(8);
        promotionEntryForm.setOfferPrice(120);
        promotionEntryForm.setProductA("A");
        promotionEntryForm.setProductA("B");
        promotionEntryForm.setPromotionId("ComboPromo");
        String response = promotionsController.addPromotion(promotionEntryForm);
        assertTrue(response.contains("No Promotion Found with the Provided ID"));
    }
}
