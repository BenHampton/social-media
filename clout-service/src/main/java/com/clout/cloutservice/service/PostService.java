package com.clout.cloutservice.service;

import com.clout.cloutservice.model.entities.PostEntity;
import com.clout.cloutservice.repository.PostEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class PostService {

    private PostEntityRepository postEntityRepository;

    public PostService(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    public PostEntity getPost(Long id) {
        return postEntityRepository.findById(id).orElseThrow( () -> new RuntimeException(("Error when getting post by Id: " + id)));
    }

    public PostEntity createPost(PostEntity post) {
        return postEntityRepository.save(post);
    }

    public PostEntity updatePost(Long id, PostEntity post) {
        PostEntity originalPost = postEntityRepository.findById(id).orElseThrow( () -> new RuntimeException("Error when getting post by Id: " + id));

        PostEntity newPost = PostEntity.builder()
                .id(originalPost.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();

        return postEntityRepository.save(newPost);
    }

    public Boolean existsById(Long id) {
        return postEntityRepository.existsById(id);
    }
}
