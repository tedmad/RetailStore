package com.example.restservice;

/**
 * This class calculates the the discount of $5 on every $100 bill
 */
public class User {
    protected double discount;

    /**
     * This method calculates the $5 discount of every $100 bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    protected double getDiscount(double bill){
        discount =  (int)bill/100 * 5;
        return discount;
    }
}
