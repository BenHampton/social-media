package com.clout.cloutservice.service;

import com.clout.cloutservice.model.Login;
import com.clout.cloutservice.model.entities.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public UserEntity attemptLogin(String username, String email, String password) {

        UserEntity user = userService.retrieveUser(username, email);

        if (StringUtils.equals(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
