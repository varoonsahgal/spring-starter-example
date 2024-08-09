package com.intuit;

import com.intuit.model.Student;
import com.intuit.service.RegistrationService;
import com.intuit.service.StudentAlreadyRegisteredException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws StudentAlreadyRegisteredException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");

        RegistrationService registrationService = ctx.getBean(RegistrationService.class);

        // Create and register new students
        Long studentID1 = registrationService.registerStudent(new Student("Alan", "Turing", "Computer Science"));
        System.out.println("Student Registered with ID: " + studentID1);

        Long studentID2 = registrationService.registerStudent(new Student("Johannes", "Kepler", "Astronomy"));
        System.out.println("Student Registered with ID: " + studentID2);

        // Read student
        Student student = registrationService.getStudentById(studentID1);
        System.out.println("Retrieved Student: " + student);

        // Update student
        student.setMajor("Mathematics");
        boolean updated = registrationService.updateStudentInfo(student);
        System.out.println("Student Updated: " + updated);

        // Delete student
        boolean deleted = registrationService.removeStudent(studentID2);
        System.out.println("Student Deleted: " + deleted);
    }
}
