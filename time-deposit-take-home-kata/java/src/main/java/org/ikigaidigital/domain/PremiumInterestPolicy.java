package org.ikigaidigital.domain;

import org.ikigaidigital.TimeDeposit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PremiumInterestPolicy implements InterestPolicy{

    private static final int PREMIUM_START_DAY = 45;
    private static final BigDecimal RATE = new BigDecimal("0.05");

    @Override
    public void apply(TimeDeposit deposit) {

        BigDecimal balance =  new BigDecimal(deposit.getBalance());
        // No interest is applied for the first 45 days
        if (deposit.getDays() < PREMIUM_START_DAY) return;

        //calculate interest for Premium Plan
        BigDecimal interest = balance.multiply(RATE).divide(NUMBER_OF_MONTHS_A_YEAR, RoundingMode.HALF_UP);
        deposit.increaseBalance(interest);
    }
}
