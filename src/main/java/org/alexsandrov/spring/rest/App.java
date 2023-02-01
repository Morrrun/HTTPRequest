package org.alexsandrov.spring.rest;

import org.alexsandrov.spring.rest.configuration.MyConfig;
import org.alexsandrov.spring.rest.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
        Person postPerson = new Person(3, "James", "Brown", (byte) 28);
        Person putPerson = new Person(3, "Thomas", "Shelby", (byte) 28);

        List<Person> allPerson = communication.allPerson();
        System.out.println(allPerson);
        System.out.println("----------------------------------------------------------------------------");

        ResponseEntity<String> post = communication.postRequest(postPerson);
        ResponseEntity<String> put = communication.putRequest(putPerson);
        ResponseEntity<String> delete = communication.deletePerson(3);

        System.out.println(post.getBody() + put.getBody() + delete.getBody());


    }
}
