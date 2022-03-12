package com.mango.prjmango.windows.createaccount.securityquestions;

import com.mango.prjmango.utilities.User;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.createaccount.basicinfo.BasicInfoController;
import com.mango.prjmango.windows.createaccount.basicinfo.BasicInfoView;
import com.mango.prjmango.windows.createaccount.password.PasswordController;
import com.mango.prjmango.windows.createaccount.password.PasswordView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * This class handles all user interaction with the Security Questions page within the
 * Create Account section.
 */
public class SecurityQuestionsController {

    /**
     * Constructor. Adds {@link MouseListener}'s to specific {@link JLabel}'s that the user
     * will be interacting with.
     *
     * @param view the {@link SecurityQuestionsView} so we can access {@link JComponent}'s
     * @param user the current {@link User} object that is creating their account
     */
    public SecurityQuestionsController(SecurityQuestionsView view, User user) {
        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel, user));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel, user));

        view.getSecurityQuestion1ComboBox().setSelectedIndex(user.getSecurityQ1());
        view.getSecurityQuestion2ComboBox().setSelectedIndex(user.getSecurityQ2());
        view.getAnswer1TextField().setText(user.getSecurityA1());
        view.getAnswer2TextField().setText(user.getSecurityA2());
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final SecurityQuestionsView view;
        private final JLabel label;
        private final User user;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link SecurityQuestionsView} so we can access other {@link JComponent}'s
         * @param label the specific {@link JLabel}
         * @param user  the {@link User} object that is currently creating their account
         */
        public NextLabelMouseListener(SecurityQuestionsView view, JLabel label, User user) {
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
            view.getInvalidAnswer1Label().setText(" ");
            view.getInvalidAnswer2Label().setText(" ");

            int question1Index = view.getSecurityQuestion1ComboBox().getSelectedIndex();
            int question2Index = view.getSecurityQuestion2ComboBox().getSelectedIndex();

            String answer1 = view.getAnswer1TextField().getText().trim();
            String answer2 = view.getAnswer2TextField().getText().trim();

            if (question1Index == question2Index) {
                view.getInvalidAnswer2Label().setText("Cannot use the same security questions.");
            } else if (answer1.equals("")) {
                view.getInvalidAnswer1Label().setText("Answer #1 cannot be blank!");
            } else if (answer2.equals("")) {
                view.getInvalidAnswer2Label().setText("Answer #2 cannot be blank!");
            } else {
                user.setSecurityQ1(question1Index);
                user.setSecurityQ2(question2Index);
                user.setSecurityA1(answer1);
                user.setSecurityA2(answer2);

                PasswordView passwordView = new PasswordView();
                new PasswordController(passwordView, user);
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
        private final User user;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param label the specific {@link JLabel}
         * @param user  the current {@link User} object that is creating their account
         */
        public BackLabelMouseListener(JLabel label, User user) {
            this.label = label;
            this.user  = user;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            BasicInfoView basicInfoView = new BasicInfoView();
            new BasicInfoController(basicInfoView, user);
            MainWindowView.setActiveDisplay(basicInfoView);
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
