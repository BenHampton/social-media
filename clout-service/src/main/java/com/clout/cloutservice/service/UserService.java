package com.clout.cloutservice.service;

import com.clout.cloutservice.model.SignUp;
import com.clout.cloutservice.model.entities.UserEntity;
import com.clout.cloutservice.repository.UserEntityRepository;
import com.clout.cloutservice.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private UserEntityRepository userEntityRepository;

    private UserUtils userUtils;

    public UserService(UserEntityRepository userEntityRepository, UserUtils userUtils) {
        this.userEntityRepository = userEntityRepository;
        this.userUtils = userUtils;
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

    public UserEntity retrieveUser(String username, String email) {

        if (StringUtils.isNotBlank(email)) {
            return findUserByEmail(email);
        }
        return findUserByUsername(username);
    }

    public UserEntity updateStatus(UserEntity user) {

        UserEntity updatedUser = userEntityRepository.save(user);
        return findUserById(updatedUser.getId());
    }

    public List<UserEntity> findUsernameBySearchTerm(String searchTerm) {
        Optional<List<UserEntity>> userList = userEntityRepository.searchUsernames(searchTerm);
        return userList.orElseThrow(() -> new RuntimeException("No Users Found"));
    }

    public UserEntity findUser(Long id) {
        return userUtils.clearPassword(findUserById(id));
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
