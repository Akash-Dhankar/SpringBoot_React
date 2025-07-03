package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//--------------------------------USING CONTROLLER--------------------------------------------

//@Controller
//@ResponseBody

// @RestController //has both controller and responsebody - so u can omit the above 2 annotations
//public class HelloWorldController {
//    @GetMapping("/")
//    public String hello(){
//        System.out.println("Hello World");
//        return "Hello and welcome to Day 2";
//    }
//}


//----------------------------------------USING SERVICE-----------------------------------------

@RestController
public class HelloWorldController
{
    @Autowired
    HelloWorldService hws;

    @GetMapping("/hello")
    public String hello()
    {
        System.out.println("Default Statement");
        return hws.helloWorld();
    }

    //-------DEPENDENCY INJECTION-------
    @PostMapping("/")
    public String postMethod()
    {
        return hws.postMethod();
    }

    @PutMapping("/")
    public String putMethod()
    {
        return hws.putMethod();
    }

    @DeleteMapping("/")
    public String deleteMethod()
    {
        return hws.deleteMethod();
    }



    @GetMapping("/employee")
    public List<Employee> getEmpMethod()
    {
        return hws.getEmpMethod();
    }

    @PostMapping("/employee")
    public List<Employee> postEmpMethod()
    {
        return hws.postEmpMethod();
    }

}