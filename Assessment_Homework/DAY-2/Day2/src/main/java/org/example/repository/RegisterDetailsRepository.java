package org.example.repository;

import org.example.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails , Integer> {
    RegisterDetails findByEmail(String email);

    Optional<RegisterDetails> findByUserName(String username);
}
