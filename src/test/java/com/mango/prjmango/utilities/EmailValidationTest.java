package com.mango.prjmango.utilities;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests for valid emails that a user can use when
 * creating their account.
 */
public class EmailValidationTest {
    
    @Test
    public void testValidEmail() {
        //Arrange
        String email = "username@domain.com";

        //Act
        boolean result = EmailValidation.patternMatches(email);

        //Assert
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidEmail1() {
        //Arrange
        String email = "username.@domain.com";

        //Act
        boolean result = EmailValidation.patternMatches(email);

        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidEmail2() {
        //Arrange
        String email = "username@.com";

        //Act
        boolean result = EmailValidation.patternMatches(email);

        //Assert
        Assert.assertFalse(result);
    }
}
