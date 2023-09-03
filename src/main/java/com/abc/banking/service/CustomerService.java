package com.abc.banking.service;

import com.abc.banking.model.*;
import java.util.ArrayList;
import static java.lang.Math.abs;

public class CustomerService {
    private  Customer  customer;
    public CustomerService(Customer customer) {
        this.customer = customer;
        this.customer.setAccounts(new ArrayList<Account>());
    }
    public  boolean openAccount(Account account) {
       return  customer.getAccounts().add(account);
    }
    public void deposit(Account account,double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            updateAccountHistory(account,amount);
        }
    }
    public void withdraw(Account account,double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            updateAccountHistory(account,-amount);
        }
    }
    public String getStatement(Customer customer) {
        String statement = null;
        statement = "Statement for " + customer.getName() + "\n";
        double total = 0.0;
        for (Account account : customer.getAccounts()) {
            statement += "\n" + statementForAccount(account) + "\n";
            total += account.getTransactions().stream().map(x->x.getAmount()).reduce(0.0,(a,b)->a+b);
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }
    private String statementForAccount(Account a) {
        String s = a.printAccountType();
        double total = 0.0;
        for (Transaction t : a.getTransactions()) {
            s += "  " + (t.getAmount() < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.getAmount()) + "\n";
            total += t.getAmount();
        }
        s += "Total " + toDollars(total);
        return s;
    }


    private void updateAccountHistory(Account account,double amount) {
        account.getTransactions().add(new Transaction(amount));
        account.setTransactions(account.getTransactions());
        account.setInterestEarned( account.getInterestCalculator().calculateInterest(account.getTransactions().stream().map(x->x.getAmount()).reduce(0.0,(a,b)->a+b)));
        customer.setTotalInterestEarned(totalInterestEarned());
    }
    public double totalInterestEarned() {
       return  customer.getAccounts().stream().map(account->account.getInterestEarned()).reduce(0.0,(a,b)->a+b);
    }
    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }


}
