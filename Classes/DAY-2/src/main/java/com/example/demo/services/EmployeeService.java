//---------------------DAY 7--------------------------
//PREVIOUS CODES FROM HELLOWORLDSERVICE WERE DELETED / MODIFIED ,SO I AM CREATING A NEW SERVICE---------------------------------------

package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getMethodDTO() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeByIdDTO(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

//    public List<RegisterDetails> getEmployeeByJobDTO() {
//        return registerDetailsRepository.findByRole();
//    }

    public String addEmployeeDTO(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee Added Successfully";
    }

    public String updateEmployeeDTO(int empId) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("No Such User Present"));
        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeByIdDTO(int empId) {
        registerDetailsRepository.deleteById(empId);
        return "Employee Deleted Successfully";
    }

    //------------------------TASK1 - TO UPDATE QUERY BY ID----------------------------

    public String updateEmployeeDTOByIdTask(int empId, UserDetailsDto updatedData) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("No Such User Present"));

        user.setName(updatedData.getName());
        user.setEmail(updatedData.getEmail());
        user.setUserName(updatedData.getUserName());

        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }

    // -----------------------------TASK2 - FIND BY ROLES SPECIFIED-------------------------------

    public List<RegisterDetails> getEmployeesByRole(String roleName) {
        return registerDetailsRepository.findByRolesRoleName(roleName);
    }

}
