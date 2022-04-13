package com.mango.prjmango.ui.account.editprofile;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.EmailValidation;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.sideoptions.SideOptionsView;
import com.mango.prjmango.utilities.dbcommands.UserCommands;
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
        PencilEditor firstNameEditLabel = view.getFirstNameEditLabel();
        PencilEditor lastNameEditLabel  = view.getLastNameEditLabel();
        PencilEditor emailEditLabel     = view.getEmailEditLabel();

        JTextField firstNameTextField = view.getFirstNameTextField();
        JTextField lastNameTextField  = view.getLastNameTextField();
        JTextField emailTextField     = view.getEmailTextField();

        saveLabel.addMouseListener(new SaveProfileMouseListener(view, saveLabel));
        firstNameEditLabel.addMouseListener(new EditLabelMouseListener(
                firstNameEditLabel, firstNameTextField));
        lastNameEditLabel.addMouseListener(new EditLabelMouseListener(
                lastNameEditLabel, lastNameTextField));
        emailEditLabel.addMouseListener(new EditLabelMouseListener(
                emailEditLabel, emailTextField));
    }

    private static class SaveProfileMouseListener implements MouseListener {

        private final EditProfileView view;
        private final JLabel label;

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
                view.getInformationLabel().setForeground(Color.RED);
            } else if (isBlankLastName(lastName)) {
                view.getInformationLabel().setText("Please enter a valid last name!");
                view.getInformationLabel().setForeground(Color.RED);
            } else {
                if (isBlankEmail(email) || !EmailValidation.patternMatches(email)) {
                    view.getInformationLabel().setText("Please enter a valid email!");
                    view.getInformationLabel().setForeground(Color.RED);
                } else if (DatabaseCommands.isEmailTaken(email) && !email.equals(LoggedInUser.getEmail())) {
                    view.getInformationLabel().setText("Email address is taken. Please try again!");
                    view.getInformationLabel().setForeground(Color.RED);
                } else {
                    UserCommands.updateUserDetails(firstName, lastName, email, LoggedInUser.getTeacherId());
                    displayInformationText();
                    LoggedInUser.setFirstName(firstName);
                    LoggedInUser.setLastName(lastName);
                    LoggedInUser.setEmail(email);
                    SideOptionsView.updateWelcomeMessage();
                }
            }
        }

        private void displayInformationText() {
            view.getFirstNameEditLabel().setInEditMode(false);
            view.getLastNameEditLabel().setInEditMode(false);
            view.getEmailEditLabel().setInEditMode(false);

            view.getInformationLabel().setText("Information successfully changed!");
            view.getInformationLabel().setForeground(Color.GREEN);

            view.getFirstNameTextField().setEnabled(false);
            view.getLastNameTextField().setEnabled(false);
            view.getEmailTextField().setEnabled(false);

            view.getFirstNameEditLabel().setIcon(
                    ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            view.getLastNameEditLabel().setIcon(
                    ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            view.getEmailEditLabel().setIcon(
                    ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());

            view.getFirstNameTextField().requestFocus();

            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            view.getInformationLabel().setText(" ");
                        }
                    },
                    3000
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

        private final PencilEditor label;
        private final JTextField textField;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param label     the specific {@link PencilEditor}
         * @param textField the specific {@link JTextField}
         */
        public EditLabelMouseListener(PencilEditor label, JTextField textField) {
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
            if (label.isInEditMode()) {
                label.setInEditMode(false);
                textField.setEnabled(false);
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            } else {
                label.setInEditMode(true);
                textField.setEnabled(true);
                textField.requestFocus();
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
            if (!label.isInEditMode()) {
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
            if (!label.isInEditMode()) {
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
