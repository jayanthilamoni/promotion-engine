package com.assignment.models.cart;

import com.assignment.models.product.Product;

public class CartEntry {
    private Product product;
    private int quantity;
    private double discount;

    public CartEntry() {
    }

    public CartEntry(Product product,int quantity) {
        this.product = product;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
