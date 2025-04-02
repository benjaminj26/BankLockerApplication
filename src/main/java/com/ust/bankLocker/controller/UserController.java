package com.ust.bankLocker.controller;

import com.ust.bankLocker.datatypes.CreateUser;
import com.ust.bankLocker.model.Users;
import com.ust.bankLocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = userService.getAllUsers();

        if (usersList != null) {
            return ResponseEntity.ok().body(usersList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find")
    public ResponseEntity<Users> userLogin(@RequestParam String loginId) {
        Users users = userService.getUser(loginId);

        if (users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/create")
    public  ResponseEntity<Users> createUser(@RequestBody CreateUser user) {
        return ResponseEntity.status(201).body(userService.createUser(user));
    }
}
