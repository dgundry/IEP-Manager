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

            Register register = new Register();
            if(!user.getEmail().contains("@")){
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Enter a Valid Email.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);
            }else if (register.isEmailTaken(user.getEmail())){
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Email is Already Taken.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);
            }else if(user.getFirstName() != null && !(user.getFirstName().length() >= 1 && user.getFirstName().length() <= 20)){
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Enter a Valid First Name.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);
            }else if(user.getLastName() != null && !(user.getLastName().length() >= 1 && user.getLastName().length() <= 20)) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Enter a Valid Last Name.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);
            }else {
                SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
                securityQuestionsView.getSecurityQuestionOneDropDown().setSelectedIndex(user.getSecurityQ1());
                securityQuestionsView.getSecurityQuestionTwoDropDown().setSelectedIndex(user.getSecurityQ2());
                securityQuestionsView.getSecurityOneAnsText().setText(user.getSecurityA1());
                securityQuestionsView.getSecurityTwoAnsText().setText(user.getSecurityA2());

                new SecurityQuestionsController(securityQuestionsView, user);
                MainLoginView.setActivePanel(securityQuestionsView.getSecurityQuestionsPanel());
            }
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
}
