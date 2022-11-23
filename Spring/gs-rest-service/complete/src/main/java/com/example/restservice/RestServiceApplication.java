package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * http://localhost:8080/swagger-ui/index.html
 * http://localhost:8080/v3/api-docs
 * 
 * http://localhost:8080/greeting?name=Markel&lang=es
 */

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
