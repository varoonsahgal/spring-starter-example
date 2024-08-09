package com.intuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.dao.RegistrationDAO;
import com.intuit.model.Student;

import java.util.HashMap;


import com.intuit.dao.RegistrationDAO;
import com.intuit.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Component
public class RegistrationService {

    private final RegistrationDAO registrationDAO;

    @Autowired
    public RegistrationService(RegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }

    public Long registerStudent(Student student) throws StudentAlreadyRegisteredException {
        if (studentExists(student)) {
            throw new StudentAlreadyRegisteredException();
        }
        return registrationDAO.persistStudent(student);
    }

    public Student getStudentById(Long id) {
        return registrationDAO.findById(id);
    }

    public boolean updateStudentInfo(Student student) {
        return registrationDAO.updateStudent(student);
    }

    public boolean removeStudent(Long id) {
        return registrationDAO.deleteStudent(id);
    }

    private boolean studentExists(Student student) {
        // Implement logic to check if the student already exists
        // For example, based on first name, last name, and major
        return false;
    }
}


