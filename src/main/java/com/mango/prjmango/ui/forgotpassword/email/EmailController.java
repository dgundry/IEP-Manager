package com.mango.prjmango.ui.forgotpassword.email;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.forgotpassword.securityquestions.AnswerSecurityQuestionsController;
import com.mango.prjmango.ui.forgotpassword.securityquestions.AnswerSecurityQuestionsView;
import com.mango.prjmango.ui.login.LoginController;
import com.mango.prjmango.ui.login.LoginView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Handles all user interaction with the Email page within the
 * Forgot Password section.
 */
public class EmailController {

    /**
     * Constructor. Adds {@link MouseListener}'s to specific {@link JLabel}'s that the user
     * would interact with.
     *
     * @param view the {@link EmailView} so we can access the {@link JLabel}'s
     */
    public EmailController(EmailView view) {
        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel));
    }

    /**
     * Constructor. Adds {@link MouseListener}'s to specific {@link JLabel}'s that the user
     * would interact with.
     *
     * @param view  the {@link EmailView} so we can access the {@link JLabel}'s
     * @param email the email the user typed within the {@link EmailView}
     */
    public EmailController(EmailView view, String email) {
        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel));

        view.getEmailTextField().setText(email);
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final EmailView view;
        private final JLabel label;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link EmailView} so we can retrieve data from other {@link JComponent}'s
         * @param label the specific {@link JLabel}
         */
        public NextLabelMouseListener(EmailView view, JLabel label) {
            this.view  = view;
            this.label = label;
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

            String email = view.getEmailTextField().getText().trim();
            if (DatabaseCommands.isEmailTaken(email)) {
                AnswerSecurityQuestionsView answerSecurityQuestionsView = new AnswerSecurityQuestionsView();
                new AnswerSecurityQuestionsController(answerSecurityQuestionsView, email);
                MainWindowView.setActiveDisplay(answerSecurityQuestionsView);
            } else {
                view.getInvalidLabel().setText("The email you entered does not exist. Please try again.");
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

        /**
         * Constructor. Initializes a {@link JLabel} instance variable that will be used throughout
         * the {@link MouseListener} methods.
         *
         * @param label the specific {@link JLabel} the user is interacting with
         */
        public BackLabelMouseListener(JLabel label) {
            this.label = label;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            LoginView loginView = new LoginView();
            new LoginController(loginView);
            MainWindowView.setActiveDisplay(loginView);
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
