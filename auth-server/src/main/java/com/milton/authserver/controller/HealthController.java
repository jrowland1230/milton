package com.milton.authserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/v1/ping")
    public ResponseEntity<Object> ping() {
        return ResponseEntity.status(HttpStatus.OK).body("Ping OK");
    }

    @GetMapping("/actuator/health")
    public ResponseEntity<Object> health() {
        return ResponseEntity.status(HttpStatus.OK).body("Health Ok");
    }
}
