package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_details")
public class RegisterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "student_name" , nullable = false)
    private String studentName;
    private String email;
    private String password;
    private String gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String role;
}
