package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute(){
      String result = employeeController.route();
      assertEquals("Welcome to SpringBoot Security",result);
    }

    @Test
    void testGetMethod(){
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getMethodMockito()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result = employeeController.getMethodMockito();
        assertEquals(2,result.size());
    }

    //----------------------------DAY 11 TASK3 TESTING-------------------------------------------

    @Test
    void testAddEmployee() {
        RegisterDetails emp = new RegisterDetails();
        emp.setName("Akash");

        when(employeeService.saveEmployeeMockito(emp)).thenReturn(emp);

        RegisterDetails result = employeeController.addEmployee(emp);
        assertEquals("Akash", result.getName());
    }

    @Test
    void testUpdateEmployee() {
        RegisterDetails updatedEmp = new RegisterDetails();
        updatedEmp.setName("Updated Name");

        when(employeeService.updateEmployeeMockito(1, updatedEmp)).thenReturn(updatedEmp);

        RegisterDetails result = employeeController.updateEmployee(1, updatedEmp);
        assertEquals("Updated Name", result.getName());
    }

    @Test
    void testDeleteEmployee() {
        int id = 1;
        employeeController.deleteEmployee(id);
    }

}
