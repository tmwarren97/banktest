package com.abc;

import java.util.Date;

public class Transaction {
    private final double amount;
    private String transactionType;
    private Date transactionDate;

    public Transaction(double amount, String transactionType) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
        this.transactionType = transactionType;
    }

    public double getAmount()
    {
        return amount;
    }

    public Date getTransactionDate()
    {
        return transactionDate;
    }

    public String getTransactionType()
    {
        return transactionType;
    }
}
