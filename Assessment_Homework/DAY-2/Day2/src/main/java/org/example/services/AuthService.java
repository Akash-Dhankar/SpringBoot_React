package org.example.services;

import org.example.models.RegisterDetails;
import org.example.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewStudent(RegisterDetails register)
    {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setStudentId(registerDetails.getStudentId());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(register.getGender());
        registerDetails.setStudentName(register.getStudentName());
        registerDetails.setDateOfBirth(register.getDateOfBirth());
        registerDetails.setRole(register.getRole());
        String enc = passwordEncoder.encode(register.getPassword());
        System.out.println("Password is: " + register.getPassword() + "\nEncrypted Password is: " + enc);
        registerDetails.setPassword(enc);
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
