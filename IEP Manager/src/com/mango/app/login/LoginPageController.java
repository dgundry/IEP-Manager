package com.mango.app.login;

import com.mango.app.Main;
import com.mango.app.utilities.Encryption;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginPageController {

    private static Encryption encryption = new Encryption();

    private LoginPageView loginPageView;

    public LoginPageController(LoginPageView view){
        this.loginPageView = view;
        view.getLoginButton().addActionListener(new LoginButtonActionListener(loginPageView));
        view.getLoginButton().addMouseListener(new LoginButtonMouseListener(loginPageView));

        view.getForgotPasswordButton().addActionListener(new ForgotPasswordActionListener(loginPageView));
        view.getForgotPasswordButton().addMouseListener(new ForgotPasswordButtonMouseListener(loginPageView));

        view.getCreateAccountButton().addActionListener(new CreateAccountActionListener(loginPageView));
        view.getCreateAccountButton().addMouseListener(new CreateAccountButtonMouseListener(loginPageView));
    }
    private static class LoginButtonActionListener implements ActionListener{
        private final LoginPageView view;
        public LoginButtonActionListener(LoginPageView view){
            this.view = view;
        }
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!view.getEmailText().getText().equals("") && !view.getPasswordText().getText().equals("")){
                System.out.println(view.getEmailText().getText() + ":" + view.getPasswordText().getText());
                if(loginToAccount(view.getEmailText().getText(),view.getPasswordText().getText())){
                    System.out.println("Logged in");
                }else{
                    System.out.println("Try Again");
                }
            }else{
                System.out.println("Please input a email and password");
            }
        }
        public boolean loginToAccount(String email, String password){
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

    private static class LoginButtonMouseListener implements MouseListener {

        private final LoginPageView loginPageView;

        public LoginButtonMouseListener(LoginPageView loginPageView) {
            this.loginPageView = loginPageView;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            loginPageView.getLoginButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            loginPageView.getLoginButton().setFont(loginPageView.getLoginButton().getFont().deriveFont(Font.BOLD));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            loginPageView.getLoginButton().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            loginPageView.getLoginButton().setFont(loginPageView.getLoginButton().getFont().deriveFont(Font.PLAIN));
        }
    }

    private static class ForgotPasswordActionListener implements ActionListener {
        public ForgotPasswordActionListener(LoginPageView loginPageViewWindows) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Forgot Password Clicked");
        }
    }

    private static class ForgotPasswordButtonMouseListener implements MouseListener {

        private final LoginPageView loginPageView;

        public ForgotPasswordButtonMouseListener(LoginPageView loginPageView) {
            this.loginPageView = loginPageView;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            loginPageView.getForgotPasswordButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            loginPageView.getForgotPasswordButton().setFont(loginPageView.getForgotPasswordButton().getFont().deriveFont(Font.BOLD));

            Font font = loginPageView.getForgotPasswordButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            loginPageView.getForgotPasswordButton().setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            loginPageView.getForgotPasswordButton().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            loginPageView.getForgotPasswordButton().setFont(loginPageView.getForgotPasswordButton().getFont().deriveFont(Font.PLAIN));


            Font font = loginPageView.getForgotPasswordButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            loginPageView.getForgotPasswordButton().setFont(font.deriveFont(attributes));
        }
    }

    private static class CreateAccountActionListener implements ActionListener {
        public CreateAccountActionListener(LoginPageView loginPageViewWindows) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Create Account Clicked");
        }
    }

    private static class CreateAccountButtonMouseListener implements MouseListener {

        private final LoginPageView loginPageView;

        public CreateAccountButtonMouseListener(LoginPageView loginPageView) {
            this.loginPageView = loginPageView;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            loginPageView.getCreateAccountButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            loginPageView.getCreateAccountButton().setFont(loginPageView.getCreateAccountButton().getFont().deriveFont(Font.BOLD));

            Font font = loginPageView.getCreateAccountButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            loginPageView.getCreateAccountButton().setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            loginPageView.getCreateAccountButton().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            loginPageView.getCreateAccountButton().setFont(loginPageView.getCreateAccountButton().getFont().deriveFont(Font.PLAIN));

            Font font = loginPageView.getCreateAccountButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            loginPageView.getCreateAccountButton().setFont(font.deriveFont(attributes));
        }
    }
}