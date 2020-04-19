package com.clout.cloutservice.service;

import com.clout.cloutservice.model.entities.RelationshipEntity;
import com.clout.cloutservice.repository.RelationshipRepository;
import com.clout.cloutservice.utils.RelationshipUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RelationshipService {

    private final Long DECLINED = 2L;

    private RelationshipRepository relationshipRepository;

    private RelationshipUtils relationshipUtils;

    public RelationshipService(RelationshipRepository relationshipRepository, RelationshipUtils relationshipUtils) {
        this.relationshipRepository = relationshipRepository;
        this.relationshipUtils = relationshipUtils;
    }

    public RelationshipEntity createRelationship(RelationshipEntity relationship) {

        try {

            return relationshipRepository.save(relationshipUtils.createRelationshipRequest(relationship));

        } catch (Exception e) {

            new RuntimeException("Error while create relationship  with relationship: " + relationship + " message: " + e.getMessage());
        }
        return null;
    }

//    public RelationshipEntity findRelationship(Long userId) {
//
//        Optional<RelationshipEntity> relationship = relationshipRepository.findByActionId(userId);
//
//        return relationship.orElseThrow(() -> new RuntimeException("No Relationship found with userId: " + userId));
//    }

    public RelationshipEntity findRelationship(Long userId, Long friendId) {

        Long userOne;
        Long userTwo;

        if (userId < friendId) {
            userOne = userId;
            userTwo = friendId;
        } else {
            userOne = friendId;
            userTwo = userId;
        }

        Optional<RelationshipEntity> userRelationship = relationshipRepository.findByUserOneIdAndUserTwoId(userOne, userTwo);

        //TODO Logic may need to be updated if logic does not filter out BLOCKED where status equals 3
        return userRelationship.filter( relationship -> relationship.getStatusId() != 3)
                .orElseGet( () -> RelationshipEntity.builder().statusId(DECLINED).build());

    }

    public RelationshipEntity updateRelationship(RelationshipEntity relationship) {
        try {

            return relationshipRepository.save(relationshipUtils.createRelationshipRequest(relationship));

        } catch (Exception error) {

            new RuntimeException("Error while updating relationship: " + relationship + ", error: " + error.getMessage());
        }
        return null;
    }

}
