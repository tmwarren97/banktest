package com.abc.calculator;

public class SavingsInterestCalculator implements InterestCalculator {

    @Override
    public double calculateInterest(double amount) {
        if (amount <= 1000)
            return amount * 0.001;
        return 1 + (amount - 1000) * 0.002;
    }

}
