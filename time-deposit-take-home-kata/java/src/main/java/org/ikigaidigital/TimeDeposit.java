package org.ikigaidigital;

import lombok.Builder;
import lombok.Data;
import org.ikigaidigital.domain.InterestPolicy;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder
@Data
public class TimeDeposit {
    private int id;
    private String planType;
    private Double balance;
    private int days;

    public TimeDeposit(int id, String planType, Double balance, int days) {
        this.id = id;
        this.planType = planType;
        this.balance = balance;
        this.days = days;
    }

    public void applyInterest(InterestPolicy policy) {
        policy.apply(this);
    }
    public void increaseBalance(BigDecimal amount) {
        amount = amount.setScale(2, RoundingMode.HALF_UP);
        this.balance = this.balance + amount.doubleValue();
    }
}
