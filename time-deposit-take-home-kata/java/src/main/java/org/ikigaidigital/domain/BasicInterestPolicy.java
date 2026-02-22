package org.ikigaidigital.domain;

import org.ikigaidigital.TimeDeposit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicInterestPolicy implements InterestPolicy {

    private static final BigDecimal RATE = new BigDecimal("0.01");

    @Override
    public void apply(TimeDeposit deposit) {

           BigDecimal balance =  new BigDecimal(deposit.getBalance());
        // No interest is applied for the first 30 days for any existing plans
             if (deposit.getDays() <= GRACE_PERIOD_DAYS) return;

             // Calculate interest rate for Basic Plan
             BigDecimal interest = balance.multiply(RATE).divide(NUMBER_OF_MONTHS_A_YEAR, RoundingMode.HALF_UP);
             deposit.increaseBalance(interest);
    }
}
