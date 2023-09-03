package com.abc.banking.Utility;
import com.abc.banking.interfaces.InterestInterface;
import static com.abc.banking.model.InterestRate.*;
public class FlatRateInterestCalculator implements InterestInterface {
    @Override
    public double calculateInterest(double amount) {
        if( amount <= 0.0 )
            return 0.0;
        return amount * FLAT_RATE ;
    }
}
