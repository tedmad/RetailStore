package com.example.restservice;

/**
 * This class calculates the 30% discount on a given bill of a user who is an
 * employee to the store.
 */
public class Employee extends User {

    /**
     * This method calculates the 30% discount on a given bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    @Override
    public double getDiscount(double bill){
        discount = bill * 0.3;
        return discount;
    }
}
