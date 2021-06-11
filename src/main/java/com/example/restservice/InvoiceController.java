package com.example.restservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This is a controller class that exposes our API to the endpoint
 */
@RestController
@RequestMapping("/api")
public class InvoiceController {

    //An ID counter variable
    private final AtomicLong id_counter = new AtomicLong();
    @Autowired
    private DiscountService discountService;



    /**
     * Get invoice based on bill, billType and user.
     * @param bill The total amount of goods to be purchased.
     * @param billType  The type of goods to be purchased. Value 0 indicates non-grocery.
     * @param user  The type of user. Value 1 = Employee, 2 = Affiliate and 3 = Long Time Customer.
     * @return Invoice This returns Invoice object with invoice ID, bill and net payable amount.
     */
    @Operation(summary = "Get invoice based on bill, billType and user", description = "returns Invoice object with invoice ID, bill and net payable amount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful GET request",
                    content = @Content(schema = @Schema(implementation = Invoice.class))),
            @ApiResponse(responseCode = "404", description = "Invoice not found"),
            @ApiResponse(responseCode = "404", description = "Invoice not found")})
    @GetMapping("/invoice")
    public Invoice invoice(@PathParam("bill") double bill, @PathParam("billType") int billType, @PathParam("user") int user){
        double discount = discountService.getTotalDiscount(bill, billType, user);
        return new Invoice(id_counter.incrementAndGet(), bill, discount, bill - discount);
    }

}
