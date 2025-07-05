package org.example.controllers;
import org.example.models.StudentModel;
import org.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService hws;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Default Statement");
        return hws.helloWorld();
    }

    @PostMapping("/")
    public String postMethod() {
        return hws.postMethod();
    }

    @PutMapping("/")
    public String putMethod() {
        return hws.putMethod();
    }

    @DeleteMapping("/")
    public String deleteMethod() {
        return hws.deleteMethod();
    }

    // Updated endpoints for students
    @GetMapping("/students")
    public List<StudentModel> getStudentMethod() {
        return hws.getStudentMethod();
    }

    @PostMapping("/students")
    public List<StudentModel> postStudentMethod() {
        return hws.postStudentMethod();
    }

//    ------------------------USING REQUEST-BODY-----------------------------

    @GetMapping("/student")
    public List<StudentModel> getAllStudents()
    {
        return hws.getAllStudents();
    }

    @PostMapping("/student")
    public List<StudentModel> postAllStudents(@RequestBody StudentModel newStudent)
    {
        return hws.postAllStudents(newStudent);
    }
}
