package com.clout.cloutservice.model.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Builder
@Data
@EqualsAndHashCode(exclude = "relationships")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_PROFILE")
public class UserEntity extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS")
    private String status;
}
