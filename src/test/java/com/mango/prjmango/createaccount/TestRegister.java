package com.mango.prjmango.createaccount;

import com.mango.prjmango.createaccount.mothers.UserMother;
import com.mango.prjmango.utilities.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TestRegister {

    private static final Logger logger = Logger.getLogger(TestRegister.class.getName());

    private Register reg;

    private DatabaseConnection connection = new DatabaseConnection();

    @BeforeEach
    public void setUp() {
        connection.setDatabase(connection.getTESTING_DB());
        dropAllRows(connection.getConnection());

        reg = new Register();
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
        User user1 = UserMother.getUser().build();
        User user2 = UserMother.getUser().build();

        //Act
        boolean user1Flag = reg.createUser(user1);
        boolean user2Flag = reg.createUser(user2);

        //Assert
        assertNotEquals(user2Flag, user1Flag);
    }

    @Test
    void invalidSecurityQuestion1ChoiceTest() {
        //Arrange
        User user = UserMother.getUser().build();
        user.setSecurityQ1(-1);

        //Act
        boolean userFlag = reg.createUser(user);

        //Assert
        assertFalse(userFlag);
    }

    @Test
    void invalidSecurityQuestion2ChoiceTest() {
        //Arrange
        User user = UserMother.getUser().build();
        user.setSecurityQ2(-1);

        //Act
        boolean userFlag = reg.createUser(user);

        //Assert
        assertFalse(userFlag);
    }

    @Test
    void isInvalidFirstNameTest() {
        //Arrange
        User user = UserMother.getUser().build();
        user.setFirstName("");

        //Act
        boolean userFlag = reg.createUser(user);

        //Assert
        assertFalse(userFlag);
    }

    @Test
    void isInvalidLastNameTest() {
        //Arrange
        User user = UserMother.getUser().build();
        user.setLastName("");

        //Act
        boolean userFlag = reg.createUser(user);

        //Assert
        assertFalse(userFlag);
    }

    @Test
    void areNotValidPasswordsTest() {
        //Arrange
        User user = UserMother.getUser().build();
        String password = "password2";
        user.setPassword2(password.toCharArray());

        //Act
        boolean userFlag = reg.createUser(user);

        //Assert
        assertFalse(userFlag);
    }
}
