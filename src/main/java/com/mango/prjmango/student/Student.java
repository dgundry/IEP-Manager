package com.mango.prjmango.student;

import lombok.Getter;
import lombok.Setter;

/**
 * A POJO representation of a Student.
 */
public class Student {

    @Getter @Setter private Integer studentID;
    @Getter @Setter private String firstName = "";
    @Getter @Setter private String lastName = "";
    @Getter @Setter private String grade = "";
    @Getter @Setter private String bio = "";

    /**
     * Constructor.
     */
    public Student() {
    }

    /**
     * Constructs a new Student.
     *
     * @param studentID the student's ID
     * @param firstName the student's first name
     */
    public Student(Integer studentID,String firstName) {
        this.studentID = studentID;
        this.firstName = firstName;
    }

    /**
     * Constructs a new Student.
     *
     * @param studentID the student's ID
     * @param firstName the student's first name
     * @param lastName  the student's last name
     * @param grade     the student's grade
     * @param bio       the student's bio
     */
    public Student(Integer studentID, String firstName, String lastName,String grade, String bio) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.bio = bio;
    }

    /**
     * Returns a string representation of an object.
     *
     * @return a string representation of an object.
     */
    @Override
    public String toString(){
        if (studentID == 0) {
            return firstName;
        }
        return lastName + ", " + firstName;
    }
}
