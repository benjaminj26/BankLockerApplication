package com.ust.bankLocker.service;

import com.ust.bankLocker.model.BankAccount;
import com.ust.bankLocker.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {
    private BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public BankAccount getBankDetails(String accountNumber) {
        Optional<BankAccount> temp = bankRepository.findByAccountNumber(accountNumber);

        return temp.orElse(null);
    }

}
