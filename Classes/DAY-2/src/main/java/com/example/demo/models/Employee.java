package com.example.demo.models;

//instead of creating getters and setters and constructors for everything , just use @Data of lombok and @AllArgsConstructor

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Employee {
    private int empId;
    private String empName;
    private String empJob;
}


