package com.example.restservice;

/**
 * This a model class for the invoice.
 */
public class Invoice {

    //A unique identifier variable
    private  final long id;
    //The total amount of goods to be purchased
    private final double amountPaid;
    //Total amount of all possible discounts
    private final double discount;
    //Amount payable after discount
    private final double netPayable;

    /**
     * This a handler method for HTTP GET request.
     * @param id A unique identifier.
     * @param amountPaid  The total amount of goods to be purchased.
     * @param discount  Total amount of all possible discounts.
     * @param netPayable Amount payable after discount.
     */
    public Invoice(long id, double amountPaid, double discount, double netPayable) {
        this.id = id;
        this.amountPaid = amountPaid;
        this.discount = discount;
        this.netPayable = netPayable;
    }

    /**
     * This method returns a unique identifier for the Invoice.
     * @return  long .
     */
    public long getId() {
        return id;
    }

    /**
     * This method returns the total amount of goods to be purchased.
     * @return  double
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * This method returns the total amount of all possible discounts.
     * @return  double
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * This method returns the amount payable after discount.
     * @return  double
     */
    public double getNetPayable() {
        return netPayable;
    }
}
