package com.clout.cloutservice.repository;

import com.clout.cloutservice.model.entities.CommentEntity;
import com.clout.cloutservice.model.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByPostId(Long id);


    //Optional<CommentEntity> findByIdAndPostId(Long id, PostEntity postId);

}
