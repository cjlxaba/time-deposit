package org.ikigaidigital.domain;

public enum PlanType {

    BASIC("BASIC"),
    STUDENT("STUDENT"),
    PREMIUM("PREMIUM");

    private final String type;

    PlanType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static PlanType findByType(String type) {
        for (PlanType plan : values()) {
            if (plan.type.equalsIgnoreCase(type)) {
                return plan;
            }
        }
        throw new IllegalArgumentException("Unknown plan type: " + type);
    }
}
