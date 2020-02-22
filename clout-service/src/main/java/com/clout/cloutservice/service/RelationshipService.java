package com.clout.cloutservice.service;

import com.clout.cloutservice.model.Relationship;
import com.clout.cloutservice.model.entities.RelationshipEntity;
import com.clout.cloutservice.repository.RelationshipRepository;
import com.clout.cloutservice.utils.RelationshipUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RelationshipService {

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

    public RelationshipEntity findRelationship(Long userId) {

        Optional<RelationshipEntity> relationship = relationshipRepository.findByActionId(userId);

        return relationship.orElseThrow(() -> new RuntimeException("No Relationship found with userId: " + userId));
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
