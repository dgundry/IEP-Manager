package com.mango.prjmango.utilities.dbcommands;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.User;
import java.sql.PreparedStatement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests whether there is a valid user within the teacher table.
 */
class UserCommandsTest {

    private char[] password;

    @BeforeEach
    void setUp() {
        DatabaseConnection.setDatabase(DatabaseConnection.TESTING_DB);

        User user = new User();
        user.setFirstName("Kellen");
        user.setLastName("Campbell");
        user.setEmail("kcampbell16@radford.edu");

        password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        DatabaseCommands.addNewTeacher(user, password);
    }

    @AfterEach
    void tearDown() {
        deleteAllEntriesFromTeacher();
    }

    void deleteAllEntriesFromTeacher() {
        String sql = "DELETE FROM teacher;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testIsValidUserPass() {
        //Act
        int actual = UserCommands.isValidUser("kcampbell16@radford.edu", password);
        int expected = 1;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testIsValidUserFail() {
        //Act
        int actual = UserCommands.isValidUser("kcampbell161@radford.edu", password);
        int expected = 0;

        //Assert
        assertEquals(expected, actual);
    }
}