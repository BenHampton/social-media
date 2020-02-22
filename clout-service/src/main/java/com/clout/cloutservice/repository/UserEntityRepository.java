package com.clout.cloutservice.repository;

import com.clout.cloutservice.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> , JpaSpecificationExecutor<UserEntity> {

    Boolean existsUserEntitiesByUsername(String username);

    Boolean existsUserEntitiesByEmail(String email);

    Optional<UserEntity> findUserEntitiesByUsername(String username);

    Optional<UserEntity> findUserEntitiesByEmail(String email);

    Optional<UserEntity> findUserEntitiesById(Long id);

    // TODO: "ILIKE" for PostgreSQL invokes case insensitivity
    @Query(value = "SELECT * FROM USER_profile WHERE username ILIKE :searchTerm%", nativeQuery = true)
    Optional<List<UserEntity>> searchUsernames(String searchTerm);

}
