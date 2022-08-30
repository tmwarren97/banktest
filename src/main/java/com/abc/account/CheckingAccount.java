package com.abc.account;

import com.abc.calculator.FlatRateInterestCalculator;

import static com.abc.calculator.FlatRateInterestCalculator.ONE_PERCENT;

public class CheckingAccount extends Account {

    public CheckingAccount() {
        super(new FlatRateInterestCalculator(ONE_PERCENT));
    }

    @Override
    public String getAccountName() {
        return "Checking";
    }
}
