package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/resources.xml"); //if u want to keep like this , you have to include the <build> code inside pom.xml  , otherwise preferred way is to keep resources.xml inside resources folder and just include resources.xml in this bracket (no need of build also)
        Student s = (Student) context.getBean("st");
        s.internshipProgram();

        System.out.println("HEY THERE");
    }
}
