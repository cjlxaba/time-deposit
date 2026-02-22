package org.ikigaidigital.domain;

import org.ikigaidigital.TimeDeposit;

import java.math.BigDecimal;

public interface InterestPolicy {
     int GRACE_PERIOD_DAYS = 30;
     BigDecimal NUMBER_OF_MONTHS_A_YEAR = new BigDecimal("12");
    void apply(TimeDeposit deposit);
}
