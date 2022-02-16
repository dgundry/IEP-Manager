package com.mango.prjmango.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;

/**
 * Establishes the connection to the database.
 */
public class DatabaseConnection implements Runnable {

    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    @Getter private static final String TESTING_DB = "jdbc:sqlite:database/testing.db";

    @Getter private static Connection connection = null;

    /**
     * Connects to the desired database url that's passed in.
     * Note: Mainly used for testing purposes.
     *
     * @param database the database url
     */
    public static void setDatabase(String database) {
        try {
            connection = DriverManager.getConnection(database);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Connects the application to the database.
     */
    @Override
    public void run() {
        try {
            String url = "jdbc:mysql://iepcipher-do-user-9861785-0.b.db.ondigitalocean.com:25060/";
            String username = "doadmin";
            String password = "X0Y5SvMlvvOun0NI";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Closes the connection to the database.
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
