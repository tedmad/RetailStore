package com.example.restservice;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class calculates the total of all the possible discounts
 * a user can have on a given bill.
 */
@Service
@RequestMapping("/api")
public class DiscountService {

    //A variable to hold the total discount
    private double totalDiscount;

    /**
     * This a discount service method that calculates all the possible discounts and returns the total.
     * @param bill The total amount of goods to be purchased.
     * @param billType  The type of goods to be purchased. Value 0 indicates non-grocery.
     * @param user  The type of user. Value 1 = Employee, 2 = Affiliate and 3 = Long Time Customer.
     * @return double This returns the total discount.
     */
    public double getTotalDiscount(double bill, int billType, int user){

        totalDiscount = 0.0;

        //A condition to check if the bill is is a non grocery
        if(billType == 0){

            //A condition to check the type of user
            switch (user){
                case 1:
                    Employee employee = new Employee();
                    totalDiscount = employee.getDiscount(bill);
                    break;
                case 2:
                    Affiliate affiliate = new Affiliate();
                    totalDiscount = affiliate.getDiscount(bill);
                    break;
                case 3:
                    LongTimeCustomer longTimeCustomer = new LongTimeCustomer();
                    totalDiscount = longTimeCustomer.getDiscount(bill);
                    break;
            }

        }

        User noteBill = new User();

        //Calculates the $5 discount on every $100 note
        totalDiscount += noteBill.getDiscount(bill);

        return totalDiscount;
    }

    /*variable discount
    private double discount;


    public double getDiscountService(double bill, int billType, int user){

        //The billType value 0 indicate that bill is NOT grocery
        if(billType == 0){

            switch (user){
                case 1:
                    getEmployeeDiscount(bill);
                    break;
                case 2:
                    getAffiliateDiscount(bill);
                    break;
                case 3:
                    getLongTimeCustomerDiscount(bill);
                    break;
            }
            getBillDiscount(bill);
        }

        return discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getEmployeeDiscount(double bill){
        discount = bill * 0.3;
        return discount;
    }
    public double getAffiliateDiscount(double bill){
        discount = bill * 0.1;
        return discount;
    }
    public double getLongTimeCustomerDiscount(double bill){
        discount = bill * 0.05;
        return  discount;
    }


    public double getBillDiscount(double bill){

        discount +=  (int)bill/100 * 5;
        return  discount;
    }

     */
}
