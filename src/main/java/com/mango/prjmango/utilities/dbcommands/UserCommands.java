package com.mango.prjmango.utilities.dbcommands;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.Encryption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All database commands in this class pertain to retrieving or updating data for the particular user.
 */
public class UserCommands {

    private UserCommands() {
        throw new IllegalStateException("Utility class");
    }

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

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, enteredEmail);
            statement.setString(2, Encryption.encrypt(Arrays.toString(enteredPassword)));
            ResultSet resultSet = statement.executeQuery();
            count = resultSet.getInt(1);
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * Retrieves the {@code teacher_id} value in the database.
     *
     * @param email the users email
     * @return the {@code teacher_id} value in the database
     */
    public static int getTeacherId(String email) {
        int result = -1;
        String sql = "SELECT teacher_id FROM teacher WHERE email = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.getInt(1);
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Updates the user's personal details.
     *
     * @param firstName the new first name
     * @param lastName  the new last name
     * @param email     the new email
     * @param teacherId the teacherId of the user to update
     */
    public static void updateUserDetails(String firstName, String lastName, String email, int teacherId) {
        String sql = "UPDATE teacher SET first_name = ?, last_name = ?, email = ? WHERE teacher_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setInt(4, teacherId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Updates the user's password to the new one.
     *
     * @param newPassword the new password
     */
    public static void updateUserPassword(char[] newPassword) {
        String sql = "UPDATE teacher SET password = ? WHERE teacher_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, Encryption.encrypt(Arrays.toString(newPassword)));
            statement.setInt(2, LoggedInUser.getTeacherId());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Updates the user's password to the new one.
     *
     * @param newPassword the new password
     */
    public static void updateUserPassword(char[] newPassword, String email) {
        String sql = "UPDATE teacher SET password = ? WHERE email = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, Encryption.encrypt(Arrays.toString(newPassword)));
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Retrieves the encrypted password of a user based off the specific {@code teacherId}
     *
     * @param teacherId the teacherId you want to the password for
     * @return a {@code String} which contains the encrypted version of the user's password
     */
    public static String getUserPassword(int teacherId) {
        String sql = "SELECT password FROM teacher WHERE teacher_id = ?;";
        String result = "";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacherId);

            ResultSet resultSet = statement.executeQuery();
            result = resultSet.getString(1);
            resultSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Retrieves the first name, last name, and email based off the {@code teacherId}.
     *
     * @param teacherId the specific {@code teacherId}
     * @return a {@link List} of the user's details based off the {@code teacherId}
     */
    public static List<String> getUserDetails(int teacherId) {
        String sql = "SELECT first_name, last_name, email FROM teacher WHERE teacher_id = ?;";
        List<String> userDetails = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacherId);
            ResultSet resultSet = statement.executeQuery();
            userDetails.add(resultSet.getString(1));
            userDetails.add(resultSet.getString(2));
            userDetails.add(resultSet.getString(3));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userDetails;
    }

    /**
     * Retrieves the specific {@code question_id}'s that the user had set when their
     * account was created.
     *
     * @param teacherId the specific {@code teacherId}
     * @return a {@link List} of {@link Integer}'s that contain the indexes
     */
    public static List<Integer> getUserQuestionIndexes(int teacherId) {
        String sql = "SELECT question_id FROM questions WHERE teacher_id = ?;";
        List<Integer> indexes = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacherId);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            do {
                indexes.add(resultSet.getInt("question_id"));
            } while (resultSet.next());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return indexes;
    }
}
