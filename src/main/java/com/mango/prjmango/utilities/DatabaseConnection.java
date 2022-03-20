package com.mango.prjmango.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import org.sqlite.SQLiteConfig;

/**
 * Establishes the connection to the database.
 */
public class DatabaseConnection implements Runnable {

    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    public static final String TESTING_DB = "jdbc:sqlite::resource:database/testing.db";

    @Getter private static Connection connection = null;

    /**
     * Connects to the desired database url that's passed in.
     * Note: Mainly used for testing purposes.
     *
     * @param database the database url
     */
    public static void setDatabase(String database) {
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.setReadOnly(false);
            connection = DriverManager.getConnection(database, config.toProperties());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Connects the application to the database.
     */
    @Override
    public void run() {
        setDatabase("jdbc:sqlite::resource:database/iepCipher.db");
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
