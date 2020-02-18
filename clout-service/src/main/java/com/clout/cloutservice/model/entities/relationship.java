package com.clout.cloutservice.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RELATIONSHIP")
public class relationship {

    @Id
    @Column(name = "USER_ONE_ID")
    private Long user_one_id;

    @Column(name = "USER_TWO_ID")
    private Long user_two_id;

    @Column(name = "STATUS_ID")
    private Long status_id;

    @Column(name = "ACTION_ID")
    private Long action_id;
}
