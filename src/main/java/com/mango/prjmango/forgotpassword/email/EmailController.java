package com.mango.prjmango.forgotpassword.email;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.components.listeners.TextFieldFocusListener;
import com.mango.prjmango.forgotpassword.securityquestions.AnswerSecurityQuestionsController;
import com.mango.prjmango.forgotpassword.securityquestions.AnswerSecurityQuestionsView;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.utilities.DatabaseCommands;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * Handles user interaction within the Email page on the Forgot Password section.
 */
public class EmailController {

    private static final String EMAIL_FIELD_ORIGINAL = "Email";

    /**
     * Constructor. Initializes listeners for {@link JComponent}'s within the {@link EmailView}.
     *
     * @param view the {@link EmailView} to access {@link JComponent}'s
     */
    public EmailController(EmailView view) {
        view.getCancelButton().addActionListener(new EmailController.CancelButtonActionListener());
        view.getCancelButton().addMouseListener(new ButtonMouseListener(view.getCancelButton()));

        view.getNextButton().addActionListener(new EmailController.NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

        view.getEmailText().addFocusListener(new TextFieldFocusListener(view.getEmailText(), EMAIL_FIELD_ORIGINAL));
    }

    private static class CancelButtonActionListener implements ActionListener {

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

        private final EmailView view;

        /**
         * Constructor. Initializes instance variable(s) that will be used in the {@link ActionListener}
         * methods.
         *
         * @param view the {@link EmailView}
         */
        public NextButtonActionListener(EmailView view) {
            this.view = view;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmailText().getText().trim();

            if (!DatabaseCommands.isEmailTaken(email)) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "No accounts found with this email.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                int teacherId = DatabaseCommands.getTeacherId(email);

                AnswerSecurityQuestionsView securityQuestions = new AnswerSecurityQuestionsView(teacherId);
                new AnswerSecurityQuestionsController(securityQuestions);
                MainFrame.setActivePanel(securityQuestions);
            }
        }
    }
}
