package com.mango.app.createaccount;

import com.mango.app.Main;
import com.mango.app.utilities.Encryption;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateAccountController {
    Encryption encrytion = new Encryption();
    public CreateAccountController(CreateAccountView view){

    }
    public CreateAccountController(){

    }
    public void registerSecurityQuestions(int teacher_id, int question_id_one, String answer_one, int question_id_two, String answer_two){
        if(question_id_one != question_id_two){
            registerSecurityAnswer(teacher_id, question_id_one, answer_one);
            registerSecurityAnswer(teacher_id, question_id_two, answer_two);
        }
    }
    private void registerSecurityAnswer(int teacher_id, int question_id, String answer){
        String sql = "INSERT INTO questions(teacher_id, question_id, answer) VALUES(?,?,?);";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setInt(1, teacher_id);
            statement.setInt(2, question_id);
            statement.setString(3, Encryption.encryptPassword(answer));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void registerTeacher(String firstName, String lastName, String email, String password, int question_id_one, String answer_one, int question_id_two, String answer_two){
        if(!isEmailTaken(email)) {
            String sql = "INSERT INTO teacher(first_name,last_name,email,password) VALUES(?,?,?,?);";
            try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, Encryption.encryptPassword(password));
                statement.executeUpdate();
                int teacher_id = getTeacher_id(email);
                registerSecurityQuestions(teacher_id, question_id_one, answer_one, question_id_two, answer_two);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Email has been taken.");
        }
    }
    private int getTeacher_id(String email){
        int result = -1;
        String sql = "SELECT teacher_id FROM teacher WHERE email = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
    private boolean isEmailTaken(String email){
        boolean result = false;
        String sql = "SELECT email FROM teacher WHERE email = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
