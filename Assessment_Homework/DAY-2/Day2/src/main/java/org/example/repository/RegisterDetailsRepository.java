package org.example.repository;

import org.example.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails , Integer> {
    RegisterDetails findByEmail(String email);
}
