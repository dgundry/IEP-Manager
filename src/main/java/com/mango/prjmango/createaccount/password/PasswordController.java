package com.mango.prjmango.createaccount.password;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.createaccount.Register;
import com.mango.prjmango.createaccount.User;
import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class PasswordController {

    public PasswordController(PasswordView view, User user) {
        view.getBackButton().addActionListener(new BackButtonActionListener(view, user));
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getCreateAccountButton().addActionListener(new CreateAccountButtonActionListener(user, view));
        view.getCreateAccountButton().addMouseListener(new ButtonMouseListener(view.getCreateAccountButton()));
    }

    private static class BackButtonActionListener implements ActionListener {

        private final PasswordView view;
        private final User user;

        /**
         * Constructor. Initializes instance variables that will be used in the {@link ActionListener}
         * methods.
         *
         * @param view the {@link PasswordView} to access {@link JComponent}'s
         * @param user the {@link User} object to access fields
         */
        public BackButtonActionListener(PasswordView view, User user) {
            this.view = view;
            this.user = user;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
         */
        public void actionPerformed(ActionEvent e){
            user.setPassword1(view.getPasswordText().getPassword());
            user.setPassword2(view.getConfirmPasswordText().getPassword());

            SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
            securityQuestionsView.getSecurityQuestionOne().setSelectedIndex(user.getSecurityQ1());
            securityQuestionsView.getSecurityQuestionTwo().setSelectedIndex(user.getSecurityQ2());
            securityQuestionsView.getSecurityOneAnsText().setText(user.getSecurityA1());
            securityQuestionsView.getSecurityTwoAnsText().setText(user.getSecurityA2());

            new SecurityQuestionsController(securityQuestionsView, user);
            MainFrame.setActivePanel(securityQuestionsView);
        }
    }

    private static class CreateAccountButtonActionListener implements ActionListener {
        private final User user;
        private final PasswordView view;

        public CreateAccountButtonActionListener(User user, PasswordView view){
            this.view = view;
            this.user = user;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            final String MESSAGE_TITLE = "Invalid!";
            //Add user to database
            //Verify all input
            char[] password = view.getPasswordText().getPassword();
            char[] passwordConfirmed = view.getConfirmPasswordText().getPassword();

            user.setPassword1(password);
            user.setPassword2(passwordConfirmed);

            if (!Arrays.equals(password, passwordConfirmed)){
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Passwords are not matching.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else if (view.getPasswordText().getPassword().length == 0) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Please enter a valid Password.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
            else if (view.getConfirmPasswordText().getPassword().length == 0) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Please confirm your Password.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Register register = new Register();
                user.setSecurityQ1(user.getSecurityQ1()+1);
                user.setSecurityQ2(user.getSecurityQ2()+1);

                if (register.createUser(user)) {
                    //Dialog.openDialog(Dialog.ACCOUNT_CREATED); <----Temporary Change

                    JOptionPane.showMessageDialog(
                            MainFrame.getFrame(),
                            "Account created!",
                            "Success!",
                            JOptionPane.PLAIN_MESSAGE);

                    LoginPageView loginPageView = new LoginPageView();
                    new LoginPageController(loginPageView);
                    MainFrame.setActivePanel(loginPageView);
                } else {
                    JOptionPane.showMessageDialog(
                            MainFrame.getFrame(),
                            "Something went wrong with registering.",
                            "FAILURE",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
