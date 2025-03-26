package com.example.hrportal.service;

import com.example.hrportal.model.HR;
import com.example.hrportal.repository.HRRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HRService {
    private final HRRepository repository;

    public HRService(HRRepository repository) {
        this.repository = repository;
    }

    public boolean authenticateHR(String email, String password) {
        Optional<HR> hr = repository.findByEmail(email);
        return hr.isPresent() && hr.get().getPassword().equals(password);
    }
}