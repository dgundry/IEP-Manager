package com.mango.prjmango.createaccount;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password1;
    private String password2;
    private String securityA1;
    private String securityA2;

    private int securityQ1;
    private int securityQ2;

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

    private boolean isValidText(String text) { return !text.equals("");
    }

    private boolean isValidPassword(String password) { return password != null;
    }

    private boolean isUniquePassword(String passwordOne, String passwordTwo) { return passwordOne.equals(passwordTwo);
    }

    private boolean isValidSecurityQuestion(int securityQuestion) { return securityQuestion >= 0 && securityQuestion <= 16;
    }

    public String toString(){
        return firstName + ", " +
                lastName + ", " +
                email + ", " +
                password1 + ", " +
                password2 + ", " +
                securityQ1 + ": " +
                securityA1 + ", " +
                securityQ2 + ": " +
                securityA2;
    }
}
