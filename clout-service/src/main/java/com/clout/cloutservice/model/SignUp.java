package com.clout.cloutservice.model;

import com.clout.cloutservice.model.entities.AuditFields;
import com.clout.cloutservice.model.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SignUp extends AuditFields {

    private String passwordConfirmation;

    private UserEntity userEntity;
}
