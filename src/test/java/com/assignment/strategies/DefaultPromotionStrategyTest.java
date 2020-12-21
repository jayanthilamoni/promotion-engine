package com.assignment.strategies;

import com.assignment.controllers.CartController;
import com.assignment.controllers.PromotionsController;
import com.assignment.dba.ProductDB;
import com.assignment.dba.PromotionDB;
import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.models.cart.CartEntryForm;
import com.assignment.models.product.Product;
import com.assignment.models.promotion.NItemsOfSingleProductPromotion;
import com.assignment.models.promotion.Promotion;
import com.assignment.models.promotion.PromotionEntryForm;
import com.assignment.service.CartService;
import com.assignment.service.CartServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultPromotionStrategyTest {

    PromotionStrategy strategy;
    PromotionDB db;
    Cart cart;
    ProductDB productDB;
    PromotionsController promotionsController;
    CartController controller;
    CartService cartService;

    DefaultPromotionStrategyTest(){
        db = PromotionDB.getInstance();
        strategy = new DefaultPromotionStrategy(db);
        cart = Cart.getInstance();
        promotionsController = new PromotionsController(db);
        productDB = ProductDB.getInstance();
        cartService = new CartServiceImpl(cart);
        controller = new CartController(cartService,productDB);
    }
    @Test
    public void whenCartIsProvided_returnEligiblePromotions(){
        addPromotionA();
        addPromotionB();
        setupProducts();
        setupCart();
        List<Promotion> potentialPromotions = strategy.getPotentialPromotions(getCartEntryMap(cart));
        List<Promotion> result = new ArrayList<>();
        Promotion promotionA = new NItemsOfSingleProductPromotion();
        promotionA.setPromoId("APromo");
        Promotion promotionB = new NItemsOfSingleProductPromotion();
        promotionB.setPromoId("ComboPromo");
        result.add(promotionA);
        result.add(promotionB);
        System.out.println(potentialPromotions.toString());
        assertTrue(potentialPromotions.containsAll(result));
    }

    Map<String, CartEntry> getCartEntryMap(Cart cart){
        return cart.getCartEntries().stream()
                .collect(Collectors.toMap((entry)-> entry.getProduct().getProductID(),(entry)-> entry));
    }

    public void addPromotionA(){
        PromotionEntryForm promotionEntryForm = new PromotionEntryForm();
        promotionEntryForm.setPromotionType(1);
        promotionEntryForm.setMultiple(4);
        promotionEntryForm.setOfferPrice(120);
        promotionEntryForm.setProductA("A");
        promotionEntryForm.setPromotionId("APromo");
        promotionsController.addPromotion(promotionEntryForm);
    }
    public void addPromotionB(){
        PromotionEntryForm promotionEntryForm = new PromotionEntryForm();
        promotionEntryForm.setPromotionType(2);
        promotionEntryForm.setOfferPrice(120);
        promotionEntryForm.setProductA("A");
        promotionEntryForm.setProductB("B");
        promotionEntryForm.setPromotionId("ComboPromo");
        promotionsController.addPromotion(promotionEntryForm);
    }

    public void setupProducts(){
        Product productA = new Product("A",60);
        Product productB = new Product("B",75);
        productDB.addProduct(productA);
        productDB.addProduct(productB);
    }

    public void setupCart(){
        CartEntryForm cartEntryFormA = new CartEntryForm("A",5);
        CartEntryForm cartEntryFormB = new CartEntryForm("B",4);
        controller.addCartEntry(cartEntryFormA);
        controller.addCartEntry(cartEntryFormB);
    }
}
