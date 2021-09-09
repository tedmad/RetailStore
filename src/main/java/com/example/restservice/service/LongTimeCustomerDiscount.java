package com.example.restservice.service;

import org.springframework.stereotype.Service;

/**
 * This class calculates the 5% discount of user who has
 *  been a customer for over two (2) years
 */
@Service
public class LongTimeCustomerDiscount extends CustomerDiscount {
    /**
     * This method calculates the 5% discount on a given bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    @Override
    public double getDiscount(double bill){
        discount = bill * (discountRates.getLongCustomerDiscount()/100.0);
        return discount;
    }
}
