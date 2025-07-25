//package com.example.demo.controllers;
//
//import com.example.demo.models.Employee;
//import com.example.demo.services.HelloWorldService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;


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

//@RestController
//public class HelloWorldController
//{
//    @Autowired
//    HelloWorldService hws;
//
//    @GetMapping("/hello")
//    public String hello()
//    {
//        System.out.println("Default Statement");
//        return hws.helloWorld();
//    }
//
//    //-------DEPENDENCY INJECTION-------
//    @PostMapping("/")
//    public String postMethod()
//    {
//        return hws.postMethod();
//    }
//
//    @PutMapping("/")
//    public String putMethod()
//    {
//        return hws.putMethod();
//    }
//
//    @DeleteMapping("/")
//    public String deleteMethod()
//    {
//        return hws.deleteMethod();
//    }
//
//
//
//    @GetMapping("/employee")
//    public List<Employee> getEmpMethod()
//    {
//        return hws.getEmpMethod();
//    }
//
//    @PostMapping("/employee1")
//    public List<Employee> postEmpMethod()
//    {
//        return hws.postEmpMethod();
//    }
//
//    @PostMapping("/employee2")
//    public List<Employee> postEmpMethod2()
//    {
//        Employee em = new Employee(5,"Puvi","Business");
//        return hws.postEmpMethod2(em);
//    }
//
////  ------------------------------------------USING REQUEST-BODY ------------------------------------------
//
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        return hws.getAllEmployees();
//    }
//
//    // POST new employee (using @RequestBody)
//    @PostMapping("/employees")
//    public List<Employee> addNewEmployee(@RequestBody Employee newEmployee) {
//        return hws.addEmployee(newEmployee);
//    }
//
//    //POST new employee hardcoded
//    @PostMapping("/employees/hardcoded")
//    public List<Employee> addHardcodedEmployee() {
//        Employee hardcodedEmployee = new Employee(30, "Prince", "System");
//        return hws.addEmployee(hardcodedEmployee);
//    }
//
//    // PUT update employee (using @RequestBody + ID)
//    @PutMapping("/employees/{id}")
//    public List<Employee> modifyEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
//        return hws.updateEmployee(id, updatedEmployee);
//    }
//
//    // DELETE employee by ID
//    @DeleteMapping("/employees/{id}")
//    public List<Employee> removeEmployee(@PathVariable int id) {
//        return hws.deleteEmployee(id);
//    }

//  -----------------------------------------ANOTHER METHOD--------------------------------------------

//    @GetMapping("/{empId}")
//    public Employee getEmployee(@PathVariable int empId)
//    {
//        return hws.getEmployeeById(empId);
//    }
//
//    @DeleteMapping("/{empId}")
//    public Employee deleteEmployee(@PathVariable int empId)
//    {
//        return hws.deleteEmployeeById(empId);
//    }
//
//    @PutMapping("/{empId}")
//    public Employee updateEmployee(@PathVariable int empId , @RequestBody Employee updatedEmployee)
//    {
//      return hws.updateEmployeeById(empId, updatedEmployee);
//    }
//
//    @PostMapping("/employee")
//    public Employee addEmployee(@RequestBody Employee newEmp) {
//        return hws.addNewEmployee(newEmp);
//    }
//
////  ------------------------------------------CONNECTING WITH DATABASE-----------------------------------------
//
//    @GetMapping("/employeeFromDB/{empId}")
//    public Employee getEmployeeFromDB(@PathVariable int empId) {
//        return hws.getEmployeeFromDBById(empId);
//    }
//
//    @PostMapping("/employeeFromDB")
//    public String postEmployeeToDB(@RequestBody Employee newEmp)
//   {
//       return hws.postEmployeeToDB(newEmp);
//   }
//   @PutMapping("/employeeFromDB/{empId}")
//    public Employee putEmployeeToDB(@PathVariable int empId , @RequestBody Employee updatedEmployee)
//   {
//       return hws.updateEmployeeToDBById(empId, updatedEmployee);
//   }
//
//   @DeleteMapping("/employeeFromDB/{empId}")
//    public Employee deleteEmployeeFromDB(@PathVariable int empId)
//   {
//       return hws.deleteEmployeeFromDBById(empId);
//   }


   //----------------------------------------SECURITY REQUESTMATCHER --------------------------------------

    // COMMENTED OUT BECAUSE IT CLASHES WITH METHOD LEVEL CODE BELOW , YOU CAN UNCOMMENT IT

//    @GetMapping("/")
//    public String route()
//    {
//        return "Welcome to springboot";
//    }
//
//    @GetMapping("/employeeRBAC")
//    public List<Employee> getAllEmployeeSecurity()
//    {
//        return hws.getAllEmployeeSecurity();
//    }
//
//    @GetMapping("/employeeRBAC/{empId}")
//    public Employee getEmployeeFromDBSecurity(@PathVariable int empId) {
//        return hws.getEmployeeFromDBByIdSecurity(empId);
//    }
//
//
//
//    @PostMapping("/employeeRBAC")
//    public String postEmployeeToDBSecurity(@RequestBody Employee newEmp)
//    {
//        return hws.postEmployeeToDBSecurity(newEmp);
//    }
//
//    @PutMapping("/employeeRBAC/{empId}")
//    public Employee putEmployeeToDBSecurity(@PathVariable int empId , @RequestBody Employee updatedEmployee)
//    {
//        return hws.updateEmployeeToDBByIdSecurity(empId, updatedEmployee);
//    }
//
//    @DeleteMapping("/employeeRBAC/{empId}")
//    public Employee deleteEmployeeFromDBSecurity(@PathVariable int empId)
//    {
//        return hws.deleteEmployeeFromDBByIdSecurity(empId);
//    }


    // -----------------------------------SECURITY METHOD LEVEL TYPE-----------------------------------
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/")
//    public String route()
//    {
//        return "Welcome to springboot";
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employeeRBAC")
//    public List<Employee> getAllEmployeeSecurity2()
//    {
//        return hws.getAllEmployeeSecurity2();
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employeeRBAC/{empId}")
//    public Employee getEmployeeFromDBSecurity2(@PathVariable int empId) {
//        return hws.getEmployeeFromDBByIdSecurity2(empId);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/employeeRBAC")
//    public String postEmployeeToDBSecurity2(@RequestBody Employee newEmp)
//    {
//        return hws.postEmployeeToDBSecurity2(newEmp);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/employeeRBAC/{empId}")
//    public Employee putEmployeeToDBSecurity2(@PathVariable int empId , @RequestBody Employee updatedEmployee)
//    {
//        return hws.updateEmployeeToDBByIdSecurity2(empId, updatedEmployee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/employeeRBAC/{empId}")
//    public Employee deleteEmployeeFromDBSecurity2(@PathVariable int empId)
//    {
//        return hws.deleteEmployeeFromDBByIdSecurity2(empId);
//    }
//}