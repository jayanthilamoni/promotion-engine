package com.assignment.models.cart;

import com.assignment.models.product.Product;
import org.springframework.lang.Nullable;

public class CartEntryForm {
    private String productId;
    private int quantity;

    public CartEntryForm(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
