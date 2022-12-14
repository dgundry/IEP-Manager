package test.mango.app.utilities;

import com.mango.app.utilities.Encryption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test for the Encryption class to verify
 * the expected results for our users encrypted password.
 */
public class EncryptionTest {

    private Encryption encryption;

    @BeforeEach
    public void setUp() {
        encryption = new Encryption();
    }

    @Test
    public void eightCharacterPasswordTest() {
        //Arrange
        String password = "password";

        //Act
        String expectedPassword = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
        String encryptedPassword = encryption.encryptPassword(password);

        //Assert
        assertEquals(expectedPassword, encryptedPassword);
    }

    @Test
    public void tenCharacterPasswordTest() {
        //Arrange
        String password = "kalsADF,af";

        //Act
        String expectedPassword = "dec037615f607a01298f9d1acec60274e584bbe4b19d0b6ad39754de9074903c";
        String encryptedPassword = encryption.encryptPassword(password);

        //Assert
        assertEquals(expectedPassword, encryptedPassword);
    }

    @Test
    public void twelveCharacterPasswordTest() {
        //Arrange
        String password = "wAf{Q537*CPx";

        //Act
        String expectedPassword = "45795fa5d11655eb78dcdfa520c8e377510b24458c84c0c1d86c036e671473fa";
        String encryptedPassword = encryption.encryptPassword(password);

        //Assert
        assertEquals(expectedPassword, encryptedPassword);
    }

    @Test
    public void sixteenCharacterPasswordTest() {
        //Arrange
        String password = "#W_HAxv&#-mB22(A";

        //Act
        String expectedPassword = "097ccad4f03d0c001388426cd4583838a5ef7ef3192ac57c01850544a2a09d00";
        String encryptedPassword = encryption.encryptPassword(password);

        //Assert
        assertEquals(expectedPassword, encryptedPassword);
    }
}
