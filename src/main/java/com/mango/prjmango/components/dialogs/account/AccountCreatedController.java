package com.mango.prjmango.components.dialogs.account;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
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

    /**
     * Constructor. Sets up the listeners for specific {@link JComponent}'s.
     * @param view the {@link AccountCreatedView} to access the specific {@link JComponent}'s
     */
    public AccountCreatedController(AccountCreatedView view) {
        view.getOkLabel().addMouseListener(new OkLabelMouseListener(view.getOkLabel(), view));
    }

    private static class OkLabelMouseListener implements MouseListener {

        private final JLabel okLabel;

        private final AccountCreatedView view;

        /**
         * Constructor. Initializes instance variables that will be used within the classes.
         *
         * @param okLabel the "Ok" button which is a {@link JLabel}
         * @param view    the {@link AccountCreatedView} to access {@link JComponent}'s within the class
         */
        public OkLabelMouseListener(JLabel okLabel, AccountCreatedView view) {
            this.okLabel = okLabel;
            this.view = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            view.dispose();
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            okLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            //okLabel.setIcon(ImageIcons.OK_HOVER_ICON);
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            okLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            //okLabel.setIcon(ImageIcons.OK_NO_HOVER_ICON);
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
