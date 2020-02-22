package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.entities.PostEntity;
import com.clout.cloutservice.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> getPost(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostEntity post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> updatePost(@PathVariable(value = "id") Long id, @RequestBody PostEntity post) {
        return new ResponseEntity<>(postService.updatePost(id, post), HttpStatus.OK);
    }

//    @DeleteMapping("/instructors/{id}")
//    public Map < String, Boolean > deleteUser(
//            @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
//        Instructor instructor = instructorRepository.findById(instructorId)
//                .orElseThrow(() - > new ResourceNotFoundException("Instructor not found :: " + instructorId));
//
//        instructorRepository.delete(instructor);
//        Map < String, Boolean > response = new HashMap < > ();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}
