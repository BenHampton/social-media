package com.clout.cloutservice.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude="comments")
@Table(name = "POST")
@Entity
public class PostEntity extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID")
    private Long id;

    @Size(max = 50)
    @Column( name = "TITLE")
    private String title;

    @Size(max = 250)
    @Column( name = "CONTENT")
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CommentEntity> comments;
}
