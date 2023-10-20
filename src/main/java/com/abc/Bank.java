package com.abc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {
	private static final Logger LOG = LoggerFactory.getLogger(Bank.class) ;
	
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        StringBuilder summary = new StringBuilder("Customer Summary");
        for (Customer customer : customers) {
            summary.append("\n - ");
            summary.append(customer.getName());
            summary.append(" (");
            summary.append(format(customer.getNumberOfAccounts(), "account"));
            summary.append(")");
        }
        return summary.toString();
    }

    public double totalInterestPaid() {
        double total = 0.00;
        
        LOG.debug("value of total local variable before enetering htloop was " + total);
        
        for(Customer customer: customers)
            total += customer.totalInterestEarned();
        
        LOG.debug("value of total local variable was " + total);
        
        return total;
    }

    public Optional<String> getFirstCustomer() {
        if (customers.isEmpty())
		return Optional.empty();
        return Optional.of(customers.get(0).getName());
    }

//Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }	
}
