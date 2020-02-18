package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.SignUp;
import com.clout.cloutservice.model.entities.UserEntity;
import com.clout.cloutservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody SignUp signUp) {
        return new ResponseEntity<>(userService.createUser(signUp), HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity<UserEntity> updateStatus(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.updateStatus(user),HttpStatus.OK);
    }

    @GetMapping("/user-responses")
    public ResponseEntity<List<UserEntity>> findUsers(@RequestParam String searchTerm) {
        return new ResponseEntity<>(userService.findUsernameBySearchTerm(searchTerm), HttpStatus.OK);
    }
}
