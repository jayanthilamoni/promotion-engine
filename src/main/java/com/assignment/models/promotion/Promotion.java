package com.assignment.models.promotion;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;

import java.util.Map;

public abstract class Promotion {
    private String promoId;

    public void apply(Map<String, CartEntry> cartEntryMap, Cart cart){
        double discount = getDiscount(cartEntryMap);
        cart.setDiscount(discount);
        cart.setPromotionalMessage("Promotion with ID : "+getPromoId()+" applied, received a discount of - "+discount);
    };

    public abstract double getDiscount(Map<String, CartEntry> cartEntryMap);
    public String getPromoId() {
        return promoId;
    }

    public void setPromoId(String promoId) {
        this.promoId = promoId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Promotion){
            return this.getPromoId().equals(((Promotion) obj).getPromoId());
        }
        return false;
    }
}
