package org.example.controllers;

import org.example.models.RegisterDetails;
import org.example.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterDetails register){
        authService.addNewStudent(register);
        return "Registered Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails login){
        authService.authenticate(login);
        return "Login Successful";
    }
}
