package com.clout.cloutservice.service;

import com.clout.cloutservice.model.entities.StatusCode;
import com.clout.cloutservice.repository.StatusCodeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReferenceDataService {

    StatusCodeRepository statusCodeRepository;

    public ReferenceDataService(StatusCodeRepository statusCodeRepository) {
        this.statusCodeRepository = statusCodeRepository;
    }

    public List<StatusCode> retrieveStatusCodes() {
        return statusCodeRepository.findAll();
    }

}
