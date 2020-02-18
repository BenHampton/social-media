package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user-friends")
@RestController
public class SearchController {

    @GetMapping("search/{searchCriteria}")
    public ResponseEntity<List<UserEntity>> retrieveAllFriends() {
        return null;
    }


}
