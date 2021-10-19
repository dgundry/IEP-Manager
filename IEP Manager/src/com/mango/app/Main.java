package com.mango.app;

import com.mango.app.createaccount.*;
import com.mango.app.forgotpassword.ForgotPasswordController;
import com.mango.app.forgotpassword.SecurityQuestionsOneView;
import com.mango.app.login.LoginPageController;
import com.mango.app.login.LoginPageView;
import com.mango.app.utilities.OSUtils;

import javax.swing.*;
import java.awt.*;
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
    private static final int SCREEN_WIDTH = (int) screenSize.getWidth();
    private static final int SCREEN_HEIGHT = (int) screenSize.getHeight();
    public static int getScreenWidth(){
        return SCREEN_WIDTH;
    }
    public static int getScreenHeight(){
        return SCREEN_HEIGHT;
    }

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            System.out.println("Start");
            String url = "jdbc:sqlite:database\\iepCipher.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected");
//            CreateAccountController create = new CreateAccountController();
            //LoginPageController login = new LoginPageController();
//            EditAccountController edit = new EditAccountController();
//            create.registerTeacher("Devin","Security", "random6@gmail.com","password",1,"password1", 2, "password2");
//            create.registerAccount("Devin","Gundry","dgundry1@gmail.com","password");
//            edit.changePassword("dgundry1@gmail.com","password1","password","password" );
//            edit.changePassword("something@gmail.com","wefef","we","we");
//            System.out.println(login.loginToAccount("something@gmail.com","hello5"));
//            create.registerAccount("Encrypt", "Last","something2@gmail.com","hello");

            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            if (OSUtils.getOS().equals(OSUtils.OS.WINDOWS)) {
                new LoginPageController(new LoginPageView(OSUtils.OS.WINDOWS));
            } else {
                new LoginPageController(new LoginPageView(OSUtils.OS.MAC));
            }

           // System.out.println(login.loginToAccount("something@gmail.com","hello5"));
//            create.registerAccount("Encrypt", "Last","something@gmail.com","hello");
//            create.registerAccount("Encrypt", "Last","something@gmail.com","hello2");


        } catch (SQLException
                | ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
