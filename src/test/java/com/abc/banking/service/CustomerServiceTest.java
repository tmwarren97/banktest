package com.abc.banking.service;

import com.abc.banking.model.*;
import junit.framework.TestCase;
import org.junit.Test;

import static java.lang.Math.abs;


public class CustomerServiceTest extends TestCase {
    Account checkingAccount = new CheckingAccount();
    Account savingAccount = new SavingsAccount();
    MaxiSavingsAccount maxsavingAccount = new MaxiSavingsAccount();
    Customer customer= new Customer("Tamal");
    CustomerService customerService = new CustomerService(customer);
    private void openAccounts() {
        customerService.openAccount(checkingAccount);
        customerService.openAccount(savingAccount);
    }
    private void accountTransactions() {
        customerService.deposit(checkingAccount,100);
        customerService.deposit(savingAccount,4000);
        customerService.withdraw(savingAccount,200);
    }
@Test
    public void testOpenAccount() {
        openAccounts();
        assertEquals(2, customer.getAccounts().size());
        assertEquals(1,customer.getAccounts().indexOf(savingAccount));
    }
    public void testMaxSavingsOpenAccount() {
        customerService.openAccount(maxsavingAccount);
        assertEquals(1, customer.getAccounts().size());
        assertEquals(0,customer.getAccounts().indexOf(maxsavingAccount));
    }
    @Test
    public void testTransactions()
    {
        openAccounts();
        accountTransactions();
        //Interest earned for 100 dollar checking account
       assertEquals("$0.10",toDollars(customer.getAccounts().get(0).getInterestEarned()));
        //Interest earned for 3800 dollar savings  account
        assertEquals("$6.60",toDollars(customer.getAccounts().get(1).getInterestEarned()));
        //100*0.001+1000*0.001+2800* 0.002 = 6.7 for savings account
        assertEquals("$6.70",toDollars(customerService.totalInterestEarned()));
    }
    @Test
    public void testStatements() {
        openAccounts();
        accountTransactions();
        assertEquals("Statement for Tamal\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", customerService.getStatement(customer));
    }
    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}