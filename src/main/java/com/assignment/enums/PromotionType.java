package com.assignment.enums;

public enum PromotionType {
    N_ITEMS_OF_SINGLE_PRODUCT(1),COMBO_OF_TWO_PRODUCTS(2);

    private int typeCode;

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    private PromotionType(int typeCode){
        this.typeCode = typeCode;
    }
}
