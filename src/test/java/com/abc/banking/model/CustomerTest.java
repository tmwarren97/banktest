package com.abc.banking.model;

import junit.framework.TestCase;

import java.util.List;

public class CustomerTest extends TestCase {

    public void testCustomerInitialization() {
        Customer customer = new Customer("Tamal");
        customer.setAccounts((List<Account>) new CheckingAccount());
        customer.setTotalInterestEarned(10.01);
      assertEquals(customer.getAccounts().size(),1);
        assertEquals(10.01,customer.getTotalInterestEarned());
    }
}