package org.ikigaidigital.service;

import org.ikigaidigital.dto.TimeDepositResponse;


import java.util.List;

public interface TimeDepositService {

    void updateAllTimeDeposits();
    List <TimeDepositResponse> getAllTimeDeposits();
}
