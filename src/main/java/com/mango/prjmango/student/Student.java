package com.mango.prjmango.student;

import lombok.Getter;
import lombok.Setter;

public class Student {

    @Getter @Setter private Integer studentID;
    @Getter @Setter private String firstName = "";
    @Getter @Setter private String lastName = "";
    @Getter @Setter private String grade = "";
    @Getter @Setter private String bio = "";

    public Student(){
    }

    public Student(Integer studentID, String firstName, String lastName,String grade, String bio) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.bio = bio;
    }
    public boolean isValidField() {
        System.out.println("Testing Fields");
        return isValidText(firstName) &&
                isValidText(lastName) &&
                isValidText(bio);
    }

    private boolean isValidText(String text) { return !text.equals(""); }

    public String toString(){
        return lastName + ", " + firstName;
    }
}
