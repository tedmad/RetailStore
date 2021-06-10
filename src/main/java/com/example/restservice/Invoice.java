package com.example.restservice;

public class Invoice {
    private  final long id;
    private final double amountPaid;
    private final double discount;
    private final double netPayable;

    public Invoice(long id, double amountPaid, double discount, double netPayable) {
        this.id = id;
        this.amountPaid = amountPaid;
        this.discount = discount;
        this.netPayable = netPayable;
    }

    public long getId() {
        return id;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getDiscount() {
        return discount;
    }

    public double getNetPayable() {
        return netPayable;
    }
}
