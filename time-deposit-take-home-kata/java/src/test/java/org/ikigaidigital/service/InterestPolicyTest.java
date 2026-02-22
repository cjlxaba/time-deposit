package org.ikigaidigital.service;

import org.ikigaidigital.domain.BasicInterestPolicy;
import org.ikigaidigital.domain.InterestPolicy;
import org.ikigaidigital.TimeDeposit;
import org.ikigaidigital.domain.PremiumInterestPolicy;
import org.ikigaidigital.domain.StudentInterestPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InterestPolicyTest {

        private TimeDeposit timeDeposit ;

        @BeforeEach
        void setUp() {
            timeDeposit = new TimeDeposit(1,"student",4577.23, 48);
            timeDeposit.setBalance(1000.00); // initial balance
        }

        // ---------------- Basic Plan ----------------
        @Test
        public void basicInterest_notAppliedDuringGracePeriod() {
            timeDeposit.setDays(15); // less than 30
            InterestPolicy policy = new BasicInterestPolicy();

            policy.apply(timeDeposit);

            assertThat(timeDeposit.getBalance()).isEqualTo(1000.00);
        }

        @Test
        public void basicInterest_appliedAfterGracePeriod() {
            timeDeposit.setDays(60); // after 30 days
            InterestPolicy policy = new BasicInterestPolicy();

            policy.apply(timeDeposit);

            BigDecimal expected = BigDecimal.valueOf(1000.00)
                    .multiply(BigDecimal.valueOf(0.01))
                    .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);

            BigDecimal finalBalance = BigDecimal.valueOf(1000.00).add(expected);
            assertThat(timeDeposit.getBalance()).isEqualTo(finalBalance.doubleValue());
        }

        // ---------------- Premium Plan ----------------
        @Test
        public void premiumInterest_notAppliedBeforePremiumStart() {
            timeDeposit.setDays(30); // less than 45
            InterestPolicy policy = new PremiumInterestPolicy();

            policy.apply(timeDeposit);

            assertThat(timeDeposit.getBalance()).isEqualTo(1000.00);
        }

        @Test
        public void premiumInterest_appliedAfterPremiumStart() {
            timeDeposit.setDays(60); // after 45
            InterestPolicy policy = new PremiumInterestPolicy();

            policy.apply(timeDeposit);

            BigDecimal expected = BigDecimal.valueOf(1000.00)
                    .multiply(BigDecimal.valueOf(0.05))
                    .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);

            BigDecimal finalBalance = BigDecimal.valueOf(1000.00).add(expected);
            assertThat(timeDeposit.getBalance()).isEqualTo(finalBalance.doubleValue());
        }

        // ---------------- Student Plan ----------------
        @Test
        public void studentInterest_notAppliedDuringGracePeriod() {
            timeDeposit.setDays(20); // less than 30
            InterestPolicy policy = new StudentInterestPolicy();

            policy.apply(timeDeposit);

            assertThat(timeDeposit.getBalance()).isEqualTo(1000.00);
        }

        @Test
        public void studentInterest_notAppliedAfterMaxDays() {
            timeDeposit.setDays(400); // more than 366
            InterestPolicy policy = new StudentInterestPolicy();

            policy.apply(timeDeposit);

            assertThat(timeDeposit.getBalance()).isEqualTo(1000.00);
        }

        @Test
        public void studentInterest_appliedWithinValidDays() {
            timeDeposit.setDays(200); // between 30 and 366
            InterestPolicy policy = new StudentInterestPolicy();

            policy.apply(timeDeposit);

            BigDecimal expected = BigDecimal.valueOf(1000.00)
                    .multiply(BigDecimal.valueOf(0.03))
                    .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);

            BigDecimal finalBalance = BigDecimal.valueOf(1000.00).add(expected);
            assertThat(timeDeposit.getBalance()).isEqualTo(finalBalance.doubleValue());
        }

}
