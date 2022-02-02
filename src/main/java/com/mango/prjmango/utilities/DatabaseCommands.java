package com.mango.prjmango.utilities;

import com.mango.prjmango.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class DatabaseCommands {

    /**
     * Finds if there is an existing user within the database.
     *
     * @param enteredEmail    the email the user entered
     * @param enteredPassword the password the user entered
     * @return 1 if there is a user, 0 if there is no existing user
     */
    public static int isValidUser(String enteredEmail, char[] enteredPassword) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM teacher WHERE email = ? AND password = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, enteredEmail);
            statement.setString(2, Encryption.encryptPassword(Arrays.toString(enteredPassword)));
            ResultSet resultSet = statement.executeQuery();
            count = resultSet.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return count;
    }
}
