package com.abc.account;

import com.abc.calculator.FlatRateInterestCalculator;
import com.abc.calculator.InterestCalculator;

public class CheckingAccount extends Account {

    public CheckingAccount() {
        super(new FlatRateInterestCalculator(InterestCalculator.ONE_PERCENT));
    }

    @Override
    public String getAccountName() {
        return "Checking";
    }
}
