package com.example.restservice.service;

import org.springframework.stereotype.Service;

/**
 * This class calculates the 10% discount of user who is an
 * affiliate to the store.
 */
@Service
public class AffiliateDiscount extends CustomerDiscount {

    /**
     * This method calculates the 10% discount on a given bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    @Override
    public double getDiscount(double bill){
        discount = bill * (discountRates.getAffiliateDiscount()/100);
        return discount;
    }
}
