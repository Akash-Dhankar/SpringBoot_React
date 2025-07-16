//package com.example.demo.services;
//
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.repository.EmployeeRepository;
//import com.example.demo.repository.RegisterDetailsRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class EmployeeServiceTest {
//    @Mock
//    RegisterDetailsRepository registerDetailsRepository;
//
//    @InjectMocks
//    EmployeeService employeeService;
//
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetMethod(){
//        RegisterDetails emp1 = new RegisterDetails();
//        RegisterDetails emp2 = new RegisterDetails();
//        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(emp1,emp2));
//        List<RegisterDetails> result = employeeService.getMethodMockito();
//        assertEquals(2,result.size());
//        System.out.println(result);
//    }
//
//    //-------------------------DAY 11 TASK3 TESTING-------------------------------------
//
//    @Test
//    void testSaveEmployee() {
//        RegisterDetails emp = new RegisterDetails();
//        emp.setName("Ajay");
//        when(registerDetailsRepository.save(emp)).thenReturn(emp);
//
//        RegisterDetails result = employeeService.saveEmployeeMockito(emp);
//        assertEquals("Ajay", result.getName());
//    }
//
//    @Test
//    void testUpdateEmployee() {
//        RegisterDetails emp = new RegisterDetails();
//        emp.setEmpId(1);
//        emp.setName("Updated");
//
//        when(registerDetailsRepository.save(emp)).thenReturn(emp);
//
//        RegisterDetails result = employeeService.updateEmployeeMockito(1, emp);
//        assertEquals(1, result.getEmpId());
//        assertEquals("Updated", result.getName());
//    }
//
//    @Test
//    void testDeleteEmployee() {
//        int id = 1;
//        employeeService.deleteEmployeeMockito(id);
//        verify(registerDetailsRepository).deleteById(id);
//    }
//
//}
