package com.abc.account;

import com.abc.Transaction;
import com.abc.calculator.InterestCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Account {

    private List<Transaction> transactions;
    private final InterestCalculator interestCalculator;

    private final String accountId;

    public Account(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
        this.accountId = generateRandomAccountNumber();
    }

    public String getAccountId() {
        return accountId;
    }

    public List<Transaction> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            getTransactions().add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            getTransactions().add(new Transaction(-amount));
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
        for (Transaction transaction : getTransactions()) {
            amount += transaction.getAmount();
        }
        return amount;
    }

    public String getAccountName() {
        return "Default";
    }

    private static final String ACCOUNT_TYPE_FORMAT  = "%s Accounts\n";

    public String printAccountType() {
        return String.format(ACCOUNT_TYPE_FORMAT, getAccountName());
    }


    private String generateRandomAccountNumber() {
        Random random = new Random();
        // Generate a random 10-digit number
        return "" +  1000000000L + (long) (random.nextDouble() * 9000000000L);

    }
}
