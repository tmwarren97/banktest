package com.abc.account;

import com.abc.calculator.SavingsInterestCalculator;
import com.abc.AccountType;

public class SavingsAccount extends Account {

    public SavingsAccount() {
        super(new SavingsInterestCalculator());
    }

    @Override
    public String getAccountName() {
        return AccountType.SAVINGS.name();
    }
}
