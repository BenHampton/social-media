package com.clout.cloutservice.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RELATIONSHIP")
public class RelationshipEntity {

    @Id
    @Column(name = "USER_ONE_ID")
    private Long userOneId;

    @Column(name = "USER_TWO_ID")
    private Long userTwoId;

    @Column(name = "STATUS_ID")
    private Long statusId;

    @Column(name = "ACTION_ID")
    private Long actionId;
}
