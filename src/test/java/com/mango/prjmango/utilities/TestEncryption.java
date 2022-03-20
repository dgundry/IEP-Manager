package com.mango.prjmango.utilities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * JUnit test for the Encryption class to verify
 * the expected results for our users encrypted password.
 */
public class TestEncryption {

    @Before
    public void setUp() {
        DatabaseConnection.setDatabase(DatabaseConnection.TESTING_DB);
    }

    @Test
    public void testEncryptedPasswordInDatabase() throws NoSuchAlgorithmException {
        //Arrange
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setEmail("jsmith@gmail.com");
        user.setSecurityQ1(1);
        user.setSecurityQ2(2);
        user.setSecurityA1("Big John");
        user.setSecurityA2("Radford");

        char[] password = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };

        DatabaseCommands.addNewTeacher(user, password);
        DatabaseCommands.registerSecurityAnswer(user, user.getSecurityQ1(), user.getSecurityA1());
        DatabaseCommands.registerSecurityAnswer(user, user.getSecurityQ2(), user.getSecurityA2());

        int teacherId = DatabaseCommands.getTeacherId(user.getEmail());

        //Act
        String expected = Encryption.encrypt(Arrays.toString(password));
        String actual   = DatabaseCommands.getUserPassword(teacherId);

        //Assert
        Assert.assertEquals(expected, actual);
    }
}
