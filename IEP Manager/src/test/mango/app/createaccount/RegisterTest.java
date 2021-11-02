package test.mango.app.createaccount;

import com.mango.app.*;
import com.mango.app.createaccount.*;
import java.sql.*;
import org.junit.*;

import static org.junit.Assert.assertNotEquals;

public class RegisterTest {

    @Before
    public void setUp() {
        Main.setDatabase(Main.TESTING_DB);

        try {
            String url = "jdbc:sqlite:database\\testing.db";
            Connection connection = DriverManager.getConnection(url);

            dropAllRows(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void dropAllRows(Connection connection) {
        String sql = "DELETE FROM teacher;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sameEmailTest() {
        //Arrange
        Register reg = new Register();

        User user1 = new User();
        user1.setFirstName("admin");
        user1.setLastName("admin");
        user1.setEmail("admin@admin.com");
        user1.setPassword1("admin");
        user1.setPassword2("admin");
        user1.setSecurityQ1(1);
        user1.setSecurityA1("admin");
        user1.setSecurityQ2(2);
        user1.setSecurityA2("admin");

        User user2 = new User();
        user2.setFirstName("admin");
        user2.setLastName("admin");
        user2.setEmail("admin@admin.com");
        user2.setPassword1("admin");
        user2.setPassword2("admin");
        user2.setSecurityQ1(1);
        user2.setSecurityA1("admin");
        user2.setSecurityQ2(2);
        user2.setSecurityA2("admin");

        //Act
        boolean user1Flag = reg.createUser(user1);
        boolean user2Flag = reg.createUser(user2);

        //Assert
        assertNotEquals(user2Flag, user1Flag);
    }
}
