package com.example.demo.repository;

import com.example.demo.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails , Integer> {
    RegisterDetails findByEmail(String email);
}
