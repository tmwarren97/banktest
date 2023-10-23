package com.abc.account;

import com.abc.Transaction;
import com.abc.calculator.InterestCalculator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    public List<Transaction> transactions;
    private final InterestCalculator interestCalculator;

    public Account(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
       this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
    }



    public double interestEarned(boolean fixed) {
        double amount = sumTransactions();
        return interestCalculator.calculateInterest(fixed,amount);
    }
    public double sumTransactions() {

        double amount = 0.0;
        for (Transaction t : transactions)
            amount += t.amount;
        return amount;
    }

    public String getAccountName() {
        return "Default";
    }


    private static final String ACCOUNT_TYPE_FORMAT  = "%s Accounts\n";

    public String printAccountType() {
        return String.format(ACCOUNT_TYPE_FORMAT, getAccountName());
    }

    public Date getLastTransactionDate()
    {
       return transactions.get(transactions.size()-1).getTransactionDate();
    }

}
