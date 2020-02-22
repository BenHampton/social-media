package com.clout.cloutservice.model;

import com.clout.cloutservice.model.entities.RelationshipEntity;
import com.clout.cloutservice.model.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relationship {

    private List<UserEntity> blockedUsers;
}
