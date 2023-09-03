package com.abc.banking.Utility;

import com.abc.banking.interfaces.InterestInterface;

import static com.abc.banking.model.InterestRate.*;

public class MaxiSavingsInterestCalculator implements InterestInterface {
    @Override
    public double calculateInterest(double amount) {
        double additionalInterestAfterthou;
        if( amount < 0.0 )
            return 0.0;
        if (amount <= THOUSAND) {
            amount = amount * MAX_SAV_RATE1;
        }

      else  if (amount <=  (THOUSAND+THOUSAND))
        {
            additionalInterestAfterthou = (amount- THOUSAND) * MAX_SAV_RATE2;
            amount = THOUSAND * MAX_SAV_RATE1;
            amount = amount + additionalInterestAfterthou;

        }

        else
        {
          double  additionalInterestAfterTwothou = amount-(THOUSAND+THOUSAND);
            amount = THOUSAND * MAX_SAV_RATE1;
            amount += THOUSAND * MAX_SAV_RATE2;
            amount +=additionalInterestAfterTwothou * MAX_SAV_RATE3;
            return amount;
        }
        return amount;

    }

}
