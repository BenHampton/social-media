package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.Login;
import com.clout.cloutservice.model.entities.UserEntity;
import com.clout.cloutservice.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> login(@RequestBody Login login) {
        return new ResponseEntity<>(loginService.attemptLogin(login), HttpStatus.OK);
    }

}
