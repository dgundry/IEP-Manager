package com.mango.prjmango.student;

import com.mango.prjmango.utilities.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterStudent {

    public static boolean createStudent(Student student){
        boolean result = false;

        if(student.isValidField()){
            registerStudent(student.getFirstName(),
                    student.getLastName(),
                    student.getBio());
            result = true;
        }
        return result;
    }

    private static void registerStudent(String firstName, String lastName, String bio){
        String sql = "INSERT INTO student(first_name, last_name, bio) VALUES(?,?,?);";
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1,firstName);
            statement.setString(2, lastName);
            statement.setString(4, bio);
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
