package com.example.restservice;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {

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
}
