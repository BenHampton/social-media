package com.clout.cloutservice.service;

import com.clout.cloutservice.model.entities.CommentEntity;
import com.clout.cloutservice.model.entities.PostEntity;
import com.clout.cloutservice.repository.CommentEntityRepository;
import com.clout.cloutservice.repository.PostEntityRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
public class CommentService {

    private CommentEntityRepository commentEntityRepository;
    private PostEntityRepository postEntityRepository;

    private PostService postService;

    public CommentService(CommentEntityRepository commentEntityRepository, PostEntityRepository postEntityRepository, PostService postService) {
        this.commentEntityRepository = commentEntityRepository;
        this.postEntityRepository = postEntityRepository;
        this.postService = postService;
    }

    public List<CommentEntity> getComments(Long postId) {

        List<CommentEntity> list = commentEntityRepository.findByPostId(postId);

        return list;
    }

    public CommentEntity createComment(Long postId, CommentEntity comment) {

        PostEntity post = postService.getPost(postId);

        CommentEntity newComment = CommentEntity.builder()
                .text(comment.getText())
                .post(post)
                .build();

        return commentEntityRepository.save(newComment);
    }

    public CommentEntity updateComment(Long postId, Long commentId, CommentEntity newComment) {

        if (!postService.existsById(postId)) {
            throw new ResourceNotFoundException("Error post Id: " + postId + " not found");
        }
        return commentEntityRepository.findById(commentId).map( comment -> {
            comment.builder()
                    .text(newComment.getText())
                    .build();
            return commentEntityRepository.save(comment);
        }).orElseThrow( () -> new RuntimeException("Error saving comment with Id: " + commentId));
    }

}
