package com.mango.app.forgotpassword.password;

import com.mango.app.Main;
import com.mango.app.components.ButtonMouseListener;
import com.mango.app.createaccount.Register;
import com.mango.app.createaccount.User;
import com.mango.app.createaccount.password.PasswordController;
import com.mango.app.createaccount.password.PasswordView;
import com.mango.app.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.app.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.app.login.LoginPageController;
import com.mango.app.login.LoginPageView;
import com.mango.app.mainloginpage.MainLoginView;
import com.mango.app.utilities.Encryption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePasswordController {
    public ChangePasswordController(ChangePasswordView view) {
//        view.getBackButton().addActionListener(new PasswordController.BackButtonActionListener(view, user));
//        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getChangePasswordButton().addActionListener(new ChangePasswordController.ChangePasswordButtonActionListener(view));
        view.getChangePasswordButton().addMouseListener(new ButtonMouseListener(view.getChangePasswordButton()));
    }

//    private static class BackButtonActionListener implements ActionListener {
//
//        public BackButtonActionListener() {
//
//        }
//        /**
//         * Invoked when an action occurs.
//         *
//         * @param e the event to be processed
//         */
//
//        public void actionPerformed(ActionEvent e){
//
//        }
//    }

    private static class ChangePasswordButtonActionListener implements ActionListener {
        private final ChangePasswordView view;
        public ChangePasswordButtonActionListener(ChangePasswordView view){
            this.view = view;
        }
        /**
         * Invoked when an action occurs.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            final String MESSAGE_TITLE = "Invalid!";
            //Add user to database
            //Verify all input
            String password = view.getPasswordText().getText();
            String passwordConfirmed = view.getConfirmPasswordText().getText();
            if (!password.equals(passwordConfirmed)){
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Passwords are not matching.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else if (view.getPasswordText().getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Please enter a valid Password.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
            else if (view.getConfirmPasswordText().getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Please confirm your Password.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else {
                Encryption encryption = new Encryption();
                String sql = "UPDATE teacher SET password = ? WHERE teacher_id = ?;";
                try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
                    statement.setString(1, encryption.encryptPassword(view.getConfirmPasswordText().getText()));
                    statement.setString(2, String.valueOf(view.getTeacher_id()));
                    int result = statement.executeUpdate();
                    if(result == 1) {
                        JOptionPane.showMessageDialog(
                                MainLoginView.getLoginWindow(),
                                "Password Successfully Changed.",
                                "SUCCESS",
                                JOptionPane.ERROR_MESSAGE);
                        LoginPageView loginPageView = new LoginPageView();
                        new LoginPageController(loginPageView);
                        MainLoginView.setActivePanel(loginPageView.getLoginPanel());
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
}
