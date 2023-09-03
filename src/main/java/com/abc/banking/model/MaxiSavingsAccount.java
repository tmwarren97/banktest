/**
 * Specific Implementation of Account Class for Maximum Savings Account
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.model;

import com.abc.banking.Utility.MaxiSavingsInterestCalculator;
public class MaxiSavingsAccount extends Account {
    public MaxiSavingsAccount() {
        super(new MaxiSavingsInterestCalculator());
    }
    @Override
    public String getAccountName() {
        return "Maxi-Savings";
    }

}
