package com.abc.banking.Utility;
import com.abc.banking.interfaces.InterestInterface;
import static com.abc.banking.model.InterestRate.*;
public class SavingsInterestCalculator implements InterestInterface {

    @Override
    public double calculateInterest(double amount) {
             if( amount < 0.0 )
                 return 0.0;
        double additionalInterestAfterthous = 0.0;
        if (amount <= THOUSAND) {
            amount =  amount * FLAT_RATE;
        } else {
            additionalInterestAfterthous = (amount - THOUSAND) * SAV_RATE;
            amount = THOUSAND * FLAT_RATE;
            amount = amount + additionalInterestAfterthous;
        }
   return     amount;
    }

}
