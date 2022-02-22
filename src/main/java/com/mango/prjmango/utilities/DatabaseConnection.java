package com.mango.prjmango.utilities;

import java.net.URL;
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
            SQLiteConfig config = new SQLiteConfig();
            config.setReadOnly(false);
//            String url = "jdbc:sqlite:\\database\\\\iepCipher.db";
//            URL url = DatabaseConnection.class.getResource("/database/iepCipher.db");
            String username = "doadmin";
            String password = "X0Y5SvMlvvOun0NI";
            connection = DriverManager.getConnection("jdbc:sqlite::resource:database/iepCipher.db",config.toProperties());
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
