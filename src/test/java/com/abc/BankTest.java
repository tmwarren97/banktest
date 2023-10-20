package com.abc;

import com.abc.account.Account;
import com.abc.account.CheckingAccount;
import com.abc.account.MaxiSavingsAccount;
import com.abc.account.SavingsAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new CheckingAccount());
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void totalInterestWithMultipleCustomersPaidTest() {
        double EXPECTED_INTEREST_PAID = 2.5;
        Bank bank = new Bank();

        Account raksAccount = new SavingsAccount();
        Customer Rak = new Customer("Rak").openAccount(raksAccount);
        bank.addCustomer(Rak);
        raksAccount.deposit(500.0);

        Account billsAccount = new CheckingAccount();
        Customer bill = new Customer("Bill").openAccount(billsAccount);
        bank.addCustomer(bill);
        billsAccount.deposit(200.0);


        double actualVal = bank.totalInterestPaid();

        assertEquals(EXPECTED_INTEREST_PAID,  actualVal, DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account savingsAccount = new SavingsAccount();
        bank.addCustomer(new Customer("Bill").openAccount(savingsAccount));

        savingsAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account maxiSavingsAccount = new MaxiSavingsAccount();
        bank.addCustomer(new Customer("Bill").openAccount(maxiSavingsAccount));

        maxiSavingsAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void getFirstCustomer() {
        Bank bank = new Bank();
        assertThrows(NoCustomersException.class, bank::getFirstCustomer);

        Account raksAccount = new SavingsAccount();
        Customer Rak = new Customer("Rak").openAccount(raksAccount);
        bank.addCustomer(Rak);

        Account billsAccount = new CheckingAccount();
        Customer bill = new Customer("Bill").openAccount(billsAccount);
        bank.addCustomer(bill);

        assertEquals("Rak", bank.getFirstCustomer());
    }
}
