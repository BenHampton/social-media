package com.clout.cloutservice.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "COMMENT")
@Entity
public class CommentEntity extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID")
    private Long id;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "POST_ID")
    @JsonBackReference
    @ToString.Exclude
    private PostEntity post;
}
