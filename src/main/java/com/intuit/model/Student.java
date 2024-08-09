package com.intuit.model;

import java.util.Objects;

public class Student {
    private Long id;
    private final String firstName;
    private final String lastName;
    private  String major;

    public Student(Long id, String firstName, String lastName,
                   String major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }


    public Student(String firstName, String lastName,
                   String major) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", major=" + major
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, id, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) 	return false;

        Student other = (Student) obj;
        return Objects.equals(firstName, other.firstName)
                && Objects.equals(id, other.id)
                && Objects.equals(lastName, other.lastName);
    }

}