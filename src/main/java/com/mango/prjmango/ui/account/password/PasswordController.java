package com.mango.prjmango.ui.account.password;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.Encryption;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import lombok.SneakyThrows;

/**
 * Handles all user interaction with the Password & Security page.
 */
public class PasswordController {

    /**
     * Constructor. Instantiates the {@link PasswordView} and assigns {@link MouseListener}'s to specific
     * {@link JLabel}'s.
     *
     * @param view the {@link PasswordView} to be able to access the {@link JLabel}'s
     */
    public PasswordController(PasswordView view) {
        JLabel saveLabel                = view.getSaveLabel();
        JLabel showCurrentPasswordLabel = view.getShowCurrentPasswordLabel();
        JLabel showNewPasswordLabel     = view.getShowNewPasswordLabel();
        JLabel showConfirmPasswordLabel = view.getShowConfirmPasswordLabel();

        JPasswordField currentPasswordField = view.getCurrentPasswordTextBox();
        JPasswordField newPasswordField     = view.getNewPasswordTextBox();
        JPasswordField confirmPasswordField = view.getConfirmNewPassTextBox();

        saveLabel.addMouseListener(new SavePasswordSecurityMouseListener(view, saveLabel));
        showCurrentPasswordLabel.addMouseListener(
                new ShowPasswordMouseListener(showCurrentPasswordLabel, currentPasswordField));
        showNewPasswordLabel.addMouseListener(
                new ShowPasswordMouseListener(showNewPasswordLabel, newPasswordField));
        showConfirmPasswordLabel.addMouseListener(
                new ShowPasswordMouseListener(showConfirmPasswordLabel, confirmPasswordField));
    }

    private static class SavePasswordSecurityMouseListener implements MouseListener {

        private final PasswordView view;
        private final JLabel label;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link PasswordView} to access other {@link javax.swing.JComponent}'s
         * @param label the specific {@link JLabel}
         */
        public SavePasswordSecurityMouseListener(PasswordView view, JLabel label) {
            this.view  = view;
            this.label = label;
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
            view.getInformationLabel().setText("");

            JPasswordField currentPassField = view.getCurrentPasswordTextBox();
            JPasswordField newPassField     = view.getNewPasswordTextBox();
            JPasswordField confirmPassField = view.getConfirmNewPassTextBox();

            char[] currPass    = currentPassField.getPassword();
            char[] newPass     = newPassField.getPassword();
            char[] confirmPass = confirmPassField.getPassword();

            String currPassword = "";

            if (currPass.length != 0) {
                currPassword = DatabaseCommands.getUserPassword(currPass);
            } else {
                view.getInformationLabel().setText("Current password does not match our records!");
                view.getInformationLabel().setForeground(Colors.RED);
                return;
            }

            if (currPassword.length() == 0 || currPassword.equals(Encryption.encrypt(Arrays.toString(currPass)))) {
                if (Arrays.equals(newPass, confirmPass)) {
                    if (newPass.length == 0) {
                        view.getInformationLabel().setText("Passwords cannot be length 0!");
                        view.getInformationLabel().setForeground(Colors.RED);
                    } else {
                        displayInformationText();

                        DatabaseCommands.updateUserPassword(newPass);
                    }
                } else {
                    view.getInformationLabel().setText("New password does not match the confirmation password!");
                    view.getInformationLabel().setForeground(Colors.RED);
                }
            } else {
                view.getInformationLabel().setText("Current password does not match our records!");
                view.getInformationLabel().setForeground(Colors.RED);
            }
        }

        private void displayInformationText() {
            view.getInformationLabel().setText("Information successfully changed!");
            view.getInformationLabel().setForeground(Color.GREEN);

            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            view.getInformationLabel().setText("");
                            view.getCurrentPasswordTextBox().setText("");
                            view.getNewPasswordTextBox().setText("");
                            view.getConfirmNewPassTextBox().setText("");

                            view.getShowCurrentPasswordLabel().setIcon(
                                    ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
                            view.getShowNewPasswordLabel().setIcon(
                                    ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
                            view.getShowConfirmPasswordLabel().setIcon(
                                    ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());

                            view.getCurrentPasswordTextBox().requestFocus();
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
            label.setIcon(ImageIcons.PASSWORD_SECURITY_SAVE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.PASSWORD_SECURITY_SAVE_NO_HOVER.getImageIcon());
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

    private static class ShowPasswordMouseListener implements MouseListener {

        private final JLabel label;
        private final JPasswordField passwordField;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param label         the corresponding "eye" {@link ImageIcon} that the user is interacting with
         * @param passwordField the corresponding {@link JPasswordField} that will change the text
         */
        public ShowPasswordMouseListener(JLabel label, JPasswordField passwordField) {
            this.label         = label;
            this.passwordField = passwordField;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            if (passwordField.getEchoChar() == '•') {
                passwordField.setEchoChar((char) 0);
                label.setIcon(ImageIcons.PASSWORD_CLOSED_EYE_NO_HOVER.getImageIcon());
            } else {
                passwordField.setEchoChar('•');
                label.setIcon(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
            }
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            if (label.getIcon().equals(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon())) {
                label.setIcon(ImageIcons.PASSWORD_OPEN_EYE_HOVERED.getImageIcon());
            }

            if (label.getIcon().equals(ImageIcons.PASSWORD_CLOSED_EYE_NO_HOVER.getImageIcon())) {
                label.setIcon(ImageIcons.PASSWORD_CLOSED_EYE_HOVERED.getImageIcon());
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
            if (label.getIcon().equals(ImageIcons.PASSWORD_OPEN_EYE_HOVERED.getImageIcon())) {
                label.setIcon(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
            }

            if (label.getIcon().equals(ImageIcons.PASSWORD_CLOSED_EYE_HOVERED.getImageIcon())) {
                label.setIcon(ImageIcons.PASSWORD_CLOSED_EYE_NO_HOVER.getImageIcon());
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