package com.assignment.controllers;

import com.assignment.models.promotion.PromotionEntryForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionsController {

    @PutMapping("/promotion/add")
    public String addPromotion(@RequestBody PromotionEntryForm promotionEntryForm){
        return "";
    }
}
