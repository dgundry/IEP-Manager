package com.mango.prjmango.utilities.dbcommands;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.User;
import java.sql.PreparedStatement;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        resetTeacherSequences();
    }

    void deleteAllEntriesFromTeacher() {
        String sql = "DELETE FROM teacher;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void resetTeacherSequences() {
        String sql = "DELETE FROM sqlite_sequence WHERE name = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, "teacher");
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

    @Test
    void testGetTeacherIdPass() {
        //Act
        int actual = UserCommands.getTeacherId("kcampbell16@radford.edu");
        int expected = 1;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetTeacherIdFail() {
        //Act
        int actual = UserCommands.getTeacherId("kcampbell16@radford.edu");
        int expected = -1;

        //Assert
        assertNotEquals(expected, actual);
    }

    @Test
    void testUpdateUserDetailsPass() {
        //Act
        UserCommands.updateUserDetails("John", "Smith", "jsmith@radford.edu", 1);
        List<String> expected = UserCommands.getUserDetails(1);

        //Assert
        Assertions.assertThat(expected).containsExactly("John", "Smith", "jsmith@radford.edu");
    }

    @Test
    void testUpdateUserDetailsFail() {
        //Act
        UserCommands.updateUserDetails("John", "Smith", "jsmith@radford.edu", 1);
        List<String> expected = UserCommands.getUserDetails(1);

        //Assert
        Assertions.assertThat(expected)
                .isNotEmpty()
                .doesNotContain("Kellen", "Campbell", "kcampbell16@radford.edu");
    }
}
