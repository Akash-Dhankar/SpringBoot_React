package com.example.demo.services;
import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService
{
    public String helloWorld()
    {
        return "Hello World";
    }

    public String postMethod()
    {
        return "This is postMethod Service";
    }

    public String putMethod()
    {
        return "This is putMethod Service";
    }

    public String deleteMethod()
    {
        return "This is deleteMapping Service";
    }

    //--------------------OTHER CONCEPT USING LIST OF EMPLOYEES , GETTERS,SETTERS,CONSTRUCTORS---------------------

    List<Employee> emp = new ArrayList<>(
            Arrays.asList(
                    new Employee(1,"Prasanth","Trainer"),
                    new Employee(2,"Yuvaraj","Faculty")
            )
    );

    public List<Employee> getEmpMethod()
    {
        return emp;
    }

    public List<Employee> postEmpMethod()
    {
        return emp;
    }

    public List<Employee> postEmpMethod2(Employee em)
    {
        emp.add(em);
        return List.of();
    }

//    ---------------------USING REQUEST-BODY-------------------------


    private List<Employee> workers = new ArrayList<>(Arrays.asList(
            new Employee(10, "Vikram", "Trainer"),
            new Employee(20, "Rohan", "Faculty")
    ));

    // Get all employees
    @Autowired
    public List<Employee> getAllEmployees() {
        return workers;
    }

    // Add new employee
    public List<Employee> addEmployee(Employee employee) {
        workers.add(employee);
        return workers;
    }

    // Update employee by ID
    public List<Employee> updateEmployee(int id, Employee employee) {
        for (Employee emp : workers) {
            if (emp.getEmpId() == id) {
                emp.setEmpName(employee.getEmpName());
                emp.setEmpJob(employee.getEmpJob());
                break;
            }
        }
        return workers;
    }

    // Delete employee by ID
    public List<Employee> deleteEmployee(int id) {
        workers.removeIf(emp -> emp.getEmpId() == id);
        return workers;
    }

//    -----------------------------------ANOTHER CONCEPT-------------------------------------------

//    this should come after code at line 66 , but for understanding writing it here

    public Employee getEmployeeById(int empId)
    {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < workers.size(); i++)
        {
            if (empId == workers.get(i).getEmpId())
            {
                System.out.println("Emp_ID: " + workers.get(i).getEmpId() + workers.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if(flag)
        {
            return workers.get(ind);
        }
        else {
            return new Employee();
        }
    }

    public Employee deleteEmployeeById(int empId) {
        int ind = 0;
        boolean flag = false;
        Employee deletedEmployee = null;

        for (int i = 0; i < workers.size(); i++) {
            if (empId == workers.get(i).getEmpId()) {
                System.out.println("Emp_ID: " + workers.get(i).getEmpId() + workers.get(i));
                deletedEmployee = workers.get(i);
                ind = i;
                flag = true;
                break;
            }
        }

        if (flag) {
            workers.remove(ind);
            return deletedEmployee;
        } else {
            return null;
        }
    }

    public Employee updateEmployeeById(int empId, Employee updatedEmployee) {
        int ind = 0;
        boolean flag = false;
        Employee existingEmployee = null;

        // Find the employee
        for (int i = 0; i < workers.size(); i++)
        {
            if (empId == workers.get(i).getEmpId())
            {
                System.out.println("Found employee to update: " + workers.get(i));
                existingEmployee = workers.get(i);
                ind = i;
                flag = true;
                break;
            }
        }

        if (flag)
        {
            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            existingEmployee.setEmpJob(updatedEmployee.getEmpJob());
            workers.set(ind, existingEmployee);
            return existingEmployee;
        }
        else
        {
            return null;
        }
    }

    public Employee addNewEmployee(Employee newEmp) {
        boolean exists = false;

        for (Employee e : workers) {
            if (e.getEmpId() == newEmp.getEmpId()) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            workers.add(newEmp);
            System.out.println("Added employee: " + newEmp);
            return newEmp;
        } else {
            System.out.println("Employee with ID " + newEmp.getEmpId() + " already exists.");
            return null; // Or throw an exception, or return a custom message
        }
    }

    //--------------------------------CONNECTING WITH DATABASE----------------------------------

    @Autowired
    EmployeeRepository empRepo;
    public List<Employee> getEmployeeFromDB()
    {
        return empRepo.findAll();
    }

    public Employee getEmployeeFromDBById(int empId){
        return empRepo.findById(empId).orElse(new Employee());
    }

    public String postEmployeeToDB(Employee employee)
    {
        empRepo.save(employee);
        return "Employee added successfully";
    }

    public Employee updateEmployeeToDBById(int empId , Employee updatedEmployee)
    {
        empRepo.save(updatedEmployee);
        System.out.println("Employee detail updated successfully");
        return updatedEmployee;
    }

    public Employee deleteEmployeeFromDBById(int empId)
    {
        empRepo.deleteById(empId);
        System.out.println("Employee detail deleted successfully");
        return null;
    }
}






