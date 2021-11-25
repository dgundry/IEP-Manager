package com.mango.prjmango.components.dialogs.account;

import com.mango.prjmango.utilities.ImageIcons;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * This class handles all user interaction with the
 * {@link AccountCreatedView}.
 *
 * @author  Kellen Campbell
 * @version 1.0
 * @since   2021-11-25
 */
public class AccountCreatedController {

    public AccountCreatedController(AccountCreatedView view) {
        view.getOkLabel().addMouseListener(new OkLabelMouseListener(view.getOkLabel(), view));
    }

    private static class OkLabelMouseListener implements MouseListener {

        private final JLabel okLabel;

        private final AccountCreatedView view;

        public OkLabelMouseListener(JLabel okLabel, AccountCreatedView view) {
            this.okLabel = okLabel;
            this.view = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the mouse event
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            view.dispose();
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the mouse event
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the mouse event
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the mouse event
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            okLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            okLabel.setIcon(ImageIcons.OK_HOVER_ICON);
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the mouse event
         */
        @Override
        public void mouseExited(MouseEvent e) {
            okLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            okLabel.setIcon(ImageIcons.OK_NO_HOVER_ICON);
        }
    }
}
