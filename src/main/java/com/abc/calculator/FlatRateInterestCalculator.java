package com.abc.calculator;

public class FlatRateInterestCalculator implements InterestCalculator {

    public static final double ONE_PERCENT = 0.001;
    public static final double TWO_PERCENT = 0.002;

    private final double flatRate;

    public FlatRateInterestCalculator() {
        this(TWO_PERCENT);
    }

    public FlatRateInterestCalculator(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculateInterest(double amount) {
        return flatRate;
    }
}
