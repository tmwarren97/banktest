package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void totalInterestWithMultipleCustomersPaidTest() {
        double EXPECTED_INTEREST_PAID = 0.7;
        Bank bank = new Bank();

        //  **Checking accounts** have a flat rate of 0.1%
        Account billsCheckingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(billsCheckingAccount);
        bank.addCustomer(bill);
        billsCheckingAccount.deposit(200.0);

        Account raksCheckingAccount = new Account(Account.SAVINGS);
        Customer Rak = new Customer("Rak").openAccount(raksCheckingAccount);
        bank.addCustomer(Rak);
        raksCheckingAccount.deposit(500.0);

        // Calculates total interest the bank paid to all customers and their accounts
        double actualVal = bank.totalInterestPaid();

        // The value of 0.2 is the correct amount.
        assertEquals(EXPECTED_INTEREST_PAID,  actualVal, DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

}
