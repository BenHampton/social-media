package com.clout.cloutservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CloutServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloutServiceApplication.class, args);
    }

}
