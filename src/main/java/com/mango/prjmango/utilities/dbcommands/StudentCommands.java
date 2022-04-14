package com.mango.prjmango.utilities.dbcommands;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentCommands {
    public static int getTotalAssignmentsFromStudent(int studentID){
        String sql = "SELECT COUNT(*) FROM assignment WHERE student_id = ?;";
        int totalAssignments = 0;

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, studentID);
            totalAssignments = statement.executeQuery().getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return totalAssignments;
    }

    public static void deleteStudentAndAssignments(int studentID){
        deleteAllAssignmentsFromStudent(studentID);
        deleteStudent(studentID);
    }
    private static void deleteAllAssignmentsFromStudent(int studentID){
        String sql = "DELETE FROM assignment WHERE student_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, studentID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private static void deleteStudent(int studentID){
        String sql = "DELETE FROM student WHERE student_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, studentID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static String getStudentFullName(int studentID){
        String sql = "SELECT first_name, last_name FROM student WHERE student_id = ?;";
        String studentName = "";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, studentID);
            studentName = statement.executeQuery().getString(2) + ", " + statement.executeQuery().getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return studentName;
    }
    public static void removeStudentAssignment(int assignmentID){
        String sql = "DELETE FROM assignment WHERE assignment_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, assignmentID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateStudent(int studentID, String firstName, String lastName, String grade, String bio){
        String sql = "UPDATE student SET first_name = ?, last_name = ?, grade = ?, bio = ? WHERE student_id = ?;";

        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, grade);
            statement.setString(4, bio);
            statement.setInt(5,studentID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
