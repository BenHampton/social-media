package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.entities.CommentEntity;
import com.clout.cloutservice.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<List<CommentEntity>> getComments(@PathVariable( name = "postId" ) Long postId) {
        return new ResponseEntity<>(commentService.getComments(postId), HttpStatus.OK);
    }

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentEntity> createComment(@PathVariable( name = "postId") Long postId,
                                                       @RequestBody CommentEntity comment) {
        return new ResponseEntity<>(commentService.createComment(postId, comment), HttpStatus.OK);
    }

    @PutMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity<CommentEntity> updateComment(@PathVariable( name = "postId") Long postId,
                                                       @PathVariable( name = "commentId") Long commentId,
                                                       @RequestBody CommentEntity comment) {
        return new ResponseEntity<>(commentService.updateComment(postId, commentId, comment), HttpStatus.OK);
    }

//    @DeleteMapping("/instructors/{instructorId}/courses/{courseId}")
//    public ResponseEntity << ? > deleteCourse(@PathVariable(value = "instructorId") Long instructorId,
//                                              @PathVariable(value = "courseId") Long courseId) throws ResourceNotFoundException {
//        return courseRepository.findByIdAndInstructorId(courseId, instructorId).map(course - > {
//                courseRepository.delete(course);
//        return ResponseEntity.ok().build();
//        }).orElseThrow(() - > new ResourceNotFoundException(
//                "Course not found with id " + courseId + " and instructorId " + instructorId));
//    }
}
