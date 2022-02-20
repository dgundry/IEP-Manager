package com.mango.prjmango.windows.account.editprofile;

import com.mango.prjmango.utilities.Images;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class EditProfileController {

    public EditProfileController(EditProfileView view) {
        JLabel saveLabel = view.getSaveLabel();

        saveLabel.addMouseListener(new SaveProfileMouseListener(view, saveLabel));
    }

    private static class SaveProfileMouseListener implements MouseListener {

        private final EditProfileView view;
        private final JLabel label;

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
            //verify email isnt taken
            //then update the database
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
