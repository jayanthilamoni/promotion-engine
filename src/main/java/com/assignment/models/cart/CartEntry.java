package com.assignment.models.cart;

import com.assignment.models.product.Product;

public class CartEntry {
    private Product product;

    public CartEntry() {
    }

    public CartEntry(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    private double discount;
}
