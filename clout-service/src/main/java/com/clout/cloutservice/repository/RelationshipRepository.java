package com.clout.cloutservice.repository;

import com.clout.cloutservice.model.entities.RelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelationshipRepository extends JpaRepository<RelationshipEntity, Long> {

    //Optional<RelationshipEntity> findByActionId(Long actionId);

    Optional<RelationshipEntity> findByUserOneIdAndUserTwoId(Long userOneId, Long userTwoId);
}
