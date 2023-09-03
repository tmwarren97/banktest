package com.abc.banking.Utility;

import junit.framework.TestCase;
import org.junit.Test;

public class FlatRateInterestCalculatorTest extends TestCase {
    FlatRateInterestCalculator flatRateInterestCalculator = new FlatRateInterestCalculator();
    @Test
    public void testcalculateInterest()
    {
      assertEquals(1.0,flatRateInterestCalculator.calculateInterest(1000.00));
      assertEquals(0.0,flatRateInterestCalculator.calculateInterest(-1000.00));
      assertEquals(0.0,flatRateInterestCalculator.calculateInterest(0.0));

    }
}