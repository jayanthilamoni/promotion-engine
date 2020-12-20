package com.assignment.models.promotion;

public class PromotionEntryForm {
    private String promotionId;
    private int promotionType;
    private String productA;
    private String productB;
    private double offerPrice;
    private int multiple;

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public int getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(int promotionType) {
        this.promotionType = promotionType;
    }

    public String getProductA() {
        return productA;
    }

    public void setProductA(String productA) {
        this.productA = productA;
    }

    public String getProductB() {
        return productB;
    }

    public void setProductB(String productB) {
        this.productB = productB;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }
}
