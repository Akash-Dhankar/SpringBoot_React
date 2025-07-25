package com.example.demo.repository;

import com.example.demo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByEmployeeEmpId(int empId);
}
