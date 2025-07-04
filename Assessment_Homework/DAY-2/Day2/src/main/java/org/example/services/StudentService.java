package org.example.services;
import org.example.models.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public String helloWorld() {
        return "Hello World";
    }

    public String postMethod() {
        return "This is postMethod Service";
    }

    public String putMethod() {
        return "This is putMethod Service";
    }

    public String deleteMethod() {
        return "This is deleteMapping Service";
    }

    // List of Students instead of Employees
    List<StudentModel> students = new ArrayList<>(
            Arrays.asList(
                    new StudentModel(1, "Rahul", "Computer Science"),
                    new StudentModel(2, "Anjali", "Electronics")
            )
    );

    public List<StudentModel> getStudentMethod() {
        return students;
    }

    public List<StudentModel> postStudentMethod() {
        return students;
    }

//    -------------------------USING REQUEST-BODY-------------------------

    private List<StudentModel> stud = new ArrayList<>(Arrays.asList(
            new StudentModel(10,"Virat","Cover-Drive"),
            new StudentModel(20,"Balaji","TechIT")
    ));

    //GET all students
    public List<StudentModel> getAllStudents()
    {
        return stud;
    }



}
