package org.ikigaidigital.factory;

import org.ikigaidigital.domain.*;

public class InterestPolicyFactory {

    public static InterestPolicy resolvePolicy(String planType) {

        return switch (planType) {
            case "BASIC" -> new BasicInterestPolicy();
            case "PREMIUM" -> new PremiumInterestPolicy();
            case "STUDENT" -> new StudentInterestPolicy();
            default -> throw new IllegalArgumentException("Unknown policy type: " + planType);
        };
    }
}
