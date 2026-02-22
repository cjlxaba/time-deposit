package org.ikigaidigital.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TimeDepositResponse {
    private int id;
    private String planType;
    private Double balance;
    private int days;
    private List<WithdrawalResponse> withdrawals;
}
