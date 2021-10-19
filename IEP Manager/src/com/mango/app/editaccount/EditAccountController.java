package com.mango.app.editaccount;

import com.mango.app.Main;
import com.mango.app.utilities.Encryption;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditAccountController {
    Encryption encryption = new Encryption();
    public EditAccountController(EditAccountView view){
    }
    public EditAccountController(){

    }
    public void changePassword(String email, String oldPassword, String newPassword1, String newPassword2){
        if(doPasswordsMatch(newPassword1,newPassword2)){
            if(isValidEmail(email)) {
                int teacher_id = getTeacher_id(email);
                if (correctOriginalPassword(teacher_id, oldPassword)) {
                    String sql = "UPDATE teacher SET password = ? WHERE teacher_id = " + teacher_id + ";";
                    try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
                        statement.setString(1, encryption.encryptPassword(newPassword1));
                        statement.executeUpdate();
                        System.out.println("Password Changed.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Old Password is Incorrect");
                }
            }else{
                System.out.println("No record of that email.");
            }
        }else{
            System.out.println("New Passwords do not match.");
        }
    }
    private boolean isValidEmail(String email){
        boolean result = false;
        String sqlQuery = "SELECT email FROM teacher WHERE email = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sqlQuery)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    private int getTeacher_id(String email){
        int result = -1;
        String sql = "SELECT teacher_id FROM teacher WHERE email = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            result = Integer.parseInt(resultSet.getString(1));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
    private boolean doPasswordsMatch(String first, String second){
        return first.equals(second);
    }
    private boolean correctOriginalPassword(int teacher_id, String password){
        boolean result = false;
        String sql = "SELECT password FROM teacher WHERE teacher_id = ? AND password = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(teacher_id));
            statement.setString(2, encryption.encryptPassword(password));
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
