package com.abc;

import com.abc.account.Account;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public Customer transferAccounts(Account fromAccount, Account toAccount, double amount)
            throws IllegalArgumentException
    {
        if (fromAccount == null)
        {
            throw new IllegalArgumentException("source account cannot be null");
        }

        if (toAccount == null)
        {
            throw new IllegalArgumentException("target account cannot be null");
        }

        if (fromAccount == toAccount)
        {
            throw new IllegalArgumentException("cannot transfer fund between same account");
        }
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        return this;
    }
    
    public double totalInterestEarned() {
        double total = 0;
        for (Account account : accounts)
            total += account.interestEarned();
        return total;
    }

    public List<Account> getAccounts()
    {
        return accounts;
    }


    public String getStatement() {
        StringBuilder statement = new StringBuilder("Statement for ");
        statement.append(name);
        statement.append("\n");
        double total = 0.00;
        for (Account account : accounts) {
            statement.append("\n");
            statement.append(statementForAccount(account));
            statement.append("\n");
            total += account.sumTransactions();
        }
        statement.append("\nTotal In All Accounts ");
        statement.append(toDollars(total));
        return statement.toString();
    }

    private String statementForAccount(Account a) {
        StringBuilder statement = new StringBuilder(account.printAccountType());
        //Now total up all the transactions
        double total = 0.00;
        for (Transaction transaction : account.getTransactions()) {
            statement.append("  ");
            statement.append(transaction.getAmount() < 0 ? TransactionType.WITHDRAWAL.name() : TransactionType.DEPOSIT.name());
            statement.append(" ");
            statement.append(toDollars(transaction.getAmount()));
            statement.append("\n");
            total += transaction.getAmount();
        }
        statement.append("Total ");
        statement.append(toDollars(total));
        return statement.toString();
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
