package com.abc.account;

import com.abc.calculator.MaxiSavingsInterestCalculator;

public class MaxiSavingsAccount extends Account {

    public MaxiSavingsAccount() {
        super(new MaxiSavingsInterestCalculator());
    }

    @Override
    public String getAccountName() {
        return "Maxi-Savings";
    }

}
