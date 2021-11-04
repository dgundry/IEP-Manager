package com.mango.app;

import com.mango.app.createaccount.Register;
import com.mango.app.createaccount.User;
import com.mango.app.login.LoginPageController;
import com.mango.app.login.LoginPageView;
import com.mango.app.mainloginpage.MainLoginView;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Individual Education Plan Management Tool
 *
 * @author Emily Robey
 * @author Wes Noffsinger
 * @author Devin Grundy
 * @author Patrick Weaver
 * @author Kellen Campbell
 */
public class Main {
    private static Connection connection = null;
    public static Connection getConnection(){
        return connection;
    }

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_WIDTH = (int) screenSize.getWidth();
    public static final int SCREEN_HEIGHT = (int) screenSize.getHeight();

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static final String TESTING_DB = "jdbc:sqlite:database\\testing.db";

    public static void setDatabase(String database) {
        try {
            connection = DriverManager.getConnection(database);
         } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            String url = "jdbc:sqlite:database\\iepCipher.db";
            connection = DriverManager.getConnection(url);

            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//            Register reg = new Register();
//            User user = new User();
//            user.setFirstName("");
//            user.setLastName("admin");
//            user.setEmail("admin@admin.com");
//            user.setPassword1("admin");
//            user.setPassword2("admin");
//            user.setSecurityQ1(1);
//            user.setSecurityA1("admin");
//            user.setSecurityQ2(2);
//            user.setSecurityA2("admin");
//            reg.createUser(user);
            //Comment out these lines and add new code to test out views
            LoginPageView loginPageView = new LoginPageView();
            new LoginPageController(loginPageView);

            new MainLoginView();
            MainLoginView.setActivePanel(loginPageView.getLoginPanel());
        } catch (SQLException
                | ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}

/**
 * Tests
 * System.out.println(login.loginToAccount("something@gmail.com","hello5"));
 * create.registerAccount("Encrypt", "Last","something@gmail.com","hello");
 * create.registerAccount("Encrypt", "Last","something@gmail.com","hello2");
 *
 * CreateAccountController create = new CreateAccountController();
 * LoginPageController login = new LoginPageController();
 * EditAccountController edit = new EditAccountController();
 * create.registerTeacher("Devin","Security", "random6@gmail.com","password",1,"password1", 2, "password2");
 * create.registerAccount("Devin","Gundry","dgundry1@gmail.com","password");
 * edit.changePassword("dgundry1@gmail.com","password1","password","password" );
 * edit.changePassword("something@gmail.com","wefef","we","we");
 * System.out.println(login.loginToAccount("something@gmail.com","hello5"));
 * create.registerAccount("Encrypt", "Last","something2@gmail.com","hello");
 */
