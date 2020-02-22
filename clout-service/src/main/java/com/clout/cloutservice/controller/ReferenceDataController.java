package com.clout.cloutservice.controller;

import com.clout.cloutservice.model.entities.StatusCodeEntity;
import com.clout.cloutservice.service.ReferenceDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reference-data")
public class ReferenceDataController {

    private ReferenceDataService referenceDataService;

    public ReferenceDataController(ReferenceDataService referenceDataService) {
        this.referenceDataService = referenceDataService;
    }

    @GetMapping("/status-codes")
    public ResponseEntity<List<StatusCodeEntity>> retrieveStatusCodes() {
        return new ResponseEntity<>(referenceDataService.retrieveStatusCodes(), HttpStatus.OK);
    }
}
