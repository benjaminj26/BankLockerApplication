package com.ust.bankLocker.controller;

import com.ust.bankLocker.datatypes.Login;
import com.ust.bankLocker.model.Users;
import com.ust.bankLocker.service.UserCredentialService;
import com.ust.bankLocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserCredentialController {
    private final UserCredentialService userCredentialService;

    private final UserService userService;

    @Autowired
    public UserCredentialController(
            UserCredentialService userCredentialService,
            UserService userService
    ) {
        this.userCredentialService = userCredentialService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Users> userLogin(@RequestBody Login login) {
        if (userCredentialService.isAuthorised(login)) {
            return ResponseEntity.ok().body(userService.getUser(login.getLoginId()));
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
