package org.ikigaidigital.mapper;

import org.ikigaidigital.dto.TimeDepositResponse;
import org.ikigaidigital.dto.WithdrawalResponse;
import org.ikigaidigital.entity.Withdrawal;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

    public static TimeDepositResponse mapFromEntityToResponse (org.ikigaidigital.entity.TimeDeposit timeDeposit) {

        return TimeDepositResponse.builder()
                .planType(timeDeposit.getPlanType())
                .days(timeDeposit.getDays())
                .balance(timeDeposit.getBalance())
                .id(timeDeposit.getId())
                .withdrawals(mapWithdrawals(timeDeposit.getWithdrawals()))
                .build();
    }

    private static WithdrawalResponse mapFromDtoToEntity (Withdrawal withdrawal) {

        return WithdrawalResponse.builder()
                .date(withdrawal.getDate())
                .amount(withdrawal.getAmount())
                .id(withdrawal.getId())
                .build();
    }
    private static List<WithdrawalResponse> mapWithdrawals(List<Withdrawal> withdrawals) {

        return withdrawals.stream()
                .map(DtoMapper::mapFromDtoToEntity)
                .collect(Collectors.toList());
    }

    public static org.ikigaidigital.TimeDeposit mapFromEntityDTO(org.ikigaidigital.entity.TimeDeposit timeDeposit) {

        return org.ikigaidigital.TimeDeposit.builder()
                .planType(timeDeposit.getPlanType())
                .days(timeDeposit.getDays())
                .id(timeDeposit.getId())
                .balance(timeDeposit.getBalance())
                .build();

    }
}
