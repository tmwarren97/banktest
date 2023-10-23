package com.abc;

import com.abc.account.Account;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
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

    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts) {
            Calendar c = Calendar.getInstance();
            //Date now = c.getTime();
            c.add(Calendar.DATE,-10);
            if (a.getAccountName() == "Maxi-Savings" && a.getLastTransactionDate().after(c.getTime()))
                total += a.interestEarned(true);
            else
                total += a.interestEarned(false);
        }
        return total;
    }

    public void transfer(Account fromAccount, Account toAccount, Double amount)
    {

        Account matchingFromAccount = accounts.stream().filter(Account -> fromAccount.equals(this)).findAny().orElse(null);
        Account matchingToAccount = accounts.stream().filter(Account -> toAccount.equals(this)).findAny().orElse(null);
       if (matchingFromAccount != null && matchingToAccount != null) {
           fromAccount.withdraw(amount);
           toAccount.deposit(amount);
       }
    }
    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(Account a) {
        String s = a.printAccountType();

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.transactions) {
            s += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total += t.amount;
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
