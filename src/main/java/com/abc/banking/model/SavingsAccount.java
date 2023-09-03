/**
 * Specific Implementation of Account Class for  Savings Account
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.model;

import com.abc.banking.Utility.SavingsInterestCalculator;
public class SavingsAccount extends Account {
    public SavingsAccount() {
        super(new SavingsInterestCalculator());
    }
    @Override
    public String getAccountName() {
        return "Savings";
    }
}
