package com.mango.prjmango.createaccount.password;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.dialogs.Dialog;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.createaccount.Register;
import com.mango.prjmango.createaccount.User;
import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class PasswordController {

    public PasswordController(PasswordView view, User user) {
        if(!user.getPassword1().equals("")){
            view.getPasswordText().setText(user.getPassword1());
        }
        if(!user.getPassword2().equals("")){
            view.getConfirmPasswordText().setText(user.getPassword2());
        }
        view.getBackButton().addActionListener(new BackButtonActionListener(view, user));
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getCreateAccountButton().addActionListener(new CreateAccountButtonActionListener(user, view));
        view.getCreateAccountButton().addMouseListener(new ButtonMouseListener(view.getCreateAccountButton()));

        view.getPasswordText().addMouseListener(new PasswordTextFieldMouseListener(view));
        view.getConfirmPasswordText().addMouseListener(new ConfirmPasswordTextFieldMouseListener(view));
    }

    private static class BackButtonActionListener implements ActionListener {

        private final PasswordView view;
        private final User user;

        public BackButtonActionListener(PasswordView view, User user) {
            this.view = view;
            this.user = user;
        }
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */

        public void actionPerformed(ActionEvent e){
            user.setPassword1(view.getPasswordText().getText());
            user.setPassword2(view.getConfirmPasswordText().getText());

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
            String password = view.getPasswordText().getText();
            String passwordConfirmed = view.getConfirmPasswordText().getText();
            user.setPassword1(password);
            user.setPassword2(passwordConfirmed);
            if (!password.equals(passwordConfirmed)){
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Passwords are not matching.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else if (view.getPasswordText().getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Please enter a valid Password.",
                        MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
            else if (view.getConfirmPasswordText().getText().isEmpty()) {
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
                    Dialog.openDialog(Dialog.ACCOUNT_CREATED);

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
    private static class PasswordTextFieldMouseListener implements MouseListener {

        private final PasswordView passwordView;

        public PasswordTextFieldMouseListener(PasswordView passwordView) { this.passwordView = passwordView; }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(passwordView.getPasswordText().getText().equals("Password")){
                passwordView.getPasswordText().setText("");

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    private static class ConfirmPasswordTextFieldMouseListener implements MouseListener {

        private final PasswordView passwordView;

        public ConfirmPasswordTextFieldMouseListener(PasswordView passwordView) { this.passwordView = passwordView; }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(passwordView.getConfirmPasswordText().getText().equals("Confirm Password")){
                passwordView.getConfirmPasswordText().setText("");

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
