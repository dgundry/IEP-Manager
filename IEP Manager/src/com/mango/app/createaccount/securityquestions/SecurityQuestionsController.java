package com.mango.app.createaccount.securityquestions;

import com.mango.app.components.*;
import com.mango.app.createaccount.User;
import com.mango.app.createaccount.CreateAccountController;
import com.mango.app.createaccount.CreateAccountView;
import com.mango.app.createaccount.password.PasswordController;
import com.mango.app.createaccount.password.PasswordView;
import com.mango.app.mainloginpage.MainLoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SecurityQuestionsController {

    public SecurityQuestionsController(SecurityQuestionsView view, User user) {
        view.getBackButton().addActionListener(new BackButtonActionListener(user));
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(user, view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));
    }

    private static class BackButtonActionListener implements ActionListener {

        private final User user;

        public BackButtonActionListener(User user) {
            this.user = user;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String email = user.getEmail();

            CreateAccountView createAccountView = new CreateAccountView();
            createAccountView.getFirstNameText().setText(firstName.equals("") ? "First name" : user.getFirstName());
            createAccountView.getLastNameText().setText(lastName.equals("") ? "Last name" : user.getLastName());
            createAccountView.getEmailText().setText(email.equals("") ? "Email" : user.getEmail());

            new CreateAccountController(createAccountView, user);
            MainLoginView.setActivePanel(createAccountView.getCreateAccountPanel());
        }
    }

    private static class NextButtonActionListener implements ActionListener {

        private final User user;
        private final SecurityQuestionsView view;

        public NextButtonActionListener(User user, SecurityQuestionsView view) {
            this.user = user;
            this.view = view;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            final String MESSAGE_TITLE = "Invalid!";
            int questionOneIndex = view.getSecurityQuestionOneDropDown().getSelectedIndex();
            int questionTwoIndex = view.getSecurityQuestionTwoDropDown().getSelectedIndex();

            if (questionOneIndex == questionTwoIndex) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Please select two different security questions.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
            else if (view.getSecurityOneAnsText().getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Please enter an answer for your first security question.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
            else if (view.getSecurityTwoAnsText().getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Please enter an answer for your second security question.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                user.setSecurityQ1(view.getSecurityQuestionOneDropDown().getSelectedIndex());
                user.setSecurityQ2(view.getSecurityQuestionTwoDropDown().getSelectedIndex());

                user.setSecurityA1(view.getSecurityOneAnsText().getText());
                user.setSecurityA2(view.getSecurityTwoAnsText().getText());

                PasswordView passwordView = new PasswordView();
                new PasswordController(passwordView, user);
                MainLoginView.setActivePanel(passwordView.getCreatePasswordPanel());
            }
        }
    }
}
