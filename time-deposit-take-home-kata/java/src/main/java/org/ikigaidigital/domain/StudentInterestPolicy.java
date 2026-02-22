package org.ikigaidigital.domain;

import org.ikigaidigital.TimeDeposit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StudentInterestPolicy implements InterestPolicy {


    private static final int STUDENT_START_DAYS = 366;
    private static final BigDecimal RATE = new BigDecimal("0.03");

    @Override
    public void apply(TimeDeposit deposit) {

         BigDecimal balance =  new BigDecimal(deposit.getBalance());
         if(deposit.getDays() < GRACE_PERIOD_DAYS  ||  deposit.getDays() > STUDENT_START_DAYS) return;

         // calculate interest for Student plan
         BigDecimal interest = balance.multiply(RATE).divide(NUMBER_OF_MONTHS_A_YEAR, RoundingMode.HALF_UP);
         deposit.increaseBalance(interest);
    }
}
