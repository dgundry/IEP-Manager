package com.mango.prjmango.utilities;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.outlines.MathOutline;
import com.mango.prjmango.outlines.Outline;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.utilities.dbcommands.UserCommands;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class holds all database commands that the application uses
 * to interact with the database.
 */
public class DatabaseCommands {

    private static final Logger logger = Logger.getLogger(DatabaseCommands.class.getName());

    private DatabaseCommands() {
        throw new IllegalStateException("Utility class.");
    }

    /**
     * Deletes a {@link MathOutline} based off the specific ID.
     *
     * @param outlineId the specific outline ID
     */
    public static void deleteMathOutline(int outlineId) {
        String sql = "DELETE FROM math_outlines WHERE math_outline_id = ?;";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, outlineId);
            statement.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Deletes an {@link Outline} based off a specific ID.
     *
     * @param outlineId the specific outline ID
     */
    public static void deleteOutline(int outlineId){
        String sql = "DELETE FROM outlines WHERE outline_id = ?;";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, outlineId);
            statement.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    public static ArrayList<String> getAllOutlineNames() {
        ArrayList<String> outlines = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM outlines WHERE teacher_id = ?")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                outlines.add(rs.getString("outline"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
        return outlines;
    }

    public static void createMathOutline(MathOutline outline) {

        String sql = "INSERT INTO math_outlines(teacher_id, assignment_name, addition, subtraction, multiplication, division, numerator_min, numerator_max, denominator_min, denominator_max, wholeNumbers) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, LoggedInUser.getTeacherId());
            statement.setString(2, outline.getAssignmentName());
            statement.setInt(3, outline.getAdditionTotal());
            statement.setInt(4, outline.getSubtractionTotal());
            statement.setInt(5, outline.getMultiplicationTotal());
            statement.setInt(6, outline.getDivisionTotal());
            statement.setInt(7, outline.getNumeratorMin());
            statement.setInt(8, outline.getNumeratorMax());
            statement.setInt(9, outline.getDenominatorMin());
            statement.setInt(10, outline.getDenominatorMax());
            statement.setInt(11, outline.getWholeNumbers());
            statement.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    public static void createMathOutline(String assignmentName,int additionTotal, int subtractionTotal, int multiplicationTotal, int divisionTotal, int numeratorMin, int numeratorMax, int denominatorMin, int denominatorMax, int wholeNumbers) {
        String sql = "INSERT INTO math_outlines(teacher_id, assignment_name, addition, subtraction, multiplication, division, numerator_min, numerator_max, denominator_min, denominator_max, wholeNumbers) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, LoggedInUser.getTeacherId());
            statement.setString(2, assignmentName);
            statement.setInt(3, additionTotal);
            statement.setInt(4, subtractionTotal);
            statement.setInt(5, multiplicationTotal);
            statement.setInt(6, divisionTotal);
            statement.setInt(7, numeratorMin);
            statement.setInt(8, numeratorMax);
            statement.setInt(9, denominatorMin);
            statement.setInt(10, denominatorMax);
            statement.setInt(11, wholeNumbers);
            statement.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Adds an {@link Outline} to the database.
     *
     * @param assignmentName the name of the assignment
     * @param maximumPoints  the maximum points of the assignment
     */
    public static void createOutline(String assignmentName, int maximumPoints) {
        String sql = "INSERT INTO outlines(teacher_id, assignment_name, total_points) VALUES (?, ?, ?);";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, LoggedInUser.getTeacherId());
            statement.setString(2, assignmentName);
            statement.setInt(3, maximumPoints);
            statement.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Adds a new entry to the {@code teacher} table within the database.
     *
     * @param user     the {@link User} object that contains other data
     * @param password the user's password
     * @return the number of rows that were affected by this INSERT command
     */
    public static int addNewTeacher(User user, char[] password) {
        String sql = "INSERT INTO teacher(first_name, last_name, email, password) VALUES (?, ?, ?, ?);";
        int result = 0;

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, Encryption.encrypt(Arrays.toString(password)));
            result = statement.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        return result;
    }

    /**
     * Adds the newly registered user's security questions and answers to the questions table
     * in the database.
     *
     * @param user       the {@link User} object so we can access the {@code teacherId}
     * @param questionId the question_id the user selected
     * @param answer     the users answer to the question they selected
     * @return the number of rows that were affected by this INSERT command
     */
    public static int registerSecurityAnswer(User user, int questionId, String answer) {
        int teacherId = UserCommands.getTeacherId(user.getEmail());
        int result = 0;

        String sql = "INSERT INTO questions(teacher_id, question_id, answer) VALUES(?, ?, ?);";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacherId);
            statement.setInt(2, questionId);
            statement.setString(3, Encryption.encrypt(answer));
            result = statement.executeUpdate();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        return result;
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
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        securityQuestionList.remove(0);
        return securityQuestionList;
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
            logger.log(Level.SEVERE, ex.getMessage());
        }

        return (count >= 1);
    }

    /**
     * Adds a new {@link Student} to the database.
     *
     * @param firstName the student's first name
     * @param lastName  the student's last name
     * @param grade     the student's grade
     * @param bio       the student's bio
     */
    public static void registerStudent(String firstName, String lastName, String grade, String bio){
        String sql = "INSERT INTO student(teacher_id, first_name, last_name, grade, bio) VALUES(?,?,?,?,?);";
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, LoggedInUser.getTeacherId());
            statement.setString(2,firstName);
            statement.setString(3, lastName);
            statement.setString(4, grade);
            statement.setString(5, bio);
            statement.executeUpdate();
        } catch(SQLException ex){
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Retrieves the security question that corresponds to the passed in index.
     *
     * @param index the index of the security question
     * @return a {@link String} representation of the security question
     */
    public static String getSecurityQuestion(int index) {
        String sql = "SELECT question FROM question WHERE question_id = ?;";
        String question = "";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, index);

            ResultSet resultSet = statement.executeQuery();
            question = resultSet.getString(1);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        return question;
    }

    /**
     * Gets the answers of the security questions based off the specific {@code teacherId}.
     *
     * @param teacherId the specific {@code teacherId}
     * @return a {@link List} of {@link String}'s that contain the answers that are encrypted
     */
    public static List<String> getSecurityQuestionAnswers(int teacherId) {
        String sql = "SELECT answer FROM questions WHERE teacher_id = ?;";
        List<String> answers = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacherId);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            do {
                answers.add(resultSet.getString(1));
            } while (resultSet.next());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        return answers;
    }
}
