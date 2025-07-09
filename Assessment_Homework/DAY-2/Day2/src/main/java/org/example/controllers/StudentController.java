package org.example.controllers;
import org.example.models.StudentModel;
import org.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PutMapping("/student/{id}")
    public List<StudentModel> putAllStudents(@PathVariable int id , @RequestBody StudentModel updatedStudent)
    {
        return hws.putAllStudents(id,updatedStudent);
    }

    @DeleteMapping("/student{id}")
    public List<StudentModel> deleteAllStudents(@PathVariable int id)
    {
        return hws.deleteAllStudents(id);
    }

    //---------------------CONNECTING WITH DATABASE------------------------------

    @GetMapping("/studentFromDB/{studentId}")
    public StudentModel getStudentFromDB(@PathVariable int studentId)
    {
        return hws.getStudentFromDBById(studentId);
    }

    @PostMapping("/studentFromDB")
    public String postStudentToDB(@RequestBody StudentModel newStudent)
    {
        return hws.postStudentToDB(newStudent);
    }

    @PutMapping("/studentFromDB/{studentId}")
    public StudentModel putStudentToDB(@PathVariable int studentId , @RequestBody StudentModel updatedStudent)
    {
        return hws.putStudentToDBById(studentId,updatedStudent);
    }

    @DeleteMapping("/studentFromDB/{studentId}")
    public StudentModel deleteStudentFromDB(@PathVariable int studentId)
    {
        return hws.deleteStudentFromDBById(studentId);
    }

    //------------------------------------------SECURITY REQUEST LEVEL-------------------------------------------------

//    @GetMapping("/")
//    public String route()
//    {
//        return "Welcome to Student DashBoard made using SpringBoot";
//    }
//
//    @GetMapping("/studentRBAC")
//    public List<StudentModel> getAllStudentsSecurity()
//    {
//        return hws.getAllStudentsSecurity();
//    }
//
//    @GetMapping("/studentRBAC/{studId}")
//    public StudentModel getStudentFromDBSecurity(@PathVariable int studId)
//    {
//        return hws.getStudentFromDBSecurity(studId);
//    }
//
//    @PostMapping("/studentRBAC")
//    public String postStudentToDBSecurity(@RequestBody StudentModel newStudent)
//    {
//        return hws.postStudentToDBSecurity(newStudent);
//    }
//
//    @PutMapping("/studentRBAC/{studId}")
//    public StudentModel putStudentToDBSecurity(@PathVariable int studId , @RequestBody StudentModel updatedStudent)
//    {
//        return hws.putStudentToDBSecurity(studId,updatedStudent);
//    }
//
//    @DeleteMapping("/studentRBAC/{studId}")
//    public StudentModel deleteStudentFromDBSecurity(@PathVariable int studId)
//    {
//        return hws.deleteStudentFromDBSecurity(studId);
//    }


//----------------------------------------------SECURITY METHOD LEVEL -----------------------------------------------------------E

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public String route()
    {
        return "Welcome to Student DashBoard made using SpringBoot";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/studentRBAC")
    public List<StudentModel> getAllStudentsSecurity2()
    {
        return hws.getAllStudentsSecurity2();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/studentRBAC/{studId}")
    public StudentModel getStudentFromDBSecurity2(@PathVariable int studId) {
        return hws.getStudentFromDBSecurity2(studId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/studentRBAC")
    public String postStudentToDBSecurity2(@RequestBody StudentModel newStudent)
    {
        return hws.postStudentToDBSecurity2(newStudent);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/studentRBAC/{studId}")
    public StudentModel putStudentToDBSecurity2(@PathVariable int studId , @RequestBody StudentModel updatedStudent)
    {
        return hws.putStudentToDBSecurity2(studId, updatedStudent);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/studentRBAC/{studId}")
    public StudentModel deleteStudentFromDBSecurity2(@PathVariable int studId)
    {
        return hws.deleteStudentFromDBSecurity2(studId);
    }



}
