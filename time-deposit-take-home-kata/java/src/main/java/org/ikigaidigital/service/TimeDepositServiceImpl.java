package org.ikigaidigital.service;

import org.ikigaidigital.entity.TimeDeposit;
import org.springframework.transaction.annotation.Transactional;
import org.ikigaidigital.TimeDepositCalculator;
import org.ikigaidigital.dto.TimeDepositResponse;
import org.ikigaidigital.mapper.DtoMapper;
import org.ikigaidigital.repo.TimeDepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeDepositServiceImpl implements TimeDepositService {

    private final TimeDepositRepository timeDepositRepository;

    private final TimeDepositCalculator timeDepositCalculator;

    public TimeDepositServiceImpl(TimeDepositRepository timeDepositRepository, TimeDepositCalculator timeDepositCalculator ) {
        this.timeDepositRepository = timeDepositRepository;
        this.timeDepositCalculator = timeDepositCalculator;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAllTimeDeposits() {

        // fetch all deposits from the h2 database
        List<TimeDeposit> entities = timeDepositRepository.findAll();

        List<org.ikigaidigital.TimeDeposit> timeDeposits = entities.stream()
                .map(DtoMapper::mapFromEntityDTO)
                .toList();
        timeDepositCalculator.updateBalance(timeDeposits);
        entities
                .forEach(timeDeposit -> timeDeposit.setBalance(getUpdatedBalance(timeDeposit.getId(),timeDeposits)));

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TimeDepositResponse> getAllTimeDeposits() {

        List<TimeDeposit> entities = (timeDepositRepository.findAll());
        return entities.stream()
                .map(DtoMapper::mapFromEntityToResponse)
                .toList();
    }

    // find the deposit with matching id extract the balance ensure we return double
    private Double getUpdatedBalance(int id, List<org.ikigaidigital.TimeDeposit> timeDeposits) {
        return timeDeposits.stream()
                .filter(td -> td.getId() == id)
                .map(org.ikigaidigital.TimeDeposit::getBalance)
                .findFirst().orElse(0.0);
    }
}
