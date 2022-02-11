package com.mango.prjmango.utilities;

import com.mango.prjmango.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Vector;

/**
 * This class holds all database commands that the application uses
 * to interact with the database.
 */
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * Retrieves all dropdown security questions.
     *
     * @return a {@link Vector} of {@link String}'s that contain the dropdown security questions
     */
    public static Vector<String> getDropDownQuestions() {
        String sql = "SELECT question FROM question;";
        Vector<String> securityQuestionList = new Vector<>();

        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            do {
                securityQuestionList.add(resultSet.getString(1));
            } while (resultSet.next());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return securityQuestionList;
    }
}
