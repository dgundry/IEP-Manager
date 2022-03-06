package com.mango.prjmango.windows.account.editprofile;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.EmailValidation;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Handles all user interaction with the Edit Profile page.
 */
public class EditProfileController {

    /**
     * Constructor. Instantiates the {@link EditProfileView} and assigns {@link MouseListener}'s to specific
     * {@link JLabel}'s.
     *
     * @param view the {@link EditProfileView} to be able to access the {@link JLabel}'s
     */
    public EditProfileController(EditProfileView view) {
        JLabel saveLabel = view.getSaveLabel();
        JLabel firstNameEditLabel = view.getFirstNameEditLabel();
        JLabel lastNameEditLabel  = view.getLastNameEditLabel();
        JLabel emailEditLabel     = view.getEmailEditLabel();

        JTextField firstNameTextField = view.getFirstNameTextField();
        JTextField lastNameTextField  = view.getLastNameTextField();
        JTextField emailTextField     = view.getEmailTextField();

        saveLabel.addMouseListener(new SaveProfileMouseListener(view, saveLabel));
        firstNameEditLabel.addMouseListener(new EditLabelMouseListener(view, firstNameEditLabel, firstNameTextField));
        lastNameEditLabel.addMouseListener(new EditLabelMouseListener(view, lastNameEditLabel, lastNameTextField));
        emailEditLabel.addMouseListener(new EditLabelMouseListener(view, emailEditLabel, emailTextField));
    }

    private static class SaveProfileMouseListener implements MouseListener {

        private final EditProfileView view;
        private final JLabel label;

        private final Color RED = new Color(252, 45, 45);
        private final Color GREEN = new Color(14, 249, 9);

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link EditProfileView} to access other {@link JComponent}'s
         * @param label the specific {@link JLabel}
         */
        public SaveProfileMouseListener(EditProfileView view, JLabel label) {
            this.view = view;
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
            view.getInformationLabel().setText("");

            String firstName = view.getFirstNameTextField().getText().trim();
            String lastName  = view.getLastNameTextField().getText().trim();
            String email     = view.getEmailTextField().getText().trim();

            if (isBlankFirstName(firstName)) {
                view.getInformationLabel().setText("Please enter a valid first name!");
                view.getInformationLabel().setForeground(RED);
            } else if (isBlankLastName(lastName)) {
                view.getInformationLabel().setText("Please enter a valid last name!");
                view.getInformationLabel().setForeground(RED);
            } else {
                if (isBlankEmail(email) || !EmailValidation.patternMatches(email)) {
                    view.getInformationLabel().setText("Please enter a valid email!");
                    view.getInformationLabel().setForeground(RED);
                } else if (DatabaseCommands.isEmailTaken(email) && !email.equals(LoggedInUser.getEmail())) {
                    view.getInformationLabel().setText("Email address is taken. Please try again!");
                    view.getInformationLabel().setForeground(RED);
                } else {
                    DatabaseCommands.updateUserDetails(firstName, lastName, email);
                    displayInformationText("Information successfully changed!", GREEN);
                    LoggedInUser.setFirstName(firstName);
                    LoggedInUser.setLastName(lastName);
                    LoggedInUser.setEmail(email);
                    SideOptionsView.getWelcomeLabel().setText("Welcome, " + LoggedInUser.getFirstName() + "!");
                }
            }
        }

        private void displayInformationText(String text, Color fontColor) {
            view.getInformationLabel().setText(text);
            view.getInformationLabel().setForeground(fontColor);

            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            view.getInformationLabel().setText("");
                            view.getFirstNameTextField().setEnabled(false);
                            view.getLastNameTextField().setEnabled(false);
                            view.getEmailTextField().setEnabled(false);

                            view.getFirstNameEditLabel().setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
                            view.getLastNameEditLabel().setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
                            view.getEmailEditLabel().setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
                        }
                    },
                    5000
            );
        }

        private boolean isBlankFirstName(String firstName) {
            return firstName.equals("");
        }

        private boolean isBlankLastName(String lastName) {
            return lastName.equals("");
        }

        private boolean isBlankEmail(String email) {
            return email.equals("");
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());
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

    private static class EditLabelMouseListener implements MouseListener {

        private final EditProfileView view;
        private final JLabel label;
        private final JTextField textField;

        private boolean isActive = false;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view      the {@link EditProfileView} to access other {@link JComponent}'s
         * @param label     the specific {@link JLabel}
         * @param textField the specific {@link JTextField}
         */
        public EditLabelMouseListener(EditProfileView view, JLabel label, JTextField textField) {
            this.view = view;
            this.label = label;
            this.textField = textField;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            if (textField.isEnabled()) {
                textField.setEnabled(false);
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            } else {
                textField.setEnabled(true);
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon());
            }

            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            if (label.getIcon().equals(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon())) {
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon());
            }

            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            if (label.getIcon().equals(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon())) {
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            }

            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
