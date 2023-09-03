package com.abc.banking.Utility;

import junit.framework.TestCase;
import org.junit.Test;

public class MaxiSavingsInterestCalculatorTest extends TestCase {
    MaxiSavingsInterestCalculator maxiSavingsInterestCalculator = new MaxiSavingsInterestCalculator();

    @Test
    public void testCalculateInterest() {
        assertEquals(20.0, maxiSavingsInterestCalculator.calculateInterest(1000.00));
        assertEquals(0.0, maxiSavingsInterestCalculator.calculateInterest(-250000.00));
        assertEquals(24870.0, maxiSavingsInterestCalculator.calculateInterest(250000.00));
        assertEquals(0.0, maxiSavingsInterestCalculator.calculateInterest(0.0));

    }
}