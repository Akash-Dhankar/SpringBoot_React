//---------------------DAY 7--------------------------
//PREVIOUS CODES FROM HELLOWORLDSERVICE WERE DELETED / MODIFIED ,SO I AM CREATING A NEW SERVICE---------------------------------------

package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Roles;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.repository.RegisterDetailsRepository;
import com.example.demo.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

//    public List<RegisterDetails> getMethodDTO() {
//        return registerDetailsRepository.findAll();
//    }
//
//    public RegisterDetails getEmployeeByIdDTO(int empId) {
//        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
//    }
//
//   public List<RegisterDetails> getEmployeeByJobDTO() {
//        return registerDetailsRepository.findByRole();
//    }
//
//    public String addEmployeeDTO(RegisterDetails employee) {
//        registerDetailsRepository.save(employee);
//        return "Employee Added Successfully";
//    }
//
//    public String updateEmployeeDTO(int empId) {
//        RegisterDetails user = registerDetailsRepository.findById(empId)
//                .orElseThrow(()->new RuntimeException("No Such User Present"));
//        registerDetailsRepository.save(user);
//        return "Employee Updated Successfully";
//    }
//
//    public String deleteEmployeeByIdDTO(int empId) {
//        registerDetailsRepository.deleteById(empId);
//        return "Employee Deleted Successfully";
//    }

    //------------------------TASK1 - TO UPDATE QUERY BY ID----------------------------

//    public String updateEmployeeDTOByIdTask(int empId, UserDetailsDto updatedData) {
//        RegisterDetails user = registerDetailsRepository.findById(empId)
//                .orElseThrow(() -> new RuntimeException("No Such User Present"));
//
//        user.setName(updatedData.getName());
//        user.setEmail(updatedData.getEmail());
//        user.setUserName(updatedData.getUserName());
//
//        registerDetailsRepository.save(user);
//        return "Employee Updated Successfully";
//    }

    // -----------------------------TASK2 - FIND BY ROLES SPECIFIED-------------------------------

//    public List<RegisterDetails> getEmployeesByRole(String roleName) {
//        return registerDetailsRepository.findByRolesRoleName(roleName);
//    }

    //--------------------------------------------DAY 8 JWT TOKEN---------------------------------------------

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolesRepository rolesRepository;

    public List<RegisterDetails> getMethodJWT() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeByIdJWT(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

//    public List<RegisterDetails> getEmployeeByJobJWT() {
//        return registerDetailsRepository.findByRole();
//    }

    public String updateEmployeeJWT(int empId) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("No Such User Present"));
        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeByIdJWT(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee Deleted Successfully";
    }

    public String addNewEmployeeJWT(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles = new HashSet<>();
        for(String roleName: register.getRoleNames()){
            Roles role = rolesRepository.findByRoleName(roleName)
                    .orElseThrow(()->new RuntimeException("User not found" + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        System.out.println("Registration"+ registerDetails);
        registerDetailsRepository.save(registerDetails);
        return "Employee Added Successfully";
    }

//-----------------------------------------------DAY 11 MOCKITO-----------------------------------------
//    public List<RegisterDetails> getMethodMockito() {
//        return registerDetailsRepository.findAll();
//    }

    //-----------------------------------DAY 11 TASK3 TESTING-------------------------------------------

//    public RegisterDetails saveEmployeeMockito(RegisterDetails emp) {
//        return registerDetailsRepository.save(emp);
//    }
//
//    public RegisterDetails updateEmployeeMockito(int id, RegisterDetails updatedEmp) {
//        updatedEmp.setEmpId(id);
//        return registerDetailsRepository.save(updatedEmp);
//    }
//
//    public void deleteEmployeeMockito(int id) {
//        registerDetailsRepository.deleteById(id);
//    }
}
