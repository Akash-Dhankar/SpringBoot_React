package com.example.demo.services;
import com.example.demo.models.Employee;
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
}
