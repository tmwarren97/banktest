package com.abc.banking.service;

import com.abc.banking.model.*;
import junit.framework.TestCase;
import org.junit.Test;

public class BankingServiceTest extends TestCase {
    Customer customer = new Customer("Tamal");
    Account checkingAccount = new CheckingAccount();
    Account savingAccount = new SavingsAccount();
    Account maxSavingsAccount = new MaxiSavingsAccount();
    BankingService bankingService = new BankingService(customer);
    CustomerService customerService = new CustomerService(customer);

    @Test
    public void testCustomerSummary() {
        customerService.openAccount(maxSavingsAccount);
        customerService.deposit(savingAccount, 50000);
        assertEquals("Customer Summary\n - Tamal (1 account)", bankingService.customerSummary());
    }
    @Test
    public void testCustomerforMultipleAccounts() {
        customerService.openAccount(maxSavingsAccount);
        customerService.deposit(savingAccount, 50000);
        customerService.openAccount(savingAccount);
        customerService.deposit(savingAccount, 500);
        assertEquals("Customer Summary\n - Tamal (2 accounts)", bankingService.customerSummary());
    }
    @Test
    public void testCustomerSummaryforMultipleCustomers() {
        BankingService   bankingService =  multipleCustomer();
      assertEquals("Customer Summary\n - Drik1 (1 account)\n - Drik2 (1 account)", bankingService.customerSummary());
    }
    @Test
    public void testCustomerforNoAccounts() {
        assertEquals("Customer Summary\n - Tamal (0 accounts)", bankingService.customerSummary());
    }
    @Test
    public void testtotalInterestPaidforMultipleCustomer() {
        BankingService bankingService =   multipleCustomer();
        assertEquals(1.0,bankingService.totalInterestPaid());
    }
public BankingService multipleCustomer()
{
    Customer   customer1 = new Customer("Drik1");
    BankingService bankingService1   = new BankingService(customer1);
    CustomerService customerService1   = new CustomerService(customer1);
    Account checkingAccount1 = new CheckingAccount();
    customerService1.openAccount(checkingAccount1);
    customerService1.deposit(checkingAccount1,500);

//Customer 2
    Customer   customer2 = new Customer("Drik2");
    CustomerService customerService2   = new CustomerService(customer2);
    Account checkingAccount2 = new CheckingAccount();
    customerService2.openAccount(checkingAccount2);
    customerService2.deposit(checkingAccount2,500);
    bankingService1.addCustomer(customer2);
    return bankingService1;
}
}