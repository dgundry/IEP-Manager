package com.mango.prjmango.student;

public class Student {

    private String firstName = "";
    private String lastName = "";
    private String grade = "";
    private String bio = "";

    public void setFirstName(String name) {this.firstName = name; }
    public void setLastName(String name){ this.lastName = name; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setBio(String bio) { this.bio = bio; }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGrade() { return grade; }
    public String getBio() { return bio; }

    public boolean isValidField() {
        System.out.println("Testing Fields");
        return isValidText(firstName) &&
                isValidText(lastName) &&
                isValidText(grade) &&
                isValidText(bio);
    }

    private boolean isValidText(String text) { return !text.equals(""); }

    public String toString(){
        return firstName + ", " + lastName + ", " + grade + ", " + bio;
    }
}
