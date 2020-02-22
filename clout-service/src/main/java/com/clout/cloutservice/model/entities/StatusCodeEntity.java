package com.clout.cloutservice.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "STATUS_CODE")
public class StatusCodeEntity {

    @Id
    @Column(name = "CODE")
    private Long code;

    @Column(name = "ACTION")
    private String action;
}
