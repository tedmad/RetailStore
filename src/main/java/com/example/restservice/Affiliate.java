package com.example.restservice;

/**
 * This class calculates the 10% discount of user who is an
 * affiliate to the store.
 */
public class Affiliate extends User {

    /**
     * This method calculates the 10% discount on a given bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    @Override
    public double getDiscount(double bill){
        discount = bill * 0.1;
        return discount;
    }
}
