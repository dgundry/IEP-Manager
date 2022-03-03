package com.mango.prjmango.utilities;

import com.mango.prjmango.LoggedInUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, enteredEmail);
            statement.setString(2, Encryption.encryptPassword(Arrays.toString(enteredPassword)));
            ResultSet resultSet = statement.executeQuery();
            count = resultSet.getInt(1);
            resultSet.close();
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
    public static List<String> getDropDownQuestions() {
        String sql = "SELECT question FROM question;";
        List<String> securityQuestionList = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            do {
                securityQuestionList.add(resultSet.getString(1));
            } while (resultSet.next());
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        securityQuestionList.remove(0);
        return securityQuestionList;
    }

    /**
     *
     * @param teacherID the
     * @return
     */
    public static int[] getQuestionIds(int teacherID) {
        int[] questionIds = new int[2];
        int index = 0;
        String sql = "SELECT question_id FROM questions WHERE teacher_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(teacherID));
            ResultSet resultSet = statement.executeQuery();
            do {
                if(index != 0) {
                    if (questionIds[0] != resultSet.getInt(1)) {
                        questionIds[index] = resultSet.getInt(1);
                    }
                } else {
                    questionIds[index] = resultSet.getInt(1);
                    index++;
                }
            } while (resultSet.next() && index <= 1);
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questionIds;
    }

    public static String[] getQuestionTexts(int[] questionIndexes) {
        String[] questionTexts = new String[2];
        int index = 0;
        String sql = "SELECT question FROM question WHERE (question_id = ? OR question_id = ?);";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(questionIndexes[0]));
            statement.setString(2, String.valueOf(questionIndexes[1]));
            ResultSet resultSet2 = statement.executeQuery();
            do {
                if (index != 0) {
                    if (questionTexts[0] != resultSet2.getString(1)) {
                        questionTexts[index] = resultSet2.getString(1);
                    }
                } else {
                    questionTexts[index] = resultSet2.getString(1);
                    index++;
                }
            } while (resultSet2.next() && index <= 1);
            resultSet2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questionTexts;
    }

    /**
     * Returns true or false if there is an email with that value in the database.
     *
     * @param email the email to check for
     * @return true if there is an email within the teachers table, false if there is not
     */
    public static boolean isEmailTaken(String email) {
        int count = 0;

        String sql = "SELECT COUNT(*) FROM teacher WHERE email = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            count = resultSet.getInt(1);
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return (count >= 1);
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

    public static boolean isSecurityQuestionsAnswersCorrect(
            int teacherId,
            int[] questionIndexes,
            String answer1,
            String answer2) {
        boolean hasFailed = false;
        String sql = "SELECT teacher_id, question_id, answer FROM questions WHERE (teacher_id = ? AND (question_id = ? OR question_id = ?));";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(teacherId));
            statement.setString(2, String.valueOf(questionIndexes[0]));
            statement.setString(3, String.valueOf(questionIndexes[1]));
            ResultSet resultSet = statement.executeQuery();
            do {
                if(resultSet.getInt(2) == questionIndexes[0]){
                    if (!Encryption.encryptPassword(answer1).equals(resultSet.getString(3))){
                        hasFailed = true;
                    }
                } else if (resultSet.getInt(2) == questionIndexes[1]) {
                    if (!Encryption.encryptPassword(answer2).equals(resultSet.getString(3))){
                        hasFailed = true;
                    }
                }
            } while (resultSet.next() && !hasFailed);
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasFailed;
    }

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
     *
     * @param teacherId the {@code teacher_id} value in the database
     * @return a {@link List} of {@link Integer}'s which contain the indexes in the questions
     */
    public static List<Integer> getUserSecurityQuestionIndexes(int teacherId) {
        String sql = "SELECT question_id FROM questions WHERE teacher_id = ?;";
        List<Integer> userDetails = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacherId);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            do {
                userDetails.add(resultSet.getInt("question_id"));
            } while (resultSet.next());

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userDetails;
    }

    public static String getUserSecurityQuestion(int questionId) {
        String sql = "SELECT question FROM question WHERE question_id = ?;";
        String question = "";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, questionId);

            ResultSet resultSet = statement.executeQuery();
            question = resultSet.getString(1);
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return question;
    }

    public static void updateUserDetails(String firstName, String lastName, String email) {
        String sql = "UPDATE teacher SET first_name = ?, last_name = ?, email = ? WHERE teacher_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setInt(4, LoggedInUser.getTeacherId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}