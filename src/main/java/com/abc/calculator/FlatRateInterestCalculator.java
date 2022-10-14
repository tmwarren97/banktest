package com.abc.calculator;

public class FlatRateInterestCalculator implements InterestCalculator {

    public static final double ONE_PERCENT = 0.01;
    public static final double TWO_PERCENT = 0.02;

    private final double flatRate;

    public FlatRateInterestCalculator() {
        this(TWO_PERCENT);
    }

    public FlatRateInterestCalculator(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculateInterest(double amount) {
        // TODO: implement flat rate logic - flat rate should be amount times the flatRate
        return flatRate;
    }
}
