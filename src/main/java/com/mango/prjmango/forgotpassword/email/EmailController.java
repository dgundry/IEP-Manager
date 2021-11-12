package com.mango.prjmango.forgotpassword.email;


import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.forgotpassword.PasswordChange;
import com.mango.prjmango.forgotpassword.securityquestions.AnswerSecurityQuestionsController;
import com.mango.prjmango.forgotpassword.securityquestions.AnswerSecurityQuestionsView;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.mainloginpage.MainLoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmailController {
    private final EmailView view;

    public EmailController(EmailView view) {
        this.view = view;

        view.getCancelButton().addActionListener(new EmailController.CancelButtonActionListener());
        view.getCancelButton().addMouseListener(new ButtonMouseListener(view.getCancelButton()));

        view.getNextButton().addActionListener(new EmailController.NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

        view.getEmailText().addMouseListener(new EmailMouseListener(view));

        addFocusListeners();
    }

    private void addFocusListeners() {
        view.getEmailText().addFocusListener(new EmailController.TextFieldFocusListener(view.getEmailText()));
    }

    private static class CancelButtonActionListener implements ActionListener {

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

        private final EmailView view;
        public NextButtonActionListener(EmailView view) { this.view = view;}

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            PasswordChange passwordChange = new PasswordChange();
            if (!passwordChange.isEmailTaken(view.getEmailText().getText())) {
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "No accounts found with this email.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else {
                AnswerSecurityQuestionsView securityQuestions = new AnswerSecurityQuestionsView(passwordChange.getTeacher_id(view.getEmailText().getText()));
                new AnswerSecurityQuestionsController(securityQuestions, passwordChange.getTeacher_id(view.getEmailText().getText()));
                MainLoginView.setActivePanel(securityQuestions.getSecurityQuestionsPanel());
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
    private static class EmailMouseListener implements MouseListener {

        private final EmailView emailView;

        public EmailMouseListener(EmailView emailView) { this.emailView = emailView; }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(emailView.getEmailText().getText().equals("Email")){
                emailView.getEmailText().setText("");

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
