package com.abc.account;

import com.abc.Transaction;
import com.abc.calculator.InterestCalculator;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<Transaction> transactions;

    public List<Transaction>  getTransactions(){
        return transactions;
    }
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

    public double interestEarned() {
        double amount = sumTransactions();
        return interestCalculator.calculateInterest(amount);
    }

    public double sumTransactions() {
        return transactions.stream().map(t -> t.amount).reduce(0d,
                (a1, a2) -> a1 + a2);
    }

    //TODO check if checkIfTransactionsExist is used anywhere
    private boolean checkIfTransactionsExist(boolean checkAll) {
        return !transactions.isEmpty();
    }
    public String getAccountName() {
        return "Default";
    }

    private static final String ACCOUNT_TYPE_FORMAT  = "%s Accounts\n";

    public String printAccountType() {
        return String.format(ACCOUNT_TYPE_FORMAT, getAccountName());
    }

}
