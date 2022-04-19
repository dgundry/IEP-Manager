package com.mango.prjmango.utilities;

/**
 * A POJO representation of a User.
 */
public class User {

    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private char[] password1;
    private char[] password2;
    private int securityQ1 = 0;
    private int securityQ2 = 1;
    private String securityA1 = "";
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
    public int getSecurityQ1(){
        return securityQ1;
    }
    public int getSecurityQ2(){
        return securityQ2;
    }
    public String getSecurityA1(){
        return securityA1;
    }
    public String getSecurityA2(){
        return securityA2;
    }

    /**
     * String representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + email + ", " + password1 + ", " + password2 + ", " + securityQ1 + ": " + securityA1 + ", " + securityQ2 + ": " + securityA2;
    }
}