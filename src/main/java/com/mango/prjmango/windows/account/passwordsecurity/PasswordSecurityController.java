package com.mango.prjmango.windows.account.passwordsecurity;

import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

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
        @Override
        public void mouseClicked(MouseEvent e) {

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
