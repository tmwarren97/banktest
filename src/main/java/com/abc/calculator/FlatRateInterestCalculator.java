package com.abc.calculator;

public class FlatRateInterestCalculator implements InterestCalculator {

    private static final double ONE_PERCENT = 0.05;

    public FlatRateInterestCalculator() {
    }

    @Override
    public double calculateInterest(double amount) {
        return amount * ONE_PERCENT;
    }
}
