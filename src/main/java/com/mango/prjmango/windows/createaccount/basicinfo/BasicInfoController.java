package com.mango.prjmango.windows.createaccount.basicinfo;

import com.mango.prjmango.createaccount.Register;
import com.mango.prjmango.utilities.User;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.prjmango.windows.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.windows.login.LoginController;
import com.mango.prjmango.windows.login.LoginView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

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

        public NextLabelMouseListener(BasicInfoView view, JLabel label) {
            this.view = view;
            this.label = label;
        }

        public NextLabelMouseListener(BasicInfoView view, JLabel label, User user) {
            this.view = view;
            this.label = label;
            this.user = user;
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

            Register register = new Register();
            if (!user.getEmail().contains("@")) {
//                JOptionPane.showMessageDialog(
//                        MainFrame.getFrame(),
//                        "Enter a Valid Email.",
//                        ERROR_MESSAGE_TITLE,
//                        JOptionPane.ERROR_MESSAGE);
            } else if (register.isEmailTaken(user.getEmail())) {
//                JOptionPane.showMessageDialog(
//                        MainFrame.getFrame(),
//                        "Email is Already Taken.",
//                        ERROR_MESSAGE_TITLE,
//                        JOptionPane.ERROR_MESSAGE);
            } else if (user.getFirstName() != null && !(user.getFirstName().length() >= 1 && user.getFirstName().length() <= 20)) {
//                JOptionPane.showMessageDialog(
//                        MainFrame.getFrame(),
//                        "Enter a Valid First Name.",
//                        ERROR_MESSAGE_TITLE,
//                        JOptionPane.ERROR_MESSAGE);
            } else if (user.getLastName() != null && !(user.getLastName().length() >= 1 && user.getLastName().length() <= 20)) {
//                JOptionPane.showMessageDialog(
//                        MainFrame.getFrame(),
//                        "Enter a Valid Last Name.",
//                        ERROR_MESSAGE_TITLE,
//                        JOptionPane.ERROR_MESSAGE);
            } else {
                SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
//                securityQuestionsView.getSecurityQuestionOne().setSelectedIndex(user.getSecurityQ1());
//                securityQuestionsView.getSecurityQuestionTwo().setSelectedIndex(user.getSecurityQ2());
//                securityQuestionsView.getSecurityOneAnsText().setText(user.getSecurityA1());
//                securityQuestionsView.getSecurityTwoAnsText().setText(user.getSecurityA2());

                new SecurityQuestionsController(securityQuestionsView);
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
