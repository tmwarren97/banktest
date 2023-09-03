package com.abc.banking.service;

import com.abc.banking.model.Account;
import com.abc.banking.model.Customer;
import com.abc.banking.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class BankingService {
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Account> accounts = new ArrayList<Account>();
    private Customer customer;
    private static final Logger LOG = LoggerFactory.getLogger(BankingService.class) ;
    public BankingService(Customer customer) {
        this.customer = customer;
        customers.add(customer);
    }
    public BankingService(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getAccounts().size(), "account") + ")";
        return summary;
    }
    public double totalInterestPaid() {
        double total = customers.stream().map(x->x.getTotalInterestEarned()).reduce(0.0,(a,b)->a+b);
        LOG.debug("Total interest Earned " + total);
        return total;
    }
    public String getFirstCustomer() {
        String firstCustomer = customers.stream().map(x->x.getName()).findFirst().orElse("No Customer Found");
        return firstCustomer;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

}
