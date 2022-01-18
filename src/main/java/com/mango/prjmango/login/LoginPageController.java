package com.mango.prjmango.login;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.components.listeners.TextFieldFocusListener;
import com.mango.prjmango.createaccount.CreateAccountController;
import com.mango.prjmango.createaccount.CreateAccountView;
import com.mango.prjmango.forgotpassword.email.EmailController;
import com.mango.prjmango.forgotpassword.email.EmailView;
import com.mango.prjmango.mainloginpage.MainLoginView;
import com.mango.prjmango.teacher.TeacherController;
import com.mango.prjmango.teacher.TeacherView;
import com.mango.prjmango.utilities.Encryption;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginPageController {

    public LoginPageController(LoginPageView loginPageView) {
        loginPageView.getLoginButton().addActionListener(new LoginButtonActionListener(loginPageView));
        loginPageView.getLoginButton().addMouseListener(new ButtonMouseListener(loginPageView.getLoginButton()));

        loginPageView.getForgotPasswordButton().addActionListener(new ForgotPasswordActionListener());
        loginPageView.getForgotPasswordButton().addMouseListener(new ButtonMouseListener(
                loginPageView.getForgotPasswordButton()));

        loginPageView.getCreateAccountButton().addActionListener(new CreateAccountButtonActionListener());
        loginPageView.getCreateAccountButton().addMouseListener(new ButtonMouseListener(
                loginPageView.getCreateAccountButton()));

        loginPageView.getEmailText().addFocusListener(new TextFieldFocusListener(
                        loginPageView.getEmailText(),
                        loginPageView.getEmailText().getText()));
        loginPageView.getPasswordText().addMouseListener(new PasswordMouseListener(loginPageView));

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
                    TeacherView teacherView = new TeacherView();
                    new TeacherController(teacherView);


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
            MainLoginView.setActivePanel(createAccountView);
        }
    }

    private static class PasswordMouseListener implements MouseListener {

        private final LoginPageView loginPageView;

        public PasswordMouseListener(LoginPageView loginPageView) { this.loginPageView = loginPageView; }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(loginPageView.getPasswordText().getText().equals("Password")){
                loginPageView.getPasswordText().setText("");
                //loginPageView.getPasswordText().setEchoChar('•');

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
