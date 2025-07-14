//package com.example.demo.services;
//
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.repository.RegisterDetailsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    RegisterDetailsRepository registerDetailsRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    public String addNewEmployee(RegisterDetails register)
//    {
//        RegisterDetails registerDetails = new RegisterDetails();
//        registerDetails.setEmpId(register.getEmpId());
//        registerDetails.setEmail(register.getEmail());
//       registerDetails.setGender(register.getGender());
//        String enc = passwordEncoder.encode(register.getPassword());
//        System.out.println("Password is: " + register.getPassword() + "\nEncrypted Password is: " + enc);
//        registerDetails.setPassword(enc);
//       registerDetails.setEmpName(register.getEmpName());
//       registerDetails.setRole(register.getRole());
//        registerDetailsRepository.save(registerDetails);
//        return "Employee Added Successfully";
//    }
//
//    public String authenticate(RegisterDetails login)
//    {
//        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
//        if(user!=null)
//        {
//           if(passwordEncoder.matches(login.getPassword(),user.getPassword()))
//           {
//               return "Login Successful";
//           }
//        }
//        return "Login Not Successful";
//    }
//}

//---------------------------------------------DAY 7 ----------------------------------------------
package com.example.demo.services;

import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Roles;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.repository.RegisterDetailsRepository;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public String addNewEmployee(UserDetailsDto register)
    {
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

//    public String authenticate(RegisterDetails login)
//    {
//        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
//        if(user!=null)
//        {
//            if(passwordEncoder.matches(login.getPassword(),user.getPassword()))
//            {
//                return "Login Successful";
//            }
//        }
//        return "Login Not Successful";
//    }

    //----------------------------DAY 8 JWT-----------------------------THE ABOVE LINES NOT NEEDED-----------------------
    //-------ABOVE CODE OF String authenticate IS FOR DAY 7 -------------------------------------------------------------
//    public String authenticate(UserDetailsDto login){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(login.getUserName(),login.getPassword()));
//        return jwtTokenProvider.generateToken(authentication);
//    }
//
//    public Optional<RegisterDetails> getUserByUserName(String username){
//        return registerRepository.findByUserName(username);
//
//    }

    //---------------------------------------------------DAY 9 - WITH REACT-----------------------------------------

    public String authenticate(RegisterDetails login){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUserName(),login.getPassword()));
        return jwtTokenProvider.generateToken(authentication);
    }

    public Optional<RegisterDetails> getUserByUserName(String username){
        return registerRepository.findByUserName(username);

    }
}
