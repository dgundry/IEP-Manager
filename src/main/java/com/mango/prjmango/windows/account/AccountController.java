package com.mango.prjmango.windows.account;

import com.mango.prjmango.utilities.Images;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class AccountController {

    private static boolean tabIsSelected = false;

    public AccountController(AccountView view) {
        JLabel editProfileLabel = view.getEditProfileLabel();
        JLabel passwordSecurityLabel = view.getPasswordSecurityLabel();

        editProfileLabel.addMouseListener(new EditProfileMouseListener(view, editProfileLabel));
        passwordSecurityLabel.addMouseListener(new PasswordSecurityMouseListener(view, passwordSecurityLabel));
    }

    private static class EditProfileMouseListener implements MouseListener {

        private final AccountView view;
        private final JLabel label;

        public EditProfileMouseListener(AccountView view, JLabel label) {
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
            tabIsSelected = true;
            label.setIcon(Images.EDIT_PROFILE_SELECTED.getImageIcon());
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            //display edit profile components
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            if (tabIsSelected) {
                label.setIcon(Images.EDIT_PROFILE_SELECTED.getImageIcon());
            } else {
                label.setIcon(Images.EDIT_PROFILE_HOVERED.getImageIcon());
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
            if (tabIsSelected) {
                label.setIcon(Images.EDIT_PROFILE_SELECTED.getImageIcon());
            } else {
                label.setIcon(Images.EDIT_PROFILE_NO_HOVER.getImageIcon());
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

    private static class PasswordSecurityMouseListener implements MouseListener {

        private final AccountView view;
        private final JLabel label;

        public PasswordSecurityMouseListener(AccountView view, JLabel label) {
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
            label.setIcon(Images.PASSWORD_SECURITY_SELECTED.getImageIcon());
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            //Password security components
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(Images.PASSWORD_SECURITY_HOVERED.getImageIcon());
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(Images.PASSWORD_SECURITY_NO_HOVER.getImageIcon());
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */  }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }
}
