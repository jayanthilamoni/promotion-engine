package com.assignment.models.promotion;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;

import java.util.Map;

public class ComboOfTwoProductsPromotion extends Promotion {
    @Override
    public void apply(Map<String, CartEntry> cartEntryMap, Cart cart) {

    }

    @Override
    public double getDiscount(Map<String, CartEntry> cartEntryMap) {
        return 0;
    }
}
