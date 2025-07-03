package org.example;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext student = new ClassPathXmlApplicationContext("resources.xml");
        Student s = (Student) student.getBean("st");
        s.internshipProgram();
        SpringBoot s1=(SpringBoot) student.getBean("fun");
        s1.hello("hi world");
        System.out.println( "Hello World!" );
        Class1 c1 =(Class1) student.getBean("c1");
        c1.display();
        Class2 c2 =(Class2) student.getBean("c2");
        c2.show();
        Class3 c3 =(Class3) student.getBean("c3");
        c3.print();
    }
}