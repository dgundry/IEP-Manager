package com.mango.prjmango.ui.forgotpassword.securityquestions;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.Encryption;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.forgotpassword.email.EmailController;
import com.mango.prjmango.ui.forgotpassword.email.EmailView;
import com.mango.prjmango.ui.forgotpassword.password.PasswordController;
import com.mango.prjmango.ui.forgotpassword.password.PasswordView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import com.mango.prjmango.utilities.dbcommands.UserCommands;
import lombok.SneakyThrows;

/**
 * Handles all user interaction with the Answer Security Questions page in the
 * Forgot Password page.
 */
public class AnswerSecurityQuestionsController {

    private int teacherId;

    /**
     * Constructor. Adds {@link MouseListener}'s to the {@link JLabel}'s that the user will interact with.
     *
     * @param view  the {@link AnswerSecurityQuestionsView} so we can access the {@link JLabel}'s
     * @param email the email the user entered within the {@link EmailView}
     */
    public AnswerSecurityQuestionsController(AnswerSecurityQuestionsView view, String email) {
        populateQuestions(view, email);

        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel, teacherId, email));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel, email));
    }

    public AnswerSecurityQuestionsController(
            AnswerSecurityQuestionsView view,
            int teacherId,
            String email,
            String question1,
            String question2,
            String answer1,
            String answer2) {
        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel, teacherId, email));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel, email));

        view.getQuestion1Label().setText(question1);
        view.getQuestion2Label().setText(question2);

        view.getAnswer1TextField().setText(answer1);
        view.getAnswer2TextField().setText(answer2);
    }

    private void populateQuestions(AnswerSecurityQuestionsView view, String email) {
        this.teacherId = UserCommands.getTeacherId(email);
        List<Integer> indexes = UserCommands.getUserQuestionIndexes(teacherId);

        String question1 = DatabaseCommands.getSecurityQuestion(indexes.get(0));
        String question2 = DatabaseCommands.getSecurityQuestion(indexes.get(1));

        view.getQuestion1Label().setText(question1);
        view.getQuestion2Label().setText(question2);
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final AnswerSecurityQuestionsView view;
        private final JLabel label;
        private final int teacherId;
        private String email;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view      the {@link AnswerSecurityQuestionsView} so we can retrieve data from other
         *                  {@link JComponent}'s
         * @param label     the specific {@link JLabel}
         * @param teacherId the current user's {@code teacherId}
         * @param email     the current user's {@code email}
         */
        public NextLabelMouseListener(AnswerSecurityQuestionsView view, JLabel label, int teacherId, String email) {
            this.view      = view;
            this.label     = label;
            this.teacherId = teacherId;
            this.email     = email;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @SneakyThrows
        @Override
        public void mouseClicked(MouseEvent e) {
            view.getInvalidLabel().setText(" ");

            List<String> storedAnswers = DatabaseCommands.getSecurityQuestionAnswers(teacherId);

            String question1 = view.getQuestion1Label().getText();
            String question2 = view.getQuestion2Label().getText();

            String userEnteredAnswer1 = view.getAnswer1TextField().getText().trim();
            String userEnteredAnswer2 = view.getAnswer2TextField().getText().trim();

            String encryptedUserAnswer1 = Encryption.encrypt(userEnteredAnswer1);
            String encryptedUserAnswer2 = Encryption.encrypt(userEnteredAnswer2);

            if (!encryptedUserAnswer1.equals(storedAnswers.get(0)) ||
                    !encryptedUserAnswer2.equals(storedAnswers.get(1))) {
                view.getInvalidLabel().setText("Answers do not match our records. Please try again.");
            } else {
                PasswordView passwordView = new PasswordView();
                new PasswordController(
                        passwordView, teacherId, email, question1, question2, userEnteredAnswer1, userEnteredAnswer2);
                MainWindowView.setActiveDisplay(passwordView);
            }
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.NEXT_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.NEXT_NO_HOVER.getImageIcon());
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
        private final String email;

        /**
         * Constructor. Initializes a {@link JLabel} instance variable that will be used throughout
         * the {@link MouseListener} methods.
         *
         * @param label the specific {@link JLabel} the user is interacting with
         */
        public BackLabelMouseListener(JLabel label, String email) {
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
            EmailView emailView = new EmailView();
            new EmailController(emailView, email);
            MainWindowView.setActiveDisplay(emailView);
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
