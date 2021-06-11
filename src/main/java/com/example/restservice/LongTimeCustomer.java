package com.example.restservice;

/**
 * This class calculates the 5% discount of user who has
 *  been a customer for over two (2) years
 */
public class LongTimeCustomer extends User {
    /**
     * This method calculates the 5% discount on a given bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    @Override
    public double getDiscount(double bill){
        discount = bill * 0.05;
        return discount;
    }
}
