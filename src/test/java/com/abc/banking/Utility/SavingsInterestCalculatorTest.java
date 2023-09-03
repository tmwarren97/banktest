package com.abc.banking.Utility;

import junit.framework.TestCase;
import org.junit.Test;

public class SavingsInterestCalculatorTest extends TestCase {
SavingsInterestCalculator savingsInterestCalculator = new SavingsInterestCalculator();
@Test
public void testCalculateInterest() {
        assertEquals(1.0,savingsInterestCalculator.calculateInterest(1000.00));
        assertEquals(0.0,savingsInterestCalculator.calculateInterest(-250000.00));
        assertEquals(499.0,savingsInterestCalculator.calculateInterest(250000.00));
        assertEquals(0.0,savingsInterestCalculator.calculateInterest(0.0));

    }
}