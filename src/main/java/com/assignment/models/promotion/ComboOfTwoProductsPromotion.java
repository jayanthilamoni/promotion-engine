package com.assignment.models.promotion;

import com.assignment.models.cart.CartEntry;

import java.util.Map;

public class ComboOfTwoProductsPromotion extends Promotion {
    @Override
    public void apply() {

    }

    @Override
    public double getDiscount(Map<String, CartEntry> cartEntryMap) {
        return 0;
    }
}
