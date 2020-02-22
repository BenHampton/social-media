package com.clout.cloutservice.utils;

import com.clout.cloutservice.model.entities.RelationshipEntity;
import org.springframework.stereotype.Component;

@Component
public class RelationshipUtils {

    public RelationshipEntity createRelationshipRequest(RelationshipEntity relationship) {
        Long userOne = relationship.getUserOneId() < relationship.getUserTwoId() ? relationship.getUserOneId() : relationship.getUserTwoId();
        Long userTwo = relationship.getUserOneId() > relationship.getUserTwoId() ? relationship.getUserOneId() : relationship.getUserTwoId();

        return RelationshipEntity.builder()
                .userOneId(userOne)
                .userTwoId(userTwo)
                .statusId(relationship.getStatusId())
                .actionId(relationship.getActionId())
                .build();
    }
}
