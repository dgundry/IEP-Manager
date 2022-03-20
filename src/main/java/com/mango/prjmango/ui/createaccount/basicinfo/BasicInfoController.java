package com.mango.prjmango.ui.createaccount.basicinfo;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.User;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.prjmango.ui.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.ui.login.LoginController;
import com.mango.prjmango.ui.login.LoginView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * This class handles all user interaction with the Basic Info page within the
 * Create Account section.
 */
public class BasicInfoController {

    /**
     * Constructor. Initializes listeners for {@link JLabel}'s within the {@link BasicInfoView}.
     *
     * @param view the {@link BasicInfoView} to access {@link JLabel}'s
     */
    public BasicInfoController(BasicInfoView view) {
        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel));
    }

    /**
     * Constructor. Initializes listeners for {@link JLabel}'s within the {@link BasicInfoView}.
     *
     * @param view the {@link BasicInfoView} to access {@link JLabel}'s
     * @param user the {@link User} object to access data within
     */
    public BasicInfoController(BasicInfoView view, User user) {
        view.getFirstNameTextField().setText(user.getFirstName());
        view.getLastNameTextField().setText(user.getLastName());
        view.getEmailTextField().setText(user.getEmail());

        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel, user));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel));
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final BasicInfoView view;
        private final JLabel label;
        private User user;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link BasicInfoView} so we can access other {@link JComponent}'s
         * @param label the specific {@link JLabel}
         */
        public NextLabelMouseListener(BasicInfoView view, JLabel label) {
            this.view = view;
            this.label = label;
        }

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link BasicInfoView} so we can access other {@link JComponent}'s
         * @param label the specific {@link JLabel}
         * @param user  the current {@link User}
         */
        public NextLabelMouseListener(BasicInfoView view, JLabel label, User user) {
            this.view = view;
            this.label = label;
            this.user = user;

            view.getFirstNameTextField().setText(user.getFirstName());
            view.getLastNameTextField().setText(user.getLastName());
            view.getEmailTextField().setText(user.getEmail());
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            if (user == null) {
                user = new User();
            }

            user.setFirstName(view.getFirstNameTextField().getText().trim());
            user.setLastName(view.getLastNameTextField().getText().trim());
            user.setEmail(view.getEmailTextField().getText().trim());

            view.getFirstNameInvalidLabel().setText(" ");
            view.getLastNameInvalidLabel().setText(" ");
            view.getEmailInvalidLabel().setText(" ");

            if (user.getFirstName() != null && !(user.getFirstName().length() >= 1 && user.getFirstName().length() <= 20)) {
                view.getFirstNameInvalidLabel().setText("Invalid first name! Please try again.");
            } else if (user.getLastName() != null && !(user.getLastName().length() >= 1 && user.getLastName().length() <= 20)) {
                view.getLastNameInvalidLabel().setText("Invalid last name! Please try again.");
            } else if (!user.getEmail().contains("@")) {
                view.getEmailInvalidLabel().setText("Invalid email! Please try again.");
            } else if (DatabaseCommands.isEmailTaken(user.getEmail())) {
                view.getEmailInvalidLabel().setText("Email is already taken! Please try again.");
            } else {
                SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
                securityQuestionsView.getSecurityQuestion1ComboBox().setSelectedIndex(user.getSecurityQ1());
                securityQuestionsView.getSecurityQuestion2ComboBox().setSelectedIndex(user.getSecurityQ2());
                securityQuestionsView.getAnswer1TextField().setText(user.getSecurityA1());
                securityQuestionsView.getAnswer2TextField().setText(user.getSecurityA2());

                new SecurityQuestionsController(securityQuestionsView, user);
                MainWindowView.setActiveDisplay(securityQuestionsView);
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
         * @param e the e{@link MouseEvent}
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
         * Constructor. Initializes an instance variable that will be used in the {@link MouseListener}
         * methods.
         *
         * @param label the specific {@link JLabel} that represent the "Back" button
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
         * @param e the e{@link MouseEvent}
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
