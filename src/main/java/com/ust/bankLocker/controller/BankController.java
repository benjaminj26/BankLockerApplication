package com.ust.bankLocker.controller;

import com.ust.bankLocker.model.BankAccount;
import com.ust.bankLocker.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankAccount/")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public ResponseEntity<BankAccount> getBankDetails(@RequestParam String accountNumber) {
        return ResponseEntity.ok().body(bankService.getBankDetails(accountNumber));
    }
}
