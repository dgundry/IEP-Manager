package com.mango.app.createaccount;

import com.mango.app.Main;
import com.mango.app.login.*;
import com.mango.app.mainloginpage.*;
import com.mango.app.utilities.Encryption;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CreateAccountController {

    private CreateAccountView createAccountView;

    public CreateAccountController(CreateAccountView view) {
        this.createAccountView = view;
        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new BackButtonMouseListener(view));

        view.getNextButton().addActionListener(new NextButtonActionListener());
        view.getNextButton().addMouseListener(new NextButtonMouseListener(view));
    }

    private static class BackButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginPageView loginPageView = new LoginPageView();
            new LoginPageController(loginPageView);
            MainLoginView.setActivePanel(loginPageView.getLoginPanel());
        }
    }

    private static class BackButtonMouseListener implements MouseListener {

        private final CreateAccountView view;

        private BackButtonMouseListener(CreateAccountView view) {
            this.view = view;
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
            view.getBackButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getBackButton().setFont(view.getBackButton().getFont().deriveFont(Font.BOLD));

            Font font = view.getBackButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            view.getBackButton().setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            view.getBackButton().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            view.getBackButton().setFont(view.getBackButton().getFont().deriveFont(Font.PLAIN));

            Font font = view.getBackButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            view.getBackButton().setFont(font.deriveFont(attributes));
        }
    }


    private static class NextButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            PasswordView passwordView = new PasswordView();
            new PasswordController(passwordView);
            MainLoginView.setActivePanel(passwordView.getcreatePasswordPanel());

        }
    }

    private static class NextButtonMouseListener implements MouseListener {

        private final CreateAccountView view;

        public NextButtonMouseListener(CreateAccountView view) {
            this.view = view;
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
            view.getNextButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getNextButton().setFont(view.getNextButton().getFont().deriveFont(Font.BOLD));

            Font font = view.getNextButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            view.getNextButton().setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            view.getNextButton().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            view.getNextButton().setFont(view.getNextButton().getFont().deriveFont(Font.PLAIN));

            Font font = view.getNextButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            view.getNextButton().setFont(font.deriveFont(attributes));
        }
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
