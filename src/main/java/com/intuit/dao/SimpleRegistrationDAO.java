package com.intuit.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.intuit.model.Student;

// Component tells Spring to create an object from the class and
// identify it as RegistrationDAO type.  This object is a Spring   // bean If any other component
// requires a RegistrationDAO type it will use this object created
// by Spring.

// The default scope for the object is singleton. Which means that
// it will be available for the duration of the application


@Component
public class SimpleRegistrationDAO implements RegistrationDAO {

    private final Map<Long, Student> hashMap = new HashMap<>();
    private Long counter = 60L;

    public SimpleRegistrationDAO() {
        //System.out.println("Spring is calling the LinkedRegistrationDAO here!");
        this.hashMap.put(10L, new Student(10L, "Marie", "Curie", "Science"));
        this.hashMap.put(22L, new Student(22L, "Albert", "Einstein", "Science"));
        this.hashMap.put(44L, new Student(44L, "Niels", "Bohr", "Science"));
        this.hashMap.put(54L, new Student(54L, "Carl", "Jung", "Psychology"));
    }

    @Override
    public Long persistStudent(Student student) {
        System.out.println("Persist student in SimpleRegistrationDAO here!");
        long freshId = counter++;
        student.setId(freshId);
        this.hashMap.put(freshId, student);
        return freshId;
    }

    @Override
    public Student findById(Long id) {
        return hashMap.get(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        Long id = student.getId();
        if (hashMap.containsKey(id)) {
            hashMap.put(id, student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (hashMap.containsKey(id)) {
            hashMap.remove(id);
            return true;
        }
        return false;
    }
}