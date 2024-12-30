package com.mosalab.gateserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TempConvController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/convert-temp")
    public ResponseEntity<?> convertTemp(@RequestBody Map<String, Object> request) {
        if (request == null || !request.containsKey("from") || !request.containsKey("to") || !request.containsKey("value")) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid Request");
            errorResponse.put("message", "The request must contain 'from', 'to', and 'value' fields.");
            errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        String serviceUrl = "http://TemperatureConvServer/hit";

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(serviceUrl, request, Map.class);

            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();

            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to process the request");
            errorResponse.put("message", e.getMessage());
            errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
