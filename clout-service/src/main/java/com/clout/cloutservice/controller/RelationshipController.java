package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.entities.RelationshipEntity;
import com.clout.cloutservice.service.RelationshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {

    private RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping
    public ResponseEntity<RelationshipEntity> createRelationship(@RequestBody RelationshipEntity relationship) {
        return new ResponseEntity<>(relationshipService.createRelationship(relationship), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<RelationshipEntity> findRelationship(@PathVariable Long userId) {
        return new ResponseEntity<>(relationshipService.findRelationship(userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RelationshipEntity> updateRelationship(@RequestBody RelationshipEntity relationship) {
        return new ResponseEntity<>(relationshipService.updateRelationship(relationship), HttpStatus.OK);
    }
}
