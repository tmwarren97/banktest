package com.abc.banking.model;

/**
 * Transaction Pojo Class
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
import com.abc.banking.Utility.DateProvider;
import java.util.Date;
public class Transaction {
    public  double amount;
    public Transaction(double amount) {
        this.amount = amount;
        Date transactionDate = DateProvider.getInstance().now();
    }
    public double getAmount() {
        return amount;
    }
}
