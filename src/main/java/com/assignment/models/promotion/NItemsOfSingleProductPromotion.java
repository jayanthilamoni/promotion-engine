package com.assignment.models.promotion;

import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;

import java.util.Map;

public class NItemsOfSingleProductPromotion extends Promotion{
    private String productId;
    private int multiple;
    private double buyPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public double getDiscount(Map<String, CartEntry> cartEntryMap) {
        CartEntry cartEntry = cartEntryMap.get(getProductId());
        double eachPrice = cartEntry.getProduct().getPrice();
        double currentTotal = (double) cartEntry.getQuantity()*eachPrice;
        double discountPrice = ((int)(cartEntry.getQuantity()/getMultiple()) *getBuyPrice())+((cartEntry.getQuantity()%getMultiple())*eachPrice);
        return currentTotal-discountPrice;
    }
}
