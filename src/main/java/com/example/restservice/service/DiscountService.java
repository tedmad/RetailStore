package com.example.restservice.service;

import org.springframework.stereotype.Service;

/**
 * This class calculates the total of all the possible discounts
 * a user can have on a given bill.
 */
@Service
public class DiscountService {

    //A variable to hold the total discount
    private double totalDiscount;
    private CustomerDiscount customerDiscount;
    /**
     * This a discount service method that calculates all the possible discounts and returns the total.
     * @param bill The total amount of goods to be purchased.
     * @param billType  The type of goods to be purchased. Value 0 indicates non-grocery.
     * @param userType  The type of user. Value 1 = Employee, 2 = Affiliate and 3 = Long Time Customer.
     * @return double This returns the total discount.
     */
    public double getTotalDiscount(double bill, int billType, int userType){

        totalDiscount = 0.0;

        //A condition to check if the bill is is a non grocery
        if(billType == 0){

            //A condition to check the type of user
            switch (userType){
                case 1:
                    customerDiscount = new EmployeeDiscount();
                    totalDiscount = customerDiscount.getDiscount(bill);
                    break;
                case 2:
                    customerDiscount = new AffiliateDiscount();
                    totalDiscount = customerDiscount.getDiscount(bill);
                    break;
                case 3:
                    customerDiscount = new LongTimeCustomerDiscount();
                    totalDiscount = customerDiscount.getDiscount(bill);
                    break;
            }

        }

        customerDiscount = new CustomerDiscount();

        //Calculates the $5 discount on every $100 note
        totalDiscount += customerDiscount.getDiscount(bill);

        return totalDiscount;
    }
}
