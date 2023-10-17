package com.abc;

import com.abc.account.Account;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private final String name;
    private List<Account> accounts;

    public Customer(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException ();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        if(accounts == null) {
            accounts = new ArrayList<>();
        }
        return accounts;
    }

    public Customer openAccount(Account account) {
        getAccounts().add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return getAccounts().size();
    }

    public double totalInterestEarned() {
        double total = 0;
        total = getAccounts().stream().map(Account::interestEarned)
                .reduce(total, Double::sum);
        return total;
    }

    public String getStatement() {
        StringBuilder stringBuilder = new StringBuilder("Statement for " + name + "\n");
        double total = 0.0;
        for (Account account : getAccounts()) {
            stringBuilder.append("\n").append(statementForAccount(account)).append("\n");
            total += account.sumTransactions();
        }
        stringBuilder.append("\nTotal In All Accounts ").append(toDollars(total));
        return stringBuilder.toString();
    }

    public boolean transfer (String sourceAccountId, String destinationAccountId, Double amount) {
        Account sourceAccount = getAccounts().stream().filter(a -> a.getAccountId().equals(sourceAccountId))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No Account with accountId " + sourceAccountId));
        Account destinationAccount = getAccounts().stream().filter(a -> a.getAccountId().equals(destinationAccountId))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No Account with accountId " + destinationAccountId));
        double sourceBalance = sourceAccount.sumTransactions();
        if(amount > 0 && sourceBalance >= amount) {
            destinationAccount.deposit(amount);
            sourceAccount.withdraw(amount);
            return true;
        }
        return false;
    }
    private String statementForAccount(Account account) {
        StringBuilder stringBuilder = new StringBuilder(account.printAccountType());

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction transaction : account.getTransactions()) {
            stringBuilder.append("  ").append(transaction.getAmount() < 0 ? "withdrawal" : "deposit").append(" ")
                    .append(toDollars(transaction.getAmount())).append("\n");
            total += transaction.getAmount();
        }
        stringBuilder.append("Total ").append(toDollars(total));
        return stringBuilder.toString();
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }

}
