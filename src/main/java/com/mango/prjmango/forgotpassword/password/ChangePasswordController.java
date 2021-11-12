package com.mango.prjmango.forgotpassword.password;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.mainloginpage.MainLoginView;
import com.mango.prjmango.utilities.Encryption;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ChangePasswordController {
    public ChangePasswordController(ChangePasswordView view) {
        view.getCancelButton().addActionListener(new ChangePasswordController.CancelButtonActionListener());
        view.getCancelButton().addMouseListener(new ButtonMouseListener(view.getCancelButton()));

        view.getChangePasswordButton().addActionListener(new ChangePasswordController.ChangePasswordButtonActionListener(view));
        view.getChangePasswordButton().addMouseListener(new ButtonMouseListener(view.getChangePasswordButton()));
    }

    private static class CancelButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */

        public void actionPerformed(ActionEvent e){
            LoginPageView loginPageView = new LoginPageView();
            new LoginPageController(loginPageView);
            MainLoginView.setActivePanel(loginPageView);
        }
    }

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
                String sql = "UPDATE teacher SET password = ? WHERE teacher_id = ?;";
                try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
                    statement.setString(1, Encryption.encryptPassword(view.getConfirmPasswordText().getText()));
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
                        MainLoginView.setActivePanel(loginPageView);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
}
