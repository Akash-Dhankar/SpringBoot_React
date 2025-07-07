package com.example.demo.models;

//instead of creating getters and setters and constructors for everything , just use @Data of lombok and @AllArgsConstructor

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    private int empId;
    private String empName;
    private String empJob;
}


