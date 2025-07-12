//--------------------------DAY 7-----------------------------------
//ALL PREVIOUS CODES WERE DELETED AND MODIFIED IN HELLOWORLDCONTROLLER , SO I AM MAKING A NEW CONTROLLER TO CONTINUE FROM DAY 7-------------------------------


package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/")
//    public String route(){
//        return "Welcome to SpringBoot session";
//    }
//
//    @GetMapping("/employeeDTO")
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    public List<RegisterDetails> getMethodDTO(){
//        return employeeService.getMethodDTO();
//    }
//
//    @GetMapping("/employeeDTO/{empId}")
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    public RegisterDetails getEmployeeByIdDTO(@PathVariable int empId){
//        System.out.println();
//        return employeeService.getEmployeeByIdDTO(empId);
//    }


//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee/job/{job}")
//    public List<RegisterDetails> getEmployeeByJobDTO(@PathVariable String job){
//        return employeeService.getEmployeeByJobDTO(job);
//    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/employeeDTO")
//    public String postMethodDTO(@RequestBody RegisterDetails employee){
//        Employee employee = new Employee(5,"Sivagami", "Business");
//        return employeeService.addEmployeeDTO(employee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/employeeDTO/{empId}")
//    public String putMethodDTO(@PathVariable int empId){
//        return employeeService.updateEmployeeDTO(empId);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/employeeDTO/{empID}")
//    public String deleteMethodDTO(@PathVariable int empID){
//        return employeeService.deleteEmployeeByIdDTO(empID);
//    }

// ---------------------------TASK-1 TO UPDATE QUERY BY ID ---------------------------------

//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/employeeDTOByIdTask/{empId}")
//    public String putMethodDTOByIdTask(@PathVariable int empId, @RequestBody UserDetailsDto updatedUser) {
//        return employeeService.updateEmployeeDTOByIdTask(empId, updatedUser);
//    }


//----------------------------TASK-2 TO FIND BY ROLES SPECIFIED-------------------------------
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/employeeDTO/role/{roleName}")
//    public List<RegisterDetails> getEmployeesByRole(@PathVariable String roleName) {
//        return employeeService.getEmployeesByRole(roleName);
//    }

    //---------------------------------------------DAY 8 JWT TOKEN---------------------------------------

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route(){
        return "Welcome to SpringBoot Security";
    }


    @GetMapping("/employeeJWT")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RegisterDetails> getMethod(){
        return employeeService.getMethodJWT();
    }


    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/employeeJWT/{empId}")
    public RegisterDetails getEmployeeByIdJWT(@PathVariable int empId){
        System.out.println();
        return employeeService.getEmployeeByIdJWT(empId);
    }

//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee/job/{job}")
//    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job){
//        return employeeService.getEmployeeByJob(job);
//    }
    
    @PostMapping("/employeeJWT")
    public String postMethodJWT(@RequestBody UserDetailsDto employee){
//        Employee employee = new Employee(5,"Sivagami", "Business");
        return employeeService.addNewEmployeeJWT(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employeeJWT/{empId}")
    public String putMethodJWT(@PathVariable int empId){
        return employeeService.updateEmployeeJWT(empId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employeeJWT/{empID}")
    public String deleteMethodJWT(@PathVariable int empID){
        return employeeService.deleteEmployeeByIdJWT(empID);
    }


}
