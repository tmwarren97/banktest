package com.abc.calculator;

import java.util.Calendar;
import java.util.Date;
public class MaxiSavingsInterestCalculator implements InterestCalculator {

    @Override
    public double calculateInterest(boolean fixed, double amount) {

        int doy  = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);

        if (fixed) return amount * 0.05/365 * doy;
        else return amount * 0.001/365 * doy;

        // old code

        // if (amount <= 1000)
        //     return amount * 0.02;
        // if (amount <= 2000)
        //     return 20 + (amount - 1000) * 0.05;
        // return 70 + (amount - 2000) * 0.1;
        //
    }




}
