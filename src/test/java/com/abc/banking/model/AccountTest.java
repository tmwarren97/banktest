/**
 * Account POJO Class Test
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.model;

import com.abc.banking.interfaces.InterestInterface;
import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

public class AccountTest extends TestCase {
@Test
    public void testAccountInitialization()
{
    InterestInterface interesInterfac = new InterestInterface() {
        @Override
        public double calculateInterest(double amount) {
            return 0;
        }
    };
    Account account  =new Account(interesInterfac);
    account.setTransactions((List<Transaction>) new Transaction(100));
    account.setInterestEarned(10.00);
    assertEquals("Default",account.getAccountName());
    assertEquals(1, account.getTransactions().size());
    assertEquals(10.00, account.getInterestEarned());
}

}