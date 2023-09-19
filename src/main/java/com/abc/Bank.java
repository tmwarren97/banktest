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
        String summary = "Customer Summary";
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        return summary;
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        //TODO refactor with streams -- map and reduce
        double total = 0;
        
        LOG.debug("value of total local variable before enetering htloop was " + total);
        
        for(Customer c: customers)
            total += c.totalInterestEarned();
        
        LOG.debug("value of total local variable was " + total);
        
        return total;
    }

    public String getFirstCustomer() {
        try {
            //TODO refactor using Optionals
            if (null != customers)
                return customers.get(0).getName();
            else return null;
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
