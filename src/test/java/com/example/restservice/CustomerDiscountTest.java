package com.example.restservice;

import com.example.restservice.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDiscountTest {

    @Test
    @DisplayName("Test the 30% discount of the employee")
    void employeeDiscountTest() {
        CustomerDiscount employee = new EmployeeDiscount();
        double response = employee.getDiscount(100.0);
        assertEquals(30.0, response);
    }

    @Test
    @DisplayName("Test the 10% discount of an affiliate user")
    void affiliateDiscountTest() {
        CustomerDiscount affiliate = new AffiliateDiscount();
        double response = affiliate.getDiscount(100.0);
        assertEquals(10.0, response);
    }

    @Test
    @DisplayName("Test the 5% discount for the user who has been a customer for over 2 years")
    void longTimeCustomerDiscountTest() {
        CustomerDiscount longTimeCustomer = new LongTimeCustomerDiscount();
        double response = longTimeCustomer.getDiscount(100.0);
        assertEquals(5.0, response);
    }

    @Test
    @DisplayName("Test the $5 discount for the user for every $100 note bill")
    void billDiscountTest() {
        CustomerDiscount noteBill = new CustomerDiscount();
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