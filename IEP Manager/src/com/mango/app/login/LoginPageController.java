package com.mango.app.login;

import com.mango.app.Main;
import com.mango.app.components.*;
import com.mango.app.createaccount.CreateAccountController;
import com.mango.app.createaccount.CreateAccountView;
import com.mango.app.forgotpassword.securityquestions.*;
import com.mango.app.mainloginpage.MainLoginView;
import com.mango.app.utilities.Encryption;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageController {

    private static Encryption encryption = new Encryption();

    public LoginPageController(LoginPageView loginPageView) {
        loginPageView.getLoginButton().addActionListener(new LoginButtonActionListener(loginPageView));
        loginPageView.getLoginButton().addMouseListener(new ButtonMouseListener(loginPageView.getLoginButton()));

        loginPageView.getForgotPasswordButton().addActionListener(new ForgotPasswordActionListener());
        loginPageView.getForgotPasswordButton().addMouseListener(new ButtonMouseListener(loginPageView.getForgotPasswordButton()));

        loginPageView.getCreateAccountButton().addActionListener(new CreateAccountButtonActionListener());
        loginPageView.getCreateAccountButton().addMouseListener(new ButtonMouseListener(loginPageView.getCreateAccountButton()));
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
                } else {
                    System.out.println("Try Again");
                }
            } else {
                System.out.println("Please input a email and password");
            }
        }

        public boolean loginToAccount(String email, String password) {
            boolean result = false;
            String sql = "SELECT email, password FROM teacher WHERE email = ? AND password = ?;";
            try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, encryption.encryptPassword(password));
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
            SecurityQuestionsPageTwoView securityQuestionPageTwoView = new SecurityQuestionsPageTwoView();
            new SecurityQuestionsTwoController(securityQuestionPageTwoView);
            MainLoginView.setActivePanel(securityQuestionPageTwoView.getSecurityQuestionsPanel());
        }
    }

    private static class CreateAccountButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateAccountView createAccountView = new CreateAccountView();
            new CreateAccountController(createAccountView);
            MainLoginView.setActivePanel(createAccountView.getCreateAccountPanel());
        }
    }
}
