package com.mango.prjmango.windows.account.passwordsecurity;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.Encryption;
import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import lombok.SneakyThrows;

/**
 * Handles all user interaction with the Password & Security page.
 */
public class PasswordSecurityController {

    /**
     * Constructor. Instantiates the {@link PasswordSecurityView} and assigns {@link MouseListener}'s to specific
     * {@link JLabel}'s.
     *
     * @param view the {@link PasswordSecurityView} to be able to access the {@link JLabel}'s
     */
    public PasswordSecurityController(PasswordSecurityView view) {
        JLabel saveLabel = view.getSaveLabel();

        saveLabel.addMouseListener(new SavePasswordSecurityMouseListener(view, saveLabel));
    }

    private static class SavePasswordSecurityMouseListener implements MouseListener {

        private final PasswordSecurityView view;
        private final JLabel label;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link PasswordSecurityView} to access other {@link javax.swing.JComponent}'s
         * @param label the specific {@link JLabel}
         */
        public SavePasswordSecurityMouseListener(PasswordSecurityView view, JLabel label) {
            this.view = view;
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
            JPasswordField newPassField = view.getNewPasswordTextBox();
            JPasswordField confirmPassField = view.getConfirmNewPassTextBox();

            char[] currPass = currentPassField.getPassword();
            char[] newPass = newPassField.getPassword();
            char[] confirmPass = confirmPassField.getPassword();

            String currPassword = DatabaseCommands.getUserPassword(currPass);

            if (currPassword.equals(Encryption.encryptPassword(Arrays.toString(currPass)))) {
                if (Arrays.equals(newPass, confirmPass)) {
                    if (newPass.length == 0) {
                        view.getInformationLabel().setText("Passwords cannot be length 0!");
                        view.getInformationLabel().setForeground(Colors.RED);
                    } else {
                        displayInformationText("Information successfully changed!", Colors.GREEN);

                        DatabaseCommands.updateUserPassword(newPass);

                        currentPassField.setText("");
                        newPassField.setText("");
                        confirmPassField.setText("");
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

        private void displayInformationText(String text, Color fontColor) {
            view.getInformationLabel().setText(text);
            view.getInformationLabel().setForeground(fontColor);

            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            view.getInformationLabel().setText("");
                        }
                    },
                    5000
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
}
