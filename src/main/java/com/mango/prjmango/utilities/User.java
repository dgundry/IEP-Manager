package com.mango.prjmango.utilities;

import java.util.Arrays;

public class User {

    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private char[] password1;
    private char[] password2;
    private int securityQ1 = 0;
    private String securityA1 = "";
    private int securityQ2 = 1;
    private String securityA2 = "";

    public void setFirstName(String name){
        this.firstName = name;
    }
    public void setLastName(String name){
        this.lastName = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword1(char[] password){
        this.password1 = password;
    }
    public void setPassword2(char[] password){
        this.password2 = password;
    }
    public void setSecurityQ1(int question){
        this.securityQ1 = question;
    }
    public void setSecurityA1(String answer){
        this.securityA1 = answer;
    }
    public void setSecurityQ2(int question){
        this.securityQ2 = question;
    }
    public void setSecurityA2(String answer){
        this.securityA2 = answer;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public char[] getPassword1(){
        return password1;
    }
    public char[] getPassword2(){
        return password2;
    }
    public int getSecurityQ1(){
        return securityQ1;
    }
    public String getSecurityA1(){
        return securityA1;
    }
    public int getSecurityQ2(){
        return securityQ2;
    }
    public String getSecurityA2(){
        return securityA2;
    }

    public boolean isValidFields() {
        System.out.println("Testing Fields");
        return isValidText(firstName) &&
                isValidText(lastName) &&
                isValidText(email) &&
                isValidPassword(password1) &&
                isValidPassword(password2) &&
                isUniquePassword(password1, password2) &&
                isValidSecurityQuestion(securityQ1) &&
                isValidSecurityQuestion(securityQ2) &&
                isValidText(securityA1) &&
                isValidText(securityA2);
    }

    private boolean isValidText(String text) {
        return !text.equals("");
    }

    private boolean isValidPassword(char[] password) {
        return password.length != 0;
    }

    private boolean isUniquePassword(char[] passwordOne, char[] passwordTwo) {
        return Arrays.equals(passwordOne, passwordTwo);
    }

    private boolean isValidSecurityQuestion(int securityQuestion) { return securityQuestion >= 0 && securityQuestion <= 16;
    }
    public String toString(){
        return firstName + ", " + lastName + ", " + email + ", " + password1 + ", " + password2 + ", " + securityQ1 + ": " + securityA1 + ", " + securityQ2 + ": " + securityA2;
    }
}