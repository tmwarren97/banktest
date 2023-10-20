package com.abc.account;

import com.abc.AccountType;
import com.abc.Transaction;
import com.abc.TransactionType;
import com.abc.calculator.MaxiSavingsInterestCalculator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class MaxiSavingsAccount extends Account {

    public MaxiSavingsAccount() {
        super(new MaxiSavingsInterestCalculator());
    }

    @Override
    public String getAccountName() {
        return AccountType.MAXI_SAVINGS.name();
    }

//    Change Maxi-Savings accounts to have an interest rate of 5% assuming no withdrawals in the past 10 days otherwise 0.1%

    public double getInterestRate()
    {
        return isNoWithdrawInPastTenDays() ? 0.05 : 0.001;
    }

    private boolean isWithinTenDays(Transaction transaction)
    {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.ofEpochDay(transaction.getTransactionDate().getTime()));
        return (days >= -10 && days < 0);
    }
    
    private boolean isNoWithdrawInPastTenDays()
    {
        transactions.sort(Comparator.comparing(transaction -> transaction.getTransactionDate()));
        for (Transaction transaction : transactions)
        {
            if(isWithinTenDays(transaction) && transaction.getTransactionType().equals(TransactionType.WITHDRAWAL.name()))
            {
                return false;
            }
        }
        return true;
    }
}
