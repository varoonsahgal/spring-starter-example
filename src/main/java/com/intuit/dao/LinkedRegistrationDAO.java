package com.intuit.dao;

import com.intuit.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Primary
public class LinkedRegistrationDAO implements RegistrationDAO {

    private final Map<Long, Student> linkedHashMap = new LinkedHashMap<>();
    private Long counter = 60L;

    public LinkedRegistrationDAO() {
        this.linkedHashMap.put(10L, new Student(10L, "Marie", "Curie", "Science"));
        this.linkedHashMap.put(22L, new Student(22L, "Albert", "Einstein", "Science"));
        this.linkedHashMap.put(44L, new Student(44L, "Niels", "Bohr", "Science"));
        this.linkedHashMap.put(54L, new Student(54L, "Carl", "Jung", "Psychology"));
    }

    @Override
    public Long persistStudent(Student student) {
        System.out.println("Persist student in LinkedRegistrationDAO here!");
        long freshId = counter++;
        student.setId(freshId);
        this.linkedHashMap.put(freshId, student);
        return freshId;
    }

    @Override
    public Student findById(Long id) {
        return linkedHashMap.get(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        Long id = student.getId();
        if (linkedHashMap.containsKey(id)) {
            linkedHashMap.put(id, student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (linkedHashMap.containsKey(id)) {
            linkedHashMap.remove(id);
            return true;
        }
        return false;
    }
}
