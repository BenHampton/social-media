package com.clout.cloutservice.repository;

import com.clout.cloutservice.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsUserEntitiesByUsername(String username);

    Boolean existsUserEntitiesByEmail(String email);

    Optional<UserEntity> findUserEntitiesByUsername(String username);

    Optional<UserEntity> findUserEntitiesByEmail(String email);

}
