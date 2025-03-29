package com.ust.bankLocker.controller;

import com.ust.bankLocker.datatypes.Login;
import com.ust.bankLocker.model.BankAccount;
import com.ust.bankLocker.model.User;
import com.ust.bankLocker.service.BankService;
import com.ust.bankLocker.service.LockerService;
import com.ust.bankLocker.service.UserCredentialService;
import com.ust.bankLocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
