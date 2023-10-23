package com.abc.calculator;

import java.util.Calendar;

public class FlatRateInterestCalculator implements InterestCalculator {

    public static final double ONE_PERCENT = 0.001;

    private final double flatRate;

    public FlatRateInterestCalculator(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculateInterest(boolean fixed, double amount) {
        int doy  = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        return amount * flatRate/365 * doy;
    }
}
