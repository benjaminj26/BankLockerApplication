package com.ust.bankLocker.controller;

import com.ust.bankLocker.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locker/")
public class LockerController {
    private final LockerService lockerService;

    @Autowired
    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }
}
