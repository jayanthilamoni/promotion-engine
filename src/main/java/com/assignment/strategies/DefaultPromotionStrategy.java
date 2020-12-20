package com.assignment.strategies;

import com.assignment.dba.PromotionDB;
import com.assignment.models.cart.Cart;
import com.assignment.models.cart.CartEntry;
import com.assignment.models.promotion.ComboOfTwoProductsPromotion;
import com.assignment.models.promotion.NItemsOfSingleProductPromotion;
import com.assignment.models.promotion.Promotion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("defaultPromotionStrategy")
public class DefaultPromotionStrategy implements PromotionStrategy{
    private PromotionDB promotionDB;

    public DefaultPromotionStrategy(PromotionDB promotionDB) {
        this.promotionDB = promotionDB;
    }

    private List<Promotion> getPotentialPromotions(Map<String, CartEntry> cartEntryMap){
        Map<String, Promotion> promotionMap = getPromotionDB().getAllPromotions();
        List<Promotion> potentialPromotions = new ArrayList<>();
        promotionMap.forEach((key,value)->{
            if(value instanceof NItemsOfSingleProductPromotion){
                String productId = ((NItemsOfSingleProductPromotion) value).getProductId();
                if(cartEntryMap.containsKey(productId)){
                    potentialPromotions.add(value);
                }
            }else if(value instanceof ComboOfTwoProductsPromotion){
                value.getPromoId();
            }
        });
        return potentialPromotions;
    }

    private Map<String, CartEntry> getCartEntryMap(Cart cart){
        return cart.getCartEntries().stream().collect(Collectors.toMap((entry)->{
            return entry.getProduct().getProductID();
        },(entry)->{return entry;}));
    }

    public PromotionDB getPromotionDB() {
        return promotionDB;
    }

    public void setPromotionDB(PromotionDB promotionDB) {
        this.promotionDB = promotionDB;
    }

    @Override
    public void applyPromotions(Cart cart) {
        Map<String,CartEntry> cartEntryMap = getCartEntryMap(cart);
        List<Promotion> potentialPromotion = getPotentialPromotions(cartEntryMap);

    }
}
