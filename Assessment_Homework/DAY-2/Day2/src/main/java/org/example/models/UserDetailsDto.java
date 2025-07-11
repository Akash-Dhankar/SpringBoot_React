package org.example.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private int studentId;
    private String name;
    private String email;
    private String password;
    private String userName;
    private Set<String> roleNames;
}
//DTO IS USED TO TRANSFER DATA BETWEEN 2 COLUMNS