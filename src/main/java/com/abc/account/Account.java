package com.abc.account;

import com.abc.Transaction;
import com.abc.calculator.InterestCalculator;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final List<Transaction> transactions;
    private final InterestCalculator interestCalculator;

    public Account(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
        this.transactions = new ArrayList<Transaction>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
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

    public double interestEarned() {
        double amount = sumTransactions();
        return interestCalculator.calculateInterest(amount);
    }

    public double sumTransactions() {
        return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t : transactions) {
            amount += t.getAmount();
        }
        return amount;
    }

    public String getAccountName() {
        return "Default";
    }

    private static final String ACCOUNT_TYPE_FORMAT = "%s Account\n";

    public String printAccountType() {
        return String.format(ACCOUNT_TYPE_FORMAT, getAccountName());
    }

}
