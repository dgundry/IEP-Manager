package com.mango.prjmango.utilities;

import java.util.regex.Pattern;

public class EmailValidation {

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
