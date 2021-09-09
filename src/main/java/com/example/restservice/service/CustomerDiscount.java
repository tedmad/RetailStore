package com.example.restservice.service;

import com.example.restservice.utility.Rates;
import org.springframework.stereotype.Service;

/**
 * This class calculates the customer discount of $5 on every $100 bill
 */
@Service
public class CustomerDiscount {
    protected double discount;
    protected Rates discountRates = new Rates();
    /**
     * This method calculates the $5 discount of every $100 bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    public double getDiscount(double bill){
        discount =  (int)bill/100 * discountRates.getBillDiscount();
        return discount;
    }
}
