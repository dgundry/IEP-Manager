package com.mango.prjmango.editaccount;


import com.mango.prjmango.components.listeners.TextFieldFocusListener;
import com.mango.prjmango.student.CreateAStudentController;
import com.mango.prjmango.student.CreateAStudentView;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.Encryption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditAccountController {

    public EditAccountController(EditAccountView editAccountView){
//        editAccountView.getCreateStudentButton().addActionListener(new CreateStudentButtonActionListener());
//        editAccountView.getMyAccountButton().addActionListener(new MyAccountButtonActionListener());
        JTextField currentPasswordTextField = editAccountView.getCurrentPassText();
        JTextField newPasswordTextField = editAccountView.getNewPassText();
        JTextField confirmNewPasswordTextField = editAccountView.getConfirmNewPassText();

        currentPasswordTextField.addFocusListener(new TextFieldFocusListener(currentPasswordTextField, "Password"));
        newPasswordTextField.addFocusListener(new TextFieldFocusListener(newPasswordTextField,"Password"));
        confirmNewPasswordTextField.addFocusListener(new TextFieldFocusListener(confirmNewPasswordTextField, "Password"));

        JTextField currentEmailTextField = editAccountView.getCurrentEmailText();
        JTextField newEmailTextField = editAccountView.getNewEmailText();
        JTextField confirmPasswordTextField = editAccountView.getConfirmPassText();

        currentEmailTextField.addFocusListener(new TextFieldFocusListener(currentEmailTextField, "Email"));
        newEmailTextField.addFocusListener(new TextFieldFocusListener(newEmailTextField, "Email"));
        confirmPasswordTextField.addFocusListener(new TextFieldFocusListener(confirmPasswordTextField, "Password"));


    }


    private static class CreateStudentButtonActionListener implements ActionListener {


        public CreateStudentButtonActionListener(){

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            CreateAStudentView createAStudent = new CreateAStudentView();
            new CreateAStudentController(createAStudent);
            System.out.println("Clicked on Create A student");
        }
    }
    private static class MyAccountButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            EditAccountView editAccountView = new EditAccountView();
            new EditAccountController(editAccountView);
            System.out.println("Clicked on EditAccount");
        }
    }

    public void changePassword(String email, String oldPassword, String newPassword1, String newPassword2){
        if(doPasswordsMatch(newPassword1,newPassword2)){
            if(isValidEmail(email)) {
                int teacher_id = getTeacher_id(email);
                if (correctOriginalPassword(teacher_id, oldPassword)) {
                    String sql = "UPDATE teacher SET password = ? WHERE teacher_id = " + teacher_id + ";";
                    try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
                        statement.setString(1, Encryption.encryptPassword(newPassword1));
                        statement.executeUpdate();
                        System.out.println("Password Changed.");
                    } catch (Exception e) {
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
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sqlQuery)) {
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
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
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
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(teacher_id));
            statement.setString(2, Encryption.encryptPassword(password));
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
