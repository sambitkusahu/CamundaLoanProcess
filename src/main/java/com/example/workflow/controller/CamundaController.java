package com.example.workflow.controller;

import com.example.workflow.model.Address;
import com.example.workflow.model.EmploymentDetails;
import com.example.workflow.model.LoanProcessResponse;
import com.example.workflow.service.StartLoanProcess;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CamundaController {

    @Autowired
    StartLoanProcess startLoanProcess;

    @PostMapping("/startLoanProcessByMsg")
    public ResponseEntity<LoanProcessResponse> startProcess(@RequestBody EmploymentDetails employmentDetails) throws JsonProcessingException {
        LoanProcessResponse loanProcessResponse = startLoanProcess.startProcessByMessage(employmentDetails);
        return new ResponseEntity<>(loanProcessResponse,HttpStatus.CREATED);
    }

    @PostMapping("/startLoanProcessByKey")
    public ResponseEntity<LoanProcessResponse> startProcessByKey(@RequestBody EmploymentDetails employmentDetails) throws JsonProcessingException {
        LoanProcessResponse loanProcessResponse = startLoanProcess.startProcessInstanceByKey(employmentDetails);
        return new ResponseEntity<>(loanProcessResponse,HttpStatus.CREATED);
    }
}
