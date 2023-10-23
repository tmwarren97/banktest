package com.abc.calculator;

import java.util.Calendar;

public class SavingsInterestCalculator implements InterestCalculator {

    @Override
    public double calculateInterest(boolean fixed, double amount) {
        int doy  = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        if (amount <= 1000)
            return amount * 0.001/365 * doy;
        else
            return 1 + (amount - 1000) * 0.002/365 * doy;
    }

}
