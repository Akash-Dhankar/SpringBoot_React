//package org.example.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.sql.Date;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="user_details")
//public class RegisterDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int studentId;
//
//    @Column(name = "student_name" , nullable = false)
//    private String studentName;
//    private String email;
//    private String password;
//    private String gender;
//
//    @Column(name = "date_of_birth")
//    private Date dateOfBirth;
//
//    private String role;
//}


//-----------------------------------BRINGING IN JWT AND OTHER AUTHENTICATION STUFF ------------------------------------------

package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_details")
public class RegisterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "user_name" , nullable = false , unique = true)
    private String userName;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles" , joinColumns =
    @JoinColumn(name = "user_id" , referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "roleId")
    )
    private Set<Roles> roles;
}
