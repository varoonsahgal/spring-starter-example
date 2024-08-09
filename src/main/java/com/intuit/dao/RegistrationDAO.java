
package com.intuit.dao;

import com.intuit.model.Student;

//BY having this interface, we are effectively saying
// IF YOU want to be the persistence layer, then you have to abide by this CONTRACT
// you have to provide concrete implementations of the persistStudent and findById methods!
// aside: abstract is the opposite of concrete


// how do we enforce this contract?  we enforce it in RegistrationService
// Because we say "we are only going to accept objects of type RegistrationDAO"
// in plain english - if you implemented this interface then you are good to be my DAO

public interface RegistrationDAO {
    Long persistStudent(Student student); // Create
    Student findById(Long id); // Read
    boolean updateStudent(Student student); // Update
    boolean deleteStudent(Long id); // Delete
}
