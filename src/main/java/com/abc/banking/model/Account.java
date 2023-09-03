/**
 * Account POJO Class
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.model;
import com.abc.banking.interfaces.InterestInterface;
import java.util.*;
public class Account {
    private List<Transaction> transactions;
    private InterestInterface interestCalculator;
    private double interestEarned;
    public Account(InterestInterface interestInterface) {
        this.setInterestCalculator(interestInterface);
        this.transactions = new ArrayList<>();
    }
    public double getInterestEarned() {
        return interestEarned;
    }
    public void setInterestEarned(double interestEarned) {
        this.interestEarned = interestEarned;
    }
    public InterestInterface getInterestCalculator() {
        return interestCalculator;
    }
    public void setInterestCalculator(InterestInterface interestCalculator) {
        this.interestCalculator = interestCalculator;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public String getAccountName() {
        return "Default";
    }
    private static final String ACCOUNT_TYPE_FORMAT  = "%s Account\n";
    public String printAccountType() {
        return String.format(ACCOUNT_TYPE_FORMAT, getAccountName());
    }
}
