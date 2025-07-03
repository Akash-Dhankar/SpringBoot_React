package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
    public static void main(String[] args)
    {
        // ✅ This starts the Spring Boot app and embedded Tomcat server
        SpringApplication.run(App.class, args);
    }
}
