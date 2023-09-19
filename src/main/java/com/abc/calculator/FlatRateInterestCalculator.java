package com.abc.calculator;

public class FlatRateInterestCalculator implements InterestCalculator {

    private final double flatRate;

    public FlatRateInterestCalculator(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculateInterest(double amount) {
        return amount * flatRate;
    }
}
