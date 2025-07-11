//package org.example.services;
//
//import org.example.models.RegisterDetails;
//import org.example.repository.RegisterDetailsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//    @Autowired
//    RegisterDetailsRepository registerDetailsRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    public String addNewStudent(RegisterDetails register)
//    {
//        RegisterDetails registerDetails = new RegisterDetails();
//        registerDetails.setStudentId(registerDetails.getStudentId());
//        registerDetails.setEmail(register.getEmail());
//        registerDetails.setGender(register.getGender());
//        registerDetails.setStudentName(register.getStudentName());
//        registerDetails.setDateOfBirth(register.getDateOfBirth());
//        registerDetails.setRole(register.getRole());
//        String enc = passwordEncoder.encode(register.getPassword());
//        System.out.println("Password is: " + register.getPassword() + "\nEncrypted Password is: " + enc);
//        registerDetails.setPassword(enc);
//        registerDetailsRepository.save(registerDetails);
//        return "Student Added Successfully";
//    }
//
//    public String authenticate(RegisterDetails login)
//    {
//        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
//        if(user!=null)
//        {
//            if(passwordEncoder.matches(login.getPassword(),user.getPassword()))
//            {
//               return "Login Successful";
//            }
//        }
//        return "Login Not Successful";
//    }
//}

//------------------------------------------BRINGING IN JWT-----------------------------------------------------

package org.example.services;

import org.example.jwt.JwtTokenProvider;
import org.example.models.RegisterDetails;
import org.example.models.Roles;
import org.example.repository.RegisterDetailsRepository;
import org.example.repository.RegisterRepository;
import org.example.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public String addNewStudent(RegisterDetails register)
    {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setStudentId(registerDetails.getStudentId());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles = new HashSet<>();
//        for(String roleName: register.getRoleNames()){
//            Roles role = rolesRepository.findByRoleName(roleName)
//                    .orElseThrow(()->new RuntimeException("User not found" + roleName));
//            roles.add(role);
//        }
        registerDetails.setRoles(roles);
        System.out.println("Registration"+ registerDetails);
        registerDetailsRepository.save(registerDetails);
        return "Student Added Successfully";
    }

    public String authenticate(RegisterDetails login)
    {
        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
        if(user!=null)
        {
            if(passwordEncoder.matches(login.getPassword(),user.getPassword()))
            {
                return "Login Successful";
            }
        }
        return "Login Not Successful";
    }
}

//doubts in lines 93-97