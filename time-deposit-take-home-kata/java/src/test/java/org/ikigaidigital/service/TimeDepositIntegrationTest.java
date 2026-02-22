package org.ikigaidigital.service;

import org.ikigaidigital.dto.TimeDepositResponse;
import org.ikigaidigital.entity.TimeDeposit;
import org.ikigaidigital.repo.TimeDepositRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TimeDepositIntegrationTest {

    @Autowired
    private TimeDepositRepository timeDepositRepository;

    @Autowired
    private TimeDepositServiceImpl timeDepositService;

    @BeforeEach
    void setUp() {
        timeDepositRepository.deleteAll(); // clean database
    }

    @Test
    void updateAllTimeDeposits() {

        TimeDeposit timeDeposit = getTimeDeposit();

        timeDepositRepository.save(timeDeposit);
        timeDepositService.updateAllTimeDeposits();
        List<TimeDeposit> entities = timeDepositRepository.findAll();
        assertThat(entities).isNotEmpty();
        assertThat(entities.get(0).getBalance()).isGreaterThan(45435.6);
    }

    private static @NotNull TimeDeposit getTimeDeposit() {
        TimeDeposit timeDeposit = new TimeDeposit();
        timeDeposit.setBalance(45435.6);
        timeDeposit.setDays(45);
        timeDeposit.setPlanType("Student");
        return timeDeposit;
    }

    @Test
    void retrieveAllTimeDeposits() {
        TimeDeposit timeDeposit = getTimeDeposit ();
        timeDepositRepository.save(timeDeposit);
        List<TimeDepositResponse> results = timeDepositService.getAllTimeDeposits();
        assertThat(results).isNotEmpty();
        assertThat(results.get(0).getWithdrawals()).isNotEmpty();
    }
}