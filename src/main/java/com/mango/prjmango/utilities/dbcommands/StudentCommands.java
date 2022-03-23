package com.mango.prjmango.utilities.dbcommands;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentCommands {
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
