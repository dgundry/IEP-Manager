package test.mango.app.createaccount;

import com.mango.app.*;
import com.mango.app.createaccount.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;

import static org.junit.Assert.assertNotEquals;

public class RegisterTest {

    private static final Logger logger = Logger.getLogger(RegisterTest.class.getName());

    @Before
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
