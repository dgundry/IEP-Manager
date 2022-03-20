package com.mango.prjmango.utilities;

import java.util.regex.Pattern;

/**
 * This class provides a way to verify the user is entering a valid email address following a specific regular
 * expression.
 *
 * Reference:
 * (1): https://www.baeldung.com/java-email-validation-regex
 */
public class EmailValidation {

    private EmailValidation() {
        throw new IllegalStateException("Utility class.");
    }

    /**
     * Verifies the email address entered by the user matches the following regular expression.
     * <br/>
     * There are 3 parts to an email address, for example (username@domain.com):
     * <br/>
     * <ol>
     *     <li>local-part = username</li>
     *     <li>@ = @</li>
     *     <li>domain = domain.com</li>
     * </ol>
     *
     * Restrictions for the local-part include:
     * <ul>
     *     <li>It allows numeric values from 0 to 9</li>
     *     <li>Both uppercase and lowercase letters from a to z are allowed</li>
     *     <li>Allowed are underscore "_", hyphen "-", and dot "."</li>
     *     <li>Dot isn't allowed at the start and end of the local-part</li>
     *     <li>Consecutive dots aren't allowed</li>
     *     <li>For the local part, a maximum of 64 characters are allowed</li>
     * </ul>
     *
     * Restrictions for the domain-part include:
     * <ul>
     *     <li>It allows numeric values from 0 to 9</li>
     *     <li>We allow both uppercase and lowercase letters from a to z</li>
     *     <li>Hyphen "-" and dot "." isn't allowed at the start and end of the domain-part</li>
     *     <li>No consecutive dots</li>
     * </ul>
     *
     * Examples of valid emails:
     * <ul>
     *     <li>username@domain.com</li>
     *     <li>user.name@domain.com</li>
     *     <li>user-name@domain.com</li>
     *     <li>username@domain.co.in</li>
     *     <li>user_name@domain.com</li>
     * </ul>
     *
     * Examples of invalid emails:
     * <ul>
     *     <li>username.@domain.com</li>
     *     <li>.user.name@domain.com</li>
     *     <li>user-name@domain.com.</li>
     *     <li>username@.com</li>
     * </ul>
     *
     * @param emailAddress the users email address
     * @return {@code true} if the users email address passes the regular expression, {@code false} if it does not
     */
    public static boolean patternMatches(String emailAddress) {
        return Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$")
                .matcher(emailAddress)
                .matches();
    }
}
