/**
 * Customer POJO Class
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.model;
import java.util.*;
public class Customer {
    private UUID id;
    private String name;
    private List<Account> accounts;
    private double totalInterestEarned;
    public Customer(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    public double getTotalInterestEarned() {
        return totalInterestEarned;
    }
    public void setTotalInterestEarned(double totalInterestEarned) {
        this.totalInterestEarned = totalInterestEarned;
    }
    public String getName() {
        return name;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
