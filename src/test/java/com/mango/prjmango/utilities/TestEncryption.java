package com.mango.prjmango.utilities;

import org.junit.Before;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * JUnit test for the Encryption class to verify
 * the expected results for our users encrypted password.
 */
class TestEncryption {

    private static DatabaseConnection connection = new DatabaseConnection();

    @Before
    public void setUp() {
        connection.setDatabase(connection.getTESTING_DB());
    }

    void testPasswordInDatabase() throws NoSuchAlgorithmException {
        //Arrange
        char[] password = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };

        //Act
        Encryption.encrypt(Arrays.toString(password));

        //Assert


    }
}
