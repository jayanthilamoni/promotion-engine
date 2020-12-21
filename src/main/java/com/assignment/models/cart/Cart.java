package com.assignment.models.cart;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Cart {
    private UUID cartId;
    private List<CartEntry> cartEntries;
    private static Cart cart;
    private double discount;
    private String promotionalMessage;

    public Cart() {
        cartEntries = new ArrayList<>();
    }

    public static Cart getInstance(){
        if(cart==null){
            cart = new Cart();
        }
        return cart;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }

    public void setCartEntries(List<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPromotionalMessage() {
        return promotionalMessage;
    }

    public void setPromotionalMessage(String promotionalMessage) {
        this.promotionalMessage = promotionalMessage;
    }
}
