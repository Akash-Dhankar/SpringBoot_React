package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentModel
{
    @Id
    @GeneratedValue
    private int studentId;
    private String studentName;
    private String studentCourse;
}
