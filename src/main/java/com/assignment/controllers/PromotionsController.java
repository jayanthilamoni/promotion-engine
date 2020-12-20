package com.assignment.controllers;

import com.assignment.dba.PromotionDB;
import com.assignment.factories.PromotionFactory;
import com.assignment.models.promotion.ComboOfTwoProductsPromotion;
import com.assignment.models.promotion.NItemsOfSingleProductPromotion;
import com.assignment.models.promotion.Promotion;
import com.assignment.models.promotion.PromotionEntryForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class PromotionsController {

    private PromotionDB promotionDB;

    public PromotionsController(PromotionDB promotionDB) {
        this.promotionDB = promotionDB;
    }

    @PutMapping("/promotion/add")
    public String addPromotion(@RequestBody PromotionEntryForm promotionEntryForm){
        Promotion promotion = PromotionFactory.getPromotion(promotionEntryForm.getPromotionType());
        if(Objects.isNull(promotion)){
            return "No Promotion Found with the Provided ID";
        }
        if(promotion instanceof NItemsOfSingleProductPromotion){
            NItemsOfSingleProductPromotion nItemsOfSingleProductPromotion = (NItemsOfSingleProductPromotion) promotion;
            nItemsOfSingleProductPromotion.setBuyPrice(promotionEntryForm.getOfferPrice());
            nItemsOfSingleProductPromotion.setMultiple(promotionEntryForm.getMultiple());
            nItemsOfSingleProductPromotion.setProductId(promotionEntryForm.getProductA());
            getPromotionDB().addPromotion(nItemsOfSingleProductPromotion);
        }else if(promotion instanceof ComboOfTwoProductsPromotion){
            ComboOfTwoProductsPromotion comboOfTwoProductsPromotion = (ComboOfTwoProductsPromotion) promotion;
            getPromotionDB().addPromotion(comboOfTwoProductsPromotion);
        }
        return "Promotion with ID : "+promotion.getPromoId()+" added";
    }

    public PromotionDB getPromotionDB() {
        return promotionDB;
    }

    public void setPromotionDB(PromotionDB promotionDB) {
        this.promotionDB = promotionDB;
    }
}
