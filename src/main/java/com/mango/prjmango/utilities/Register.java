package com.mango.prjmango.utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Register {

    public boolean createUser(User user){
        boolean result = false;

        if(user.isValidFields() && !isEmailTaken(user.getEmail())) {
            registerTeacher(user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPassword1(),
                    user.getSecurityQ1(),
                    user.getSecurityA1(),
                    user.getSecurityQ2(),
                    user.getSecurityA2());
            result = true;
        }
        return result;
    }
    private void registerSecurityQuestions(int teacher_id, int question_id_one, String answer_one, int question_id_two, String answer_two){
        if(question_id_one != question_id_two){
            registerSecurityAnswer(teacher_id, question_id_one, answer_one);
            registerSecurityAnswer(teacher_id, question_id_two, answer_two);
        }
    }
    private void registerSecurityAnswer(int teacher_id, int question_id, String answer){
        String sql = "INSERT INTO questions(teacher_id, question_id, answer) VALUES(?,?,?);";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacher_id);
            statement.setInt(2, question_id);
            statement.setString(3, Encryption.encryptPassword(answer));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void registerTeacher(String firstName, String lastName, String email, char[] password, int question_id_one, String answer_one, int question_id_two, String answer_two){
        String sql = "INSERT INTO teacher(first_name,last_name,email,password) VALUES(?,?,?,?);";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, Encryption.encryptPassword(Arrays.toString(password)));
            statement.executeUpdate();
            int teacher_id = getTeacher_id(email);
            registerSecurityQuestions(teacher_id, question_id_one, answer_one, question_id_two, answer_two);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int getTeacher_id(String email){
        int result = -1;
        String sql = "SELECT teacher_id FROM teacher WHERE email = ?;";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
    public boolean isEmailTaken(String email){
        boolean result = false;
        String sql = "SELECT email FROM teacher WHERE email = ?;";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}