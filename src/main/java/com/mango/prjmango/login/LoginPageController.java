package com.mango.prjmango.login;

import com.mango.prjmango.Main;
import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.createaccount.CreateAccountController;
import com.mango.prjmango.createaccount.CreateAccountView;
import com.mango.prjmango.editaccount.EditAccountController;
import com.mango.prjmango.editaccount.EditAccountView;
import com.mango.prjmango.forgotpassword.email.EmailController;
import com.mango.prjmango.forgotpassword.email.EmailView;
import com.mango.prjmango.login.listeners.EmailTextFieldListener;
import com.mango.prjmango.login.listeners.PasswordTextFieldListener;
import com.mango.prjmango.mainloginpage.MainLoginView;
import com.mango.prjmango.teacher.TeacherController;
import com.mango.prjmango.teacher.TeacherView;
import com.mango.prjmango.utilities.Encryption;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPageController {

    public LoginPageController(LoginPageView loginPageView) {
        JTextField emailTextField = loginPageView.getEmailText();
        JPasswordField passwordField = loginPageView.getPasswordText();

        emailTextField.addFocusListener(new EmailTextFieldListener(emailTextField, "Email"));
        passwordField.addFocusListener(new PasswordTextFieldListener(passwordField, "Password"));

        loginPageView.getLoginButton().addActionListener(new LoginButtonActionListener(loginPageView));
        loginPageView.getLoginButton().addMouseListener(new ButtonMouseListener(loginPageView.getLoginButton()));

        loginPageView.getForgotPasswordButton().addActionListener(new ForgotPasswordActionListener());
        loginPageView.getForgotPasswordButton().addMouseListener(new ButtonMouseListener(
                loginPageView.getForgotPasswordButton()));

        loginPageView.getCreateAccountButton().addActionListener(new CreateAccountButtonActionListener());
        loginPageView.getCreateAccountButton().addMouseListener(new ButtonMouseListener(
                loginPageView.getCreateAccountButton()));

    }

    private static class LoginButtonActionListener implements ActionListener {
        private final LoginPageView view;

        public LoginButtonActionListener(LoginPageView view) {
            this.view = view;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getEmailText().getText().equals("") && !view.getPasswordText().getText().equals("")) {
                System.out.println(view.getEmailText().getText() + ":" + view.getPasswordText().getText());
                if (loginToAccount(view.getEmailText().getText(), view.getPasswordText().getText())) {
                    System.out.println("Logged in");
                    EditAccountView edit = new EditAccountView();
                    new EditAccountController(edit);
                    MainFrame.setTeacherView(edit);
//                    TeacherView teacherView = new TeacherView();
//                    new TeacherController(teacherView);


                } else {
                    System.out.println("Try Again");
                    JOptionPane.showMessageDialog(
                            MainLoginView.getLoginWindow(),
                            "Enter a Valid Password.",
                            "INVALID",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Please input a email and password");
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Enter a Valid Email and/or Password.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);

            }
        }

        public boolean loginToAccount(String email, String password) {
            boolean result = false;
            String sql = "SELECT email, password FROM teacher WHERE email = ? AND password = ?;";
            try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, Encryption.encryptPassword(password));
                ResultSet resultSet = statement.executeQuery();
                result = resultSet.next();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return result;
        }
    }

    private static class ForgotPasswordActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            EmailView emailView = new EmailView();
            new EmailController(emailView);
            MainLoginView.setActivePanel(emailView);
        }
    }

    private static class CreateAccountButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateAccountView createAccountView = new CreateAccountView();
            new CreateAccountController(createAccountView);
            MainFrame.setActivePanel(createAccountView);
        }
    }
}
