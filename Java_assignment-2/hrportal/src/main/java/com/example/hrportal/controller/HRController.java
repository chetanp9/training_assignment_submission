package com.example.hrportal.controller;

import com.example.hrportal.service.HRService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/hr")
@CrossOrigin(origins = "*")
public class HRController {
    private final HRService service;
    private final Map<String, String> activeSessions = new HashMap<>();

    public HRController(HRService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        boolean isAuthenticated = service.authenticateHR(email, password);

        Map<String, String> response = new HashMap<>();
        if (isAuthenticated) {

            activeSessions.values().remove(email);
            String token = UUID.randomUUID().toString();
            activeSessions.put(token, email);
            System.out.println("Active Sessions: " + activeSessions);

            response.put("status", "success");
            response.put("token", token);
        } else {
            response.put("status", "fail");
        }
        return response;
    }

    @PostMapping("/logout")
    public Map<String, String> logout(@RequestHeader("Authorization") String token) {
        Map<String, String> response = new HashMap<>();
        if (activeSessions.containsKey(token)) {
            activeSessions.remove(token);
            response.put("status", "success");
            response.put("message", "Logged out successfully.");
        } else {
            response.put("status", "fail");
            response.put("message", "Invalid session token.");
        }
        return response;
    }

    public boolean isAuthenticated(String token) {
        System.out.println("Checking Token: " + token);
        System.out.println("Active Sessions: " + activeSessions);
        return activeSessions.containsKey(token);
    }
}
