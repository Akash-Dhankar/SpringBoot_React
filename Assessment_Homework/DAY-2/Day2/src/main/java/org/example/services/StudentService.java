package org.example.services;
import org.example.models.StudentModel;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //POST Students
    public List<StudentModel> postAllStudents(StudentModel newStudent)
    {
        stud.add(newStudent);
        return stud;
    }

    //PUT STUDENT(UPDATE)
    public List<StudentModel> putAllStudents(int id , StudentModel updatedStudent)
    {
        for(StudentModel s : stud)
        {
            if(s.getStudentId() == id)
            {
                s.setStudentName(updatedStudent.getStudentName());
                s.setStudentCourse(updatedStudent.getStudentCourse());
                break;
            }
        }
        return stud;
    }

    //DELETE STUDENTS
    public List<StudentModel> deleteAllStudents(int id)
    {
        stud.removeIf(s -> s.getStudentId() == id);
        return stud;
    }


    //----------------------------------CONNECTING WITH DATABASE---------------------------------------

    @Autowired
    StudentRepository studRepo;
    public List<StudentModel> getStudentFromDB()
    {
        return studRepo.findAll();
    }

    public StudentModel getStudentFromDBById(int studentId)
    {
        return studRepo.findById(studentId).orElse(new StudentModel());
    }

    public String postStudentToDB(StudentModel student)
    {
        studRepo.save(student);
        return "Student added successfully";
    }

    public StudentModel putStudentToDBById(int studentId , StudentModel updatedStudent)
    {
        studRepo.save(updatedStudent);
        System.out.println("Student detail updated successfully");
        return updatedStudent;
    }

    public StudentModel deleteStudentFromDBById(int studentId)
    {
        studRepo.deleteById(studentId);
        System.out.println("Student detail deleted successfully");
        return null;
    }

    //-----------------------------------------SECURITY REQUEST-MATCHER RBAC-----------------------------------------

    public List<StudentModel> getAllStudentsSecurity()
    {
        return studRepo.findAll();
    }

    public StudentModel getStudentFromDBSecurity(int studId)
    {
        return studRepo.findById(studId).orElse(new StudentModel());
    }

    public String postStudentToDBSecurity(StudentModel newStudent)
    {
        studRepo.save(newStudent);
        return "Student added successfully";
    }

    public StudentModel putStudentToDBSecurity(int studId , StudentModel updatedStudent)
    {
        studRepo.save(updatedStudent);
        System.out.println("Student detail updated successfully");
        return updatedStudent;
    }

    public StudentModel deleteStudentFromDBSecurity(int studId)
    {
        studRepo.deleteById(studId);
        System.out.println("Student detail deleted successfully");
        return null;
    }

 //-----------------------------------------SECURITY METHOD LEVEL---------------------------------------

    public List<StudentModel> getAllStudentsSecurity2()
    {
        return studRepo.findAll();
    }

    public StudentModel getStudentFromDBSecurity2(int studId)
    {
        return studRepo.findById(studId).orElse(new StudentModel());
    }

    public String postStudentToDBSecurity2(StudentModel newStudent)
    {
        studRepo.save(newStudent);
        return "Student added successfully";
    }

    public StudentModel putStudentToDBSecurity2(int studId , StudentModel updatedStudent)
    {
        studRepo.save(updatedStudent);
        System.out.println("Student detail updated successfully");
        return updatedStudent;
    }

    public StudentModel deleteStudentFromDBSecurity2(int studId)
    {
        studRepo.deleteById(studId);
        System.out.println("Student detail deleted successfully");
        return null;
    }

}
