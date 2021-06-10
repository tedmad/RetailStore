package com.example.restservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    @Test
    void getDiscountService() {
        DiscountService discountService = new DiscountService();

        double testCaseEmployee = discountService.getDiscountService(100.0, 0, 1);
        assertEquals(35.0, testCaseEmployee);

    }

    @Test
    void getEmployeeDiscount() {
        DiscountService discountService = new DiscountService();
        double response = discountService.getEmployeeDiscount(100.0);
        assertEquals(30.0, response);
    }

    @Test
    void getAffiliateDiscount() {
        DiscountService discountService = new DiscountService();
        double response = discountService.getAffiliateDiscount(100.0);
        assertEquals(10.0, response);
    }

    @Test
    void getLongTimeCustomerDiscount() {
        DiscountService discountService = new DiscountService();
        double response = discountService.getLongTimeCustomerDiscount(100.0);
        assertEquals(5.0, response);
    }

    @Test
    void getBillDiscount() {
        DiscountService discountService = new DiscountService();
        double response = discountService.getBillDiscount(990.0);
        assertEquals(45.0, response);
    }
}