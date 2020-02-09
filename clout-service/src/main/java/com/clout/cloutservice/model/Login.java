package com.clout.cloutservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Login {

    private String password;

    private String username;

    private String email;
}
