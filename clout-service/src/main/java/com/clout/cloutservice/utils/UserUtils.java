package com.clout.cloutservice.utils;

import com.clout.cloutservice.model.entities.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    public UserEntity clearPassword(UserEntity userEntity) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userEntity, user);
        user.setPassword("");

        return user;
    }
}
