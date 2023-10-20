package com.abc.account;

import com.abc.AccountType;
import com.abc.Transaction;
import com.abc.calculator.InterestCalculator;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private static final String ACCOUNT_TYPE_FORMAT  = "%s Accounts\n";
    protected List<Transaction> transactions = new ArrayList<>();
    private final InterestCalculator interestCalculator;
    private double accountBalance;
    
    public Account(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }
        accountBalance += amount;
        transactions.add(new Transaction(amount, TransactionType.DEPOSIT.name()));
        
    }

    public List<Transaction> getTransactions()
    {
        return transactions;
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }

        if (amount > accountBalance)
        {
            throw new IllegalArgumentException("Insufficient fund");
        }
        accountBalance -= amount;
        transactions.add(new Transaction(-amount, TransactionType.WITHDRAWAL.name()));
        
    }

    public double interestEarned() {
        double amount = sumTransactions();
        return interestCalculator.calculateInterest(amount);
    }

    public double sumTransactions() {
        return calculateTotalTransactionsAmount();
    }

    public boolean checkIfTransactionExists()
    {
         return !transactions.isEmpty();   
    }
    
    public String getAccountName() {
        return AccountType.DEFAULT.name();
    }

    public double getAccountBalance()
    {
        return accountBalance;
    }
    
    public String printAccountType() {
        return String.format(ACCOUNT_TYPE_FORMAT, getAccountName());
    }
    
    private double calculateTotalTransactionsAmount() {
        double amount = 0.0;
        for (Transaction transaction : transactions)
            amount += transaction.amount;
        return amount;
    }

}
