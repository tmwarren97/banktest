/**
 * Specific Implementation of Account Class for CheckingAccount
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.model;
import com.abc.banking.Utility.FlatRateInterestCalculator;
public class CheckingAccount extends Account {
    public CheckingAccount() {super(new FlatRateInterestCalculator());}
    @Override public String getAccountName() {
        return "Checking";
    }
}
