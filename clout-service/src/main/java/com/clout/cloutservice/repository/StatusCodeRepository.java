package com.clout.cloutservice.repository;

import com.clout.cloutservice.model.entities.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusCodeRepository extends JpaRepository<StatusCode, Long> {
}
