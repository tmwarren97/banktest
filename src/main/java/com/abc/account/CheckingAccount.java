package com.abc.account;

import com.abc.calculator.FlatRateInterestCalculator;
import com.abc.AccountType;

public class CheckingAccount extends Account {

    public CheckingAccount() {
        super(new FlatRateInterestCalculator());
    }

    @Override
    public String getAccountName() {
        return AccountType.CHECKING.name();
    }
}
