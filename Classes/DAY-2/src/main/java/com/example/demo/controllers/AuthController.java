package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterDetails register){
        authService.addNewEmployee(register);
        return "Registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails login){
        authService.authenticate(login);
        return "Login Successful";
    }
}
