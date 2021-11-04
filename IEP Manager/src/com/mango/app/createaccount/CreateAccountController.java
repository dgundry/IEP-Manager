package com.mango.app.createaccount;

import com.mango.app.components.*;
import com.mango.app.createaccount.securityquestions.*;
import com.mango.app.login.*;
import com.mango.app.mainloginpage.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateAccountController {

    private final CreateAccountView view;

    public CreateAccountController(CreateAccountView view) {
        this.view = view;

        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

        addFocusListeners();
    }

    public CreateAccountController(CreateAccountView view, User user) {
        this.view = view;

        view.getLastNameText().setText(user.getLastName());
        view.getEmailText().setText(user.getEmail());

        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(view, user));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

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

    private static class NextButtonActionListener implements ActionListener {

        private final CreateAccountView view;
        private User user;

        public NextButtonActionListener(CreateAccountView view) {
            this.view = view;
        }

        public NextButtonActionListener(CreateAccountView view, User user) {
            this.view = view;
            this.user = user;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (user == null) {
                user = new User();
            }

            user.setFirstName(view.getFirstNameText().getText());
            user.setLastName(view.getLastNameText().getText());
            user.setEmail(view.getEmailText().getText());

            SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
            securityQuestionsView.getSecurityQuestionOneDropDown().setSelectedIndex(user.getSecurityQ1());
            securityQuestionsView.getSecurityQuestionTwoDropDown().setSelectedIndex(user.getSecurityQ2());
            securityQuestionsView.getSecurityOneAnsText().setText(user.getSecurityA1());
            securityQuestionsView.getSecurityTwoAnsText().setText(user.getSecurityA2());

            new SecurityQuestionsController(securityQuestionsView, user);
            MainLoginView.setActivePanel(securityQuestionsView.getSecurityQuestionsPanel());
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
