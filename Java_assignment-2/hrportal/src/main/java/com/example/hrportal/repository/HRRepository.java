package com.example.hrportal.repository;

import com.example.hrportal.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HRRepository extends JpaRepository<HR, Long> {
    Optional<HR> findByEmail(String email);
}