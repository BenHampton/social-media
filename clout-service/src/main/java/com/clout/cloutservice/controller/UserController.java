package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.SignUp;
import com.clout.cloutservice.model.entities.UserEntity;
import com.clout.cloutservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/sign-up")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody SignUp signUp) {
        return new ResponseEntity<>(userService.createUser(signUp), HttpStatus.OK);
    }
}
