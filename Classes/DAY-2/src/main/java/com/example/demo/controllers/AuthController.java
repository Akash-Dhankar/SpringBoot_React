package com.example.demo.controllers;

import com.example.demo.models.AuthResponse;
import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/auth")
//-----------------------------------------DAY 6----------------------------------------

//public class AuthController {
//    @Autowired
//    AuthService authService;
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody RegisterDetails register){
//        authService.addNewEmployee(register);
//        return "Registered successfully";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody RegisterDetails login){
//        authService.authenticate(login);
//        return "Login Successful";
//    }
//}

//-------------------------------------------DAY 7 --------------------------------------------

//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    AuthService authService;
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody UserDetailsDto register){
//        return authService.addNewEmployee(register);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody RegisterDetails login){
//        return authService.authenticate(login);
//    }

//-------------------------------------------DAY 8 JWT-------------------------------------------

//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    AuthService authService;
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody UserDetailsDto register){
//        return authService.addNewEmployee(register);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody RegisterDetails login){
//        return authService.authenticate(login);
//    }

//--------------------------------------------DAY 9 - WITH REACT-------------------------------------

//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    AuthService authService;
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody UserDetailsDto register){
//        return authService.addNewEmployee(register);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody RegisterDetails login){
//        return authService.authenticate(login);
//    }

//-----------------------------------------DAY 11 TASK2 TOKEN , USERNAME , ROLE---------------------------------

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register){
        return authService.addNewEmployee(register);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody RegisterDetails login){
        return authService.authenticate(login);
    }
}
