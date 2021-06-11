package com.example.restservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Test the 30% discount of the employee")
    void employeeDiscountTest() {
        User employee = new Employee();
        double response = employee.getDiscount(100.0);
        assertEquals(30.0, response);
    }

    @Test
    @DisplayName("Test the 10% discount of an affiliate user")
    void affiliateDiscountTest() {
        User affiliate = new Affiliate();
        double response = affiliate.getDiscount(100.0);
        assertEquals(10.0, response);
    }

    @Test
    @DisplayName("Test the 5% discount for the user who has been a customer for over 2 years")
    void longTimeCustomerDiscountTest() {
        User longTimeCustomer = new LongTimeCustomer();
        double response = longTimeCustomer.getDiscount(100.0);
        assertEquals(5.0, response);
    }

    @Test
    @DisplayName("Test the $5 discount for the user for every $100 note bill")
    void billDiscountTest() {
        User noteBill = new User();
        double response = noteBill.getDiscount(990.0);
        assertEquals(45.0, response);
    }

    @Test
    @DisplayName("Test the total discount for the employee user")
    void getTotalDiscountTest() {
        DiscountService discountService = new DiscountService();

        double testCaseEmployee = discountService.getTotalDiscount(100.0, 0, 1);
        assertEquals(35.0, testCaseEmployee);

    }
}