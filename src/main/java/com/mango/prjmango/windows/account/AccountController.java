package com.mango.prjmango.windows.account;

import com.mango.prjmango.utilities.Images;
import com.mango.prjmango.windows.account.editprofile.EditProfileController;
import com.mango.prjmango.windows.account.editprofile.EditProfileView;
import com.mango.prjmango.windows.account.passwordsecurity.PasswordSecurityController;
import com.mango.prjmango.windows.account.passwordsecurity.PasswordSecurityView;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
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

        /**
         * Constructor. Instantiates instance variables that will be used in the {@link MouseListener} methods.
         *
         * @param view  the {@link AccountView} to access methods within or other {@link JComponent}'s
         * @param label the {@link JLabel} that the user is interacting with
         */
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

            EditProfileView editProfileView = new EditProfileView();
            new EditProfileController(editProfileView);

            view.setLayout(editProfileView); //<---sets the panel to display
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

        /**
         * Constructor. Instantiates instance variables that will be used in the {@link MouseListener} methods.
         *
         * @param view  the {@link AccountView} to access methods within or other {@link JComponent}'s
         * @param label the {@link JLabel} that the user is interacting with
         */
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

            PasswordSecurityView passwordSecurityView = new PasswordSecurityView();
            new PasswordSecurityController(passwordSecurityView);

            view.setLayout(passwordSecurityView);
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
