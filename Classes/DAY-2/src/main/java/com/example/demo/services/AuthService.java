package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public String addNewEmployee(RegisterDetails register)
    {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(register.getGender());
        String enc = passwordEncoder.encode(register.getPassword());
        System.out.println("Password is: " + register.getPassword() + "\nEncrypted Password is: " + enc);
        registerDetails.setPassword(enc);
        registerDetails.setEmpName(register.getEmpName());
        registerDetails.setRole(register.getRole());
        registerDetailsRepository.save(registerDetails);
        return "Employee Added Successfully";
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
