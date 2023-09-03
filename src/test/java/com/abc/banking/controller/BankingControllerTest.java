package com.abc.banking.controller;

import com.abc.banking.service.BankingService;
import junit.framework.TestCase;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankingControllerTest extends TestCase {
   BankingService bankingService = mock(BankingService.class);
   BankingController bankingController = new BankingController(bankingService);
   @Test
    public void testGetCustomerSummary() {
        bankingController.getCustomerSummary();
        verify(bankingService).customerSummary();
    }
    @Test
    public void testTotalInterestPaid() {
        bankingController.totalInterestPaid();
        verify(bankingService).totalInterestPaid();
    }

}