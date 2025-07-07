package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel
{
    private int studentId;
    private String studentName;
    private String studentCourse;
}
