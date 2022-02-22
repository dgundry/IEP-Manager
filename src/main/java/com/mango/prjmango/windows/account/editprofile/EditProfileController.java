package com.mango.prjmango.windows.account.editprofile;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.EmailValidation;
import com.mango.prjmango.utilities.Images;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JLabel;

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

        saveLabel.addMouseListener(new SaveProfileMouseListener(view, saveLabel));
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
            String firstName = view.getFirstNameTextField().getText().trim();
            String lastName = view.getLastNameTextField().getText().trim();
            String email = view.getEmailTextField().getText().trim();

            if (EmailValidation.patternMatches(email)) {
                if (DatabaseCommands.isEmailTaken(email)) {
                    System.out.println("Email taken.");
                    //display error jlabel on panel
                } else {
                    DatabaseCommands.updateUserDetails(firstName, lastName, email);
                    System.out.println("Updated!");
                    //display success jlabel on panel
                }
            } else {
                System.out.println("Invalid email");
                //display valid email jlabel on panel
            }
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(Images.EDIT_PROFILE_SAVE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(Images.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());
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
