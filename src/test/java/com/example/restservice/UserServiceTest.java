package com.example.restservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getTotalDiscount() {
        DiscountService discountService = new DiscountService();

        double employee = discountService.getTotalDiscount(100.0, 0, 1);
        assertEquals(35.0, employee);

        double affiliate = discountService.getTotalDiscount(100.0, 0, 2);
        assertEquals(15.0, affiliate);

        double lonTimeCustomer = discountService.getTotalDiscount(100.0, 0, 3);
        assertEquals(15.0, affiliate);

        double normalUser = discountService.getTotalDiscount(990.0, 1, 4);
        assertEquals(45.0, normalUser);
    }

}