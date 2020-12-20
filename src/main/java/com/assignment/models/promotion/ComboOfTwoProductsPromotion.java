package com.assignment.models.promotion;

import com.assignment.models.cart.CartEntry;

import java.util.Map;

public class ComboOfTwoProductsPromotion extends Promotion {

    private String productIdA;
    private String productIdB;
    private double buyPrice;

    public String getProductIdA() {
        return productIdA;
    }

    public void setProductIdA(String productIdA) {
        this.productIdA = productIdA;
    }

    public String getProductIdB() {
        return productIdB;
    }

    public void setProductIdB(String productIdB) {
        this.productIdB = productIdB;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public double getDiscount(Map<String, CartEntry> cartEntryMap) {
        return 0;
    }
}
