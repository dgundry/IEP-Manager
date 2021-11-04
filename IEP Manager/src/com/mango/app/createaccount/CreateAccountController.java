package com.mango.app.createaccount;

import com.mango.app.createaccount.securityquestions.*;
import com.mango.app.login.*;
import com.mango.app.mainloginpage.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.*;
import javax.swing.*;

public class CreateAccountController {

    private CreateAccountView view;

    public CreateAccountController(CreateAccountView view) {
        this.view = view;

        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new BackButtonMouseListener(view));

        view.getNextButton().addActionListener(new NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new NextButtonMouseListener(view));

        addFocusListeners();
    }

    public CreateAccountController(CreateAccountView view, User user) {
        this.view = view;

        view.getLastNameText().setText(user.getLastName());
        view.getEmailText().setText(user.getEmail());

        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new BackButtonMouseListener(view));

        view.getNextButton().addActionListener(new NextButtonActionListener(view, user));
        view.getNextButton().addMouseListener(new NextButtonMouseListener(view));

        addFocusListeners();
    }

    private void addFocusListeners() {
        view.getFirstNameText().addFocusListener(new TextFieldFocusListener(view.getFirstNameText()));
        view.getLastNameText().addFocusListener(new TextFieldFocusListener(view.getLastNameText()));
        view.getEmailText().addFocusListener(new TextFieldFocusListener(view.getEmailText()));
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

        private final CreateAccountView view;

        private User user;

        private NextButtonActionListener(CreateAccountView view) {
            this.user = new User();
            this.view = view;
        }

        private NextButtonActionListener(CreateAccountView view, User user) { this.view = view; this.user = user; }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            User newUser = user.copyUser();
            System.out.println(newUser);
            newUser.setFirstName(view.getFirstNameText().getText());
            newUser.setLastName(view.getLastNameText().getText());
            newUser.setEmail(view.getEmailText().getText());

            SecurityQuestionsPageOneView securityQuestionsPageOneView = new SecurityQuestionsPageOneView();
            new SecurityQuestionsOneController(securityQuestionsPageOneView, newUser);
            MainLoginView.setActivePanel(securityQuestionsPageOneView.getSecurityQuestionsPanel());
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

    private static class TextFieldFocusListener implements FocusListener {

        private final JTextField textField;

        private String originalText;

        public TextFieldFocusListener(JTextField textField) {
            this.textField = textField;
        }

        /**
         * Invoked when a component gains the keyboard focus.
         *
         * @param e
         */
        @Override
        public void focusGained(FocusEvent e) {
            /*originalText = textField.getText();
            if (originalText.equals("First name") ||
                    originalText.equals("Last name") ||
                    originalText.equals("Email")) {
                textField.setText("");
            } else {
                textField.setText(originalText);
            }*/
        }

        /**
         * Invoked when a component loses the keyboard focus.
         *
         * @param e
         */
        @Override
        public void focusLost(FocusEvent e) {
           /* if (originalText.equals("First name") ||
                    originalText.equals("Last name") ||
                    originalText.equals("Email")) {
                textField.setText(originalText);
            }*/
        }
    }

//    public void registerSecurityQuestions(int teacher_id, int question_id_one, String answer_one, int question_id_two, String answer_two){
//        if(question_id_one != question_id_two){
//            registerSecurityAnswer(teacher_id, question_id_one, answer_one);
//            registerSecurityAnswer(teacher_id, question_id_two, answer_two);
//        }
//    }
//    private void registerSecurityAnswer(int teacher_id, int question_id, String answer){
//        String sql = "INSERT INTO questions(teacher_id, question_id, answer) VALUES(?,?,?);";
//        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
//            statement.setInt(1, teacher_id);
//            statement.setInt(2, question_id);
//            statement.setString(3, Encryption.encryptPassword(answer));
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void registerTeacher(String firstName, String lastName, String email, String password, int question_id_one, String answer_one, int question_id_two, String answer_two){
//        if(!isEmailTaken(email)) {
//            String sql = "INSERT INTO teacher(first_name,last_name,email,password) VALUES(?,?,?,?);";
//            try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
//                statement.setString(1, firstName);
//                statement.setString(2, lastName);
//                statement.setString(3, email);
//                statement.setString(4, Encryption.encryptPassword(password));
//                statement.executeUpdate();
//                int teacher_id = getTeacher_id(email);
//                registerSecurityQuestions(teacher_id, question_id_one, answer_one, question_id_two, answer_two);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }else{
//            System.out.println("Email has been taken.");
//        }
//    }
//    private int getTeacher_id(String email){
//        int result = -1;
//        String sql = "SELECT teacher_id FROM teacher WHERE email = ?;";
//        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
//            statement.setString(1, email);
//            ResultSet resultSet = statement.executeQuery();
//            result = resultSet.getInt(1);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return result;
//    }
//    private boolean isEmailTaken(String email){
//        boolean result = false;
//        String sql = "SELECT email FROM teacher WHERE email = ?;";
//        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
//            statement.setString(1, email);
//            ResultSet resultSet = statement.executeQuery();
//            result = resultSet.next();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return result;
//    }
}
