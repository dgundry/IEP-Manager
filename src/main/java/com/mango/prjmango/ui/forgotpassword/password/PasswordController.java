package com.mango.prjmango.ui.forgotpassword.password;

import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.forgotpassword.securityquestions.AnswerSecurityQuestionsController;
import com.mango.prjmango.ui.forgotpassword.securityquestions.AnswerSecurityQuestionsView;
import com.mango.prjmango.ui.login.LoginController;
import com.mango.prjmango.ui.login.LoginView;
import com.mango.prjmango.utilities.dbcommands.UserCommands;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PasswordController {

    public PasswordController(
            PasswordView view,
            int teacherId,
            String email,
            String question1,
            String question2,
            String answer1,
            String answer2) {
        JLabel resetPasswordLabel = view.getResetPasswordLabel();
        JLabel backLabel = view.getBackLabel();

        resetPasswordLabel.addMouseListener(new NextLabelMouseListener(view, resetPasswordLabel, email));
        backLabel.addMouseListener(new BackLabelMouseListener(
                backLabel, teacherId, email, question1, question2, answer1, answer2));
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final PasswordView view;
        private final JLabel label;
        private final String email;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link AnswerSecurityQuestionsView} so we can retrieve data from other
         *              {@link JComponent}'s
         * @param label the specific {@link JLabel}
         */
        public NextLabelMouseListener(PasswordView view, JLabel label, String email) {
            this.view  = view;
            this.label = label;
            this.email = email;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            view.getInvalidLabel().setText(" ");
            view.getInvalidLabel().setForeground(Color.RED);

            JPasswordField createPasswordField  = view.getCreatePasswordField();
            JPasswordField confirmPasswordField = view.getConfirmPasswordField();

            char[] createPassword  = createPasswordField.getPassword();
            char[] confirmPassword = confirmPasswordField.getPassword();

            String strCreatePass = String.valueOf(createPassword);
            String strConfirmedPass = String.valueOf(confirmPassword);


            if (!isValid(strCreatePass)) {
                view.getInvalidLabel().setText("<html>Please make sure that your password contains: " +
                        "<ul><li>8 or more characters</li>" +
                        "<li>At least 1 Special Character</li>" +
                        "<li>At least 1 Uppercase letter</li>" +
                        "<li>At least 1 Lowercase letter</li>" +
                        "<li>At least 1 digit</li></ul></html>");
            } else if (strCreatePass.equals(strConfirmedPass)) {
                displayInformationText();
                UserCommands.updateUserPassword(createPassword);
            } else {
                view.getInvalidLabel().setText("New password does not match the confirmation password!");
                view.getInvalidLabel().setForeground(Colors.RED);
            }
        }

        private static final String PASSWORD_PATTERN =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

        private static boolean isValid(final String password){
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }

        private void displayInformationText() {
            view.getInvalidLabel().setText("Information successfully changed!");
            view.getInvalidLabel().setForeground(Colors.GREEN);

            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            view.getCreatePasswordField().setText("");
                            view.getConfirmPasswordField().setText("");

                            view.getCreatePasswordField().requestFocus();

                            view.getInvalidLabel().setText(" ");
                            view.getInvalidLabel().setForeground(Colors.RED);

                            LoginView loginView = new LoginView();
                            new LoginController(loginView);
                            MainWindowView.setActiveDisplay(loginView);
                        }
                    },
                    3000
            );
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.RESET_PASSWORD_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.RESET_PASSWORD_NO_HOVER.getImageIcon());
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }

    private static class BackLabelMouseListener implements MouseListener {

        private final JLabel label;
        private final int teacherId;
        private final String email;
        private final String question1;
        private final String question2;
        private final String answer1;
        private final String answer2;

        /**
         * Constructor. Initializes a {@link JLabel} instance variable that will be used throughout
         * the {@link MouseListener} methods.
         *
         * @param label     the specific {@link JLabel} the user is interacting with
         * @param teacherId the current user's teacherId
         * @param email     the current user's email address
         * @param question1 the current user's 1st security question
         * @param question2 the current user's 2nd security question
         * @param answer1   the current user's 1st security question answer
         * @param answer2   the current user's 2nd security question answer
         */
        public BackLabelMouseListener(
                JLabel label,
                int teacherId,
                String email,
                String question1,
                String question2,
                String answer1,
                String answer2) {
            this.label     = label;
            this.teacherId = teacherId;
            this.email     = email;
            this.question1 = question1;
            this.question2 = question2;
            this.answer1   = answer1;
            this.answer2   = answer2;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link java.awt.event.MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            AnswerSecurityQuestionsView answerSecurityQuestionsView = new AnswerSecurityQuestionsView();
            new AnswerSecurityQuestionsController(
                    answerSecurityQuestionsView, teacherId, email, question1, question2, answer1, answer2);
            MainWindowView.setActiveDisplay(answerSecurityQuestionsView);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.BACK_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.BACK_NO_HOVER.getImageIcon());
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }
}
