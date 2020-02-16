package com.clout.cloutservice.service;

import com.clout.cloutservice.model.Login;
import com.clout.cloutservice.model.SignUp;
import com.clout.cloutservice.model.entities.UserEntity;
import com.clout.cloutservice.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public UserEntity createUser(SignUp signUp) {
        if (StringUtils.isNotBlank(signUp.getUserEntity().getPassword()) &&
                StringUtils.isNotBlank(signUp.getUserEntity().getEmail()) &&
                StringUtils.isNotBlank(signUp.getUserEntity().getUsername()) &&
                StringUtils.equals(signUp.getPasswordConfirmation(), signUp.getUserEntity().getPassword())) {
            return userEntityRepository.save(signUp.getUserEntity());
        }

        throw new RuntimeException("Passwords do not match");
    }

    public UserEntity retrieveUser(Login login) {

        if (StringUtils.isNotBlank(login.getEmail())) {
            return findUserByEmail(login.getEmail());
        }
        return findUserByUsername(login.getUsername());
    }

    public UserEntity updateStatus(UserEntity user) {

        UserEntity updatedUser = userEntityRepository.save(user);
        return findUserById(updatedUser.getId());
    }

    private UserEntity findUserById(Long id) {
        Optional<UserEntity> user = userEntityRepository.findUserEntitiesById(id);
        return user.orElseThrow((() -> new RuntimeException("No username found")));
    }

    private UserEntity findUserByUsername(String username) {
        Optional<UserEntity> user = userEntityRepository.findUserEntitiesByUsername(username);
        return user.orElseThrow((() -> new RuntimeException("No username found")));
    }

    private UserEntity findUserByEmail(String email) {
        Optional<UserEntity> user = userEntityRepository.findUserEntitiesByEmail(email);
        return user.orElseThrow((() -> new RuntimeException("No username found")));
    }


}
