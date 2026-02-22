package org.ikigaidigital;

import org.ikigaidigital.domain.InterestPolicy;
import org.ikigaidigital.factory.InterestPolicyFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeDepositCalculator {
    public void updateBalance(List<TimeDeposit> timeDeposits) {
        for (TimeDeposit timeDeposit : timeDeposits) {
            InterestPolicy interestPolicy = InterestPolicyFactory.resolvePolicy(String.valueOf(timeDeposit.getPlanType()).toUpperCase());
            timeDeposit.applyInterest(interestPolicy);
        }
    }
}
