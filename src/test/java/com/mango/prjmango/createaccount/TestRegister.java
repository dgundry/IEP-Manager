package com.mango.prjmango.createaccount;

import com.mango.prjmango.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestRegister {

    private static final Logger logger = Logger.getLogger(TestRegister.class.getName());

    @BeforeEach
    public void setUp() {
        Main.setDatabase(Main.TESTING_DB);
        dropAllRows(Main.getConnection());
    }

    private void dropAllRows(Connection connection) {
        String sql = "DELETE FROM teacher;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Test
    void sameEmailTestOne() {
        //Arrange
        Register reg = new Register();

        final String ADMIN = "admin";
        final String ADMIN_EMAIL = "admin@admin.com";

        User user1 = new User();
        user1.setFirstName(ADMIN);
        user1.setLastName(ADMIN);
        user1.setEmail(ADMIN_EMAIL);
        user1.setPassword1(ADMIN);
        user1.setPassword2(ADMIN);
        user1.setSecurityQ1(1);
        user1.setSecurityA1(ADMIN);
        user1.setSecurityQ2(2);
        user1.setSecurityA2(ADMIN);

        User user2 = new User();
        user2.setFirstName(ADMIN);
        user2.setLastName(ADMIN);
        user2.setEmail(ADMIN_EMAIL);
        user2.setPassword1(ADMIN);
        user2.setPassword2(ADMIN);
        user2.setSecurityQ1(1);
        user2.setSecurityA1(ADMIN);
        user2.setSecurityQ2(2);
        user2.setSecurityA2(ADMIN);

        //Act
        boolean user1Flag = reg.createUser(user1);
        boolean user2Flag = reg.createUser(user2);

        //Assert
        assertNotEquals(user2Flag, user1Flag);
    }

    @Test
    void invalidSecurityQuestion1ChoiceTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Smith");
        user1.setEmail("jsmith@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password2");
        user1.setSecurityQ1(-1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertFalse(user1Flag);
    }

    @Test
    void invalidSecurityQuestion2ChoiceTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Smith");
        user1.setEmail("jsmith@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password2");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(-1);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertFalse(user1Flag);
    }

    @Test
    void isValidFirstNameTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Smith");
        user1.setEmail("jsmith@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password1");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertTrue(user1Flag);
    }

    @Test
    void isInvalidFirstNameTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("");
        user1.setLastName("Smith");
        user1.setEmail("jsmith@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password2");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertFalse(user1Flag);
    }

    @Test
    void isValidLastNameTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Campbell");
        user1.setEmail("jcampbell@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password1");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertTrue(user1Flag);
    }

    @Test
    void isInvalidLastNameTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("");
        user1.setEmail("jsmith@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password1");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertFalse(user1Flag);
    }

    @Test
    void areValidPasswordsTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("Kellen");
        user1.setLastName("Campbell");
        user1.setEmail("kcampbell16@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password1");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertTrue(user1Flag);
    }

    @Test
    void areNotValidPasswordsTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("Kellen");
        user1.setLastName("Campbell");
        user1.setEmail("kcampbell16@radford.edu");
        user1.setPassword1("password1");
        user1.setPassword2("password2");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("Answer 1");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("Answer 2");

        //Act
        boolean user1Flag = reg.createUser(user1);

        //Assert
        assertFalse(user1Flag);
    }
}
