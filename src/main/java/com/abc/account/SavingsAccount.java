package com.abc.account;

import com.abc.calculator.SavingsInterestCalculator;

public class SavingsAccount extends Account {

    public SavingsAccount() {
        super(new SavingsInterestCalculator());
    }

    @Override
    public String getAccountName() {
        return "Savings";
    }
}
