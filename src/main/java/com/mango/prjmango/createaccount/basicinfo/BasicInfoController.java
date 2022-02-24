package com.mango.prjmango.createaccount.basicinfo;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.components.listeners.TextFieldFocusListener;
import com.mango.prjmango.createaccount.Register;
import com.mango.prjmango.utilities.User;
import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * Handles user interaction within the Basic Info page on the Create Account section.
 */
public class BasicInfoController {

    private static final String FIRST_NAME_FIELD_ORIGINAL = "First name";
    private static final String LAST_NAME_FIELD_ORIGINAL = "Last name";
    private static final String EMAIL_FIELD_ORIGINAL = "Email";
    private static final String ERROR_MESSAGE_TITLE = "INVALID";

    /**
     * Constructor. Initializes listeners for {@link JComponent}'s within the {@link BasicInfoView}.
     *
     * @param view the {@link BasicInfoView} to access {@link JComponent}'s
     */
    public BasicInfoController(BasicInfoView view) {
        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

        view.getFirstNameText().addFocusListener(new TextFieldFocusListener(view.getFirstNameText(), FIRST_NAME_FIELD_ORIGINAL));
        view.getLastNameText().addFocusListener(new TextFieldFocusListener(view.getLastNameText(), LAST_NAME_FIELD_ORIGINAL));
        view.getEmailText().addFocusListener(new TextFieldFocusListener(view.getEmailText(), EMAIL_FIELD_ORIGINAL));
    }

    /**
     * Constructor. Initializes listeners for {@link JComponent}'s within the {@link BasicInfoView}.
     *
     * @param view the {@link BasicInfoView} to access {@link JComponent}'s
     * @param user the {@link User} object to access data within
     */
    public BasicInfoController(BasicInfoView view, User user) {
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
         * @param e the {@link ActionEvent}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginPageView loginPageView = new LoginPageView();
            new LoginPageController(loginPageView);
            MainFrame.setActivePanel(loginPageView);
        }
    }

    private static class NextButtonActionListener implements ActionListener {

        private final BasicInfoView view;
        private User user;

        /**
         * Constructor. Initializes an instance variable, {@link BasicInfoView}, which will be used within
         * the {@link ActionListener} methods.
         *
         * @param view the {@link BasicInfoView}
         */
        public NextButtonActionListener(BasicInfoView view) {
            this.view = view;
        }

        /**
         * Constructor. Initializes instance variables which will be used within the {@link ActionListener} methods.
         *
         * @param view the {@link BasicInfoView} that will allow access to {@link JComponent}'s
         * @param user the {@link User} object that we will retrieve data from
         */
        public NextButtonActionListener(BasicInfoView view, User user) {
            this.view = view;
            this.user = user;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
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
            if (!user.getEmail().contains("@")) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Enter a Valid Email.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else if (register.isEmailTaken(user.getEmail())) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Email is Already Taken.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else if (user.getFirstName() != null && !(user.getFirstName().length() >= 1 && user.getFirstName().length() <= 20)) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Enter a Valid First Name.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else if (user.getLastName() != null && !(user.getLastName().length() >= 1 && user.getLastName().length() <= 20)) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Enter a Valid Last Name.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
                securityQuestionsView.getSecurityQuestionOne().setSelectedIndex(user.getSecurityQ1());
                securityQuestionsView.getSecurityQuestionTwo().setSelectedIndex(user.getSecurityQ2());
                securityQuestionsView.getSecurityOneAnsText().setText(user.getSecurityA1());
                securityQuestionsView.getSecurityTwoAnsText().setText(user.getSecurityA2());

                new SecurityQuestionsController(securityQuestionsView, user);
                MainFrame.setActivePanel(securityQuestionsView);
            }
        }
    }
}
