package com.mango.app.createaccount;

import com.mango.app.components.listeners.ButtonMouseListener;
import com.mango.app.components.listeners.TextFieldFocusListener;
import com.mango.app.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.app.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.app.login.LoginPageController;
import com.mango.app.login.LoginPageView;
import com.mango.app.mainloginpage.MainLoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CreateAccountController {

    private static final String FIRST_NAME_FIELD_ORIGINAL = "First name";
    private static final String LAST_NAME_FIELD_ORIGINAL = "Last name";
    private static final String EMAIL_FIELD_ORIGINAL = "Email";
    private static final String ERROR_MESSAGE_TITLE = "INVALID";

    public CreateAccountController(CreateAccountView view) {
        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

        view.getFirstNameText().addFocusListener(new TextFieldFocusListener(view.getFirstNameText(), FIRST_NAME_FIELD_ORIGINAL));
        view.getLastNameText().addFocusListener(new TextFieldFocusListener(view.getLastNameText(), LAST_NAME_FIELD_ORIGINAL));
        view.getEmailText().addFocusListener(new TextFieldFocusListener(view.getEmailText(), EMAIL_FIELD_ORIGINAL));
    }

    public CreateAccountController(CreateAccountView view, User user) {
        view.getLastNameText().setText(user.getLastName());
        view.getEmailText().setText(user.getEmail());

        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(view, user));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

        view.getFirstNameText().addFocusListener(new TextFieldFocusListener(view.getFirstNameText(), FIRST_NAME_FIELD_ORIGINAL));
        view.getLastNameText().addFocusListener(new TextFieldFocusListener(view.getLastNameText(), LAST_NAME_FIELD_ORIGINAL));
        view.getEmailText().addFocusListener(new TextFieldFocusListener(view.getEmailText(), EMAIL_FIELD_ORIGINAL));
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
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else if (register.isEmailTaken(user.getEmail())){
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Email is Already Taken.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else if(user.getFirstName() != null && !(user.getFirstName().length() >= 1 && user.getFirstName().length() <= 20)){
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Enter a Valid First Name.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else if(user.getLastName() != null && !(user.getLastName().length() >= 1 && user.getLastName().length() <= 20)) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Enter a Valid Last Name.",
                        ERROR_MESSAGE_TITLE,
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
}
