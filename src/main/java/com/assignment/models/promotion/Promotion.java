package com.assignment.models.promotion;

import com.assignment.models.cart.CartEntry;

import java.util.Map;

public abstract class Promotion {
    private String promoId;

    public abstract void apply();

    public abstract double getDiscount(Map<String, CartEntry> cartEntryMap);
    public String getPromoId() {
        return promoId;
    }

    public void setPromoId(String promoId) {
        this.promoId = promoId;
    }
}
