package com.example.restservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * This class calculates the 30% discount on a given bill of a user who is an
 * employee to the store.
 */
@Service
public class EmployeeDiscount extends CustomerDiscount {
    /**
     * This method calculates the 30% discount on a given bill
     * and returns the discount.
     * @param bill The total amount of goods to be purchased.
     * @return discount
     */
    @Override
    public double getDiscount(double bill){
        discount = bill * (discountRates.getEmployeeDiscount()/100);
        return discount;
    }
}
