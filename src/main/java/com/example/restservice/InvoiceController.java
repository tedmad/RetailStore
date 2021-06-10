package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/")
public class InvoiceController {

    private final AtomicLong id_counter = new AtomicLong();
    @Autowired
    private DiscountService discountService;

    @GetMapping("/invoice")
    public Invoice invoice(@PathParam("bill") double bill, @PathParam("billType") int billType, @PathParam("user") int user){
        double discount = discountService.getDiscountService(bill, billType, user);
        return new Invoice(id_counter.incrementAndGet(), bill, discount, bill - discount);
    }

}
