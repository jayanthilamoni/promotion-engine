package com.assignment.models.promotion;

public class PromotionEntryForm {
    private String promotionId;
    private int promotionType;
    private String ProductA;
    private String ProductB;
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
        return ProductA;
    }

    public void setProductA(String productA) {
        ProductA = productA;
    }

    public String getProductB() {
        return ProductB;
    }

    public void setProductB(String productB) {
        ProductB = productB;
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
