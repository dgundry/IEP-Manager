package com.mango.prjmango.createaccount.securityquestions;


import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.createaccount.basicinfo.BasicInfoController;
import com.mango.prjmango.createaccount.basicinfo.BasicInfoView;
import com.mango.prjmango.utilities.User;
import com.mango.prjmango.createaccount.password.PasswordController;
import com.mango.prjmango.createaccount.password.PasswordView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SecurityQuestionsController {

    public SecurityQuestionsController(SecurityQuestionsView view, User user) {
        view.getBackButton().addActionListener(new BackButtonActionListener(user, view));
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(user, view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));
    }

    private static class BackButtonActionListener implements ActionListener {

        private final User user;
        private final SecurityQuestionsView view;

        public BackButtonActionListener(User user, SecurityQuestionsView view) {
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
            user.setSecurityQ1(view.getSecurityQuestionOne().getSelectedIndex());
            user.setSecurityA1(view.getSecurityOneAnsText().getText());
            user.setSecurityQ2(view.getSecurityQuestionTwo().getSelectedIndex());
            user.setSecurityA2(view.getSecurityTwoAnsText().getText());

            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String email = user.getEmail();

            BasicInfoView createAccountView = new BasicInfoView();
            createAccountView.getFirstNameText().setText(firstName.equals("") ? "First name" : user.getFirstName());
            createAccountView.getLastNameText().setText(lastName.equals("") ? "Last name" : user.getLastName());
            createAccountView.getEmailText().setText(email.equals("") ? "Email" : user.getEmail());

            new BasicInfoController(createAccountView, user);
            MainFrame.setActivePanel(createAccountView);
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
            int questionOneIndex = view.getSecurityQuestionOne().getSelectedIndex();
            int questionTwoIndex = view.getSecurityQuestionTwo().getSelectedIndex();

            if (questionOneIndex == questionTwoIndex) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Please select two different security questions.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else if (view.getSecurityOneAnsText().getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Please enter an answer for your first security question.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else if (view.getSecurityTwoAnsText().getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Please enter an answer for your second security question.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                user.setSecurityQ1(view.getSecurityQuestionOne().getSelectedIndex());
                user.setSecurityQ2(view.getSecurityQuestionTwo().getSelectedIndex());

                user.setSecurityA1(view.getSecurityOneAnsText().getText());
                user.setSecurityA2(view.getSecurityTwoAnsText().getText());

                PasswordView passwordView = new PasswordView();
                new PasswordController(passwordView, user);
                MainFrame.setActivePanel(passwordView);
            }
        }
    }
}

