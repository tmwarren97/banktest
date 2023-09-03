package com.abc.banking.controller;
import com.abc.banking.model.Account;
import com.abc.banking.model.CheckingAccount;
import com.abc.banking.model.Customer;
import com.abc.banking.service.CustomerService;
import junit.framework.TestCase;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomerControllerTest extends TestCase {
    CustomerService customerService = mock(CustomerService.class);
    CustomerController customerController = new CustomerController(customerService);

    Account checkingAccount = new CheckingAccount();
    Customer customer  = new Customer("Tamal");
    @Test
    public void testOpenAccounts()
    {
        customerController.openAccount(checkingAccount);
        verify(customerService).openAccount(checkingAccount);
    }
@Test
    public void testDeposit() {
        customerController.deposit(checkingAccount,100.50);
        verify(customerService).deposit(checkingAccount,100.50);
    }
    @Test
    public void testWithdraw() {
        customerController.withdraw(checkingAccount,100.50);
        verify(customerService).withdraw(checkingAccount,100.50);
    }
    @Test
    public void testStatements()
    {
        customerController.getStatement(customer);
        verify(customerService).getStatement(customer);
    }
}