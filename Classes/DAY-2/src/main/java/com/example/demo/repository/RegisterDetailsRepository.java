package com.example.demo.repository;

import com.example.demo.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails , Integer> {
    RegisterDetails findByEmail(String email);

    Optional<RegisterDetails> findByUserName(String userName);

    List<RegisterDetails> findByRolesRoleName(String roleName);


}
