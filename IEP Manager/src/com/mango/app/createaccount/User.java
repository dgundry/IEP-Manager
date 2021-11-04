package com.mango.app.createaccount;

public class User {
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String password1 = "";
    private String password2 = "";
    private int securityQ1 = 0;
    private String securityA1 = "";
    private int securityQ2 = 0;
    private String securityA2 = "";
    public User(){
    }
    public void setFirstName(String name){
        this.firstName = name;
    }
    public void setLastName(String name){
        this.lastName = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword1(String pass){
        this.password1 = pass;
    }
    public void setPassword2(String pass){
        this.password2 = pass;
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
    public String getPassword1(){
        return password1;
    }
    public String getPassword2(){
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

    private boolean isValidPassword(String password) {
        return password != null;
    }

    private boolean isUniquePassword(String passwordOne, String passwordTwo) {
        return !passwordOne.equals(passwordTwo);
    }

    private boolean isValidSecurityQuestion(int securityQuestion) {
        return securityQuestion >= 1 && securityQuestion <= 17;
    }

    /*
    public boolean validFields(){
        if(firstName.equals(null) || firstName.equals("")){
            return false;
        }
        if(lastName.equals(null) || lastName.equals("")){
            return false;
        }
        if(email.equals(null) || email.equals("")){
            return false;
        }
        if(!password1.equals(null) && !password2.equals(null)) {
            if (!password1.equals(password2)) {
                return false;
            }
        }else{
            return false;
        }
        if(securityQ1.equals(null) || securityQ1.equals("")){
            return false;
        }else{
            return false;
        }
        if(securityQ2 >= 1 && securityQ2 <= 17){
            if(securityA2.equals(null)){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }*/

    public User copyUser(){
        User newUser = new User();
        newUser.setFirstName(this.firstName);
        newUser.setLastName(this.lastName);
        newUser.setEmail(this.email);
        newUser.setPassword1(this.password1);
        newUser.setPassword2(this.password2);
        newUser.setSecurityQ1(this.securityQ1);
        newUser.setSecurityA1(this.securityA1);
        newUser.setSecurityQ2(this.securityQ2);
        newUser.setSecurityA2(this.securityA2);
        return newUser;
    }
    public String toString(){
        return password1 + ", " + password2;
    }
}
