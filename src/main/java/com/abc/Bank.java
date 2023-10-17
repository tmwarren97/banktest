package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Bank {
    private static final Logger LOG = LoggerFactory.getLogger(Bank.class);

    private List<Customer> customers;

    public Bank() {
    }

    private List<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        return customers;
    }

    public void addCustomer(Customer customer) {
        getCustomers().add(customer);
    }

    public String customerSummary() {
        String summary = "Customer Summary";
        summary = getCustomers().stream().map(customer -> "\n - " + customer.getName() + " (" + format(customer.getNumberOfAccounts(), "account") + ")")
                .reduce(summary, String::concat);
        return summary;
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = 0;
        LOG.debug("value of total local variable before entering the loop was " + total);
        total = getCustomers().stream().map(Customer::totalInterestEarned)
                .reduce(total, Double::sum);
        LOG.debug("value of total local variable was " + total);

        return total;
    }

    //TODO to be used in the future features.
    public Optional<String> getFirstCustomer() {
        Optional<String> firstCustomerName = Optional.empty();
        try {
            if (!getCustomers().isEmpty())
                firstCustomerName = Optional.of(getCustomers().get(0).getName());
        } catch (Exception e) {
            LOG.error("Unexpected exception in the method getFirstCustomer", e);
        }
        return firstCustomerName;
    }
}
