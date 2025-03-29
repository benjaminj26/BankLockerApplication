package com.ust.bankLocker.controller;

import com.ust.bankLocker.datatypes.CreateUser;
import com.ust.bankLocker.model.User;
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
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();

        if (userList != null) {
            return ResponseEntity.ok().body(userList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find")
    public ResponseEntity<User> userLogin(@RequestParam String loginId) {
        User user = userService.getUser(loginId);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/create")
    public  ResponseEntity<User> createUser(@RequestBody CreateUser user) {
        return ResponseEntity.status(201).body(userService.createUser(user));
    }
}
