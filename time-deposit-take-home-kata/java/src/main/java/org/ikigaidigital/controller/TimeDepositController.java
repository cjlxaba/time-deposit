package org.ikigaidigital.controller;

import org.ikigaidigital.dto.TimeDepositResponse;
import org.ikigaidigital.service.TimeDepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-deposit")
public class TimeDepositController {

    private final TimeDepositService timeDepositService;

    public TimeDepositController(TimeDepositService timeDepositService) {
        this.timeDepositService = timeDepositService;
    }

    //RESTful API endpoint to retrieve all time deposit
    @GetMapping("/retrieve")
    public List<TimeDepositResponse> getAllTimeDeposits() {
        return timeDepositService.getAllTimeDeposits();
    }

    //RESTful API endpoint to update the balances of all time deposits in the database
    @PostMapping ("/update")
    public ResponseEntity<Void> updateAllTimeDeposits() {
         timeDepositService.updateAllTimeDeposits();
         return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
