package com.mango.prjmango.windows.dialogs.confirmation;

import com.mango.prjmango.Main;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.ImageIcons;
import com.mango.prjmango.utilities.Images;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.login.LoginController;
import com.mango.prjmango.windows.login.LoginView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * Handles all user interaction
 */
public class ConfirmationController {

    /**
     * Constructor. Adds {@link MouseListener}'s to specific {@link JLabel}'s on the {@link ConfirmationView}.
     *
     * @param view the {@link ConfirmationView} to access the specific {@link JLabel}'s
     */
    public ConfirmationController(ConfirmationView view) {
        JLabel exitLabel = view.getExitLabel();
        JLabel cancelLabel = view.getCancelLabel();

        exitLabel.addMouseListener(new ExitLabelMouseListener(view, exitLabel, view.getSelectedDialog()));
        cancelLabel.addMouseListener(new CancelLabelMouseListener(view, cancelLabel));
    }

    private static class ExitLabelMouseListener implements MouseListener {

        private final ConfirmationView view;
        private final JLabel label;
        private final Dialogs selectedDialog;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view           the {@link ConfirmationView} so we can access methods within the class
         * @param label          the specific {@link JLabel}
         * @param selectedDialog the specific {@link Dialogs}
         */
        public ExitLabelMouseListener(ConfirmationView view, JLabel label, Dialogs selectedDialog) {
            this.view = view;
            this.label = label;
            this.selectedDialog = selectedDialog;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (selectedDialog.ordinal()) {
                case 0:
                    view.dispose();

                    LoginView loginView = new LoginView();
                    new LoginController(loginView);

                    MainWindowView.setActiveDisplay(loginView);
                    Main.activeUser = null;
                    break;
                case 1:
                    DatabaseConnection.closeConnection();
                    view.dispose();
                    System.exit(0);
                    break;
                default:
                    break;
            }
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

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            if (selectedDialog == Dialogs.CLOSE_APPLICATION) {
                label.setIcon(ImageIcons.APP_EXIT_HOVERED.getImageIcon());
            } else {
                label.setIcon(ImageIcons.APP_LOG_OUT_HOVERED.getImageIcon());
            }
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            if (selectedDialog == Dialogs.CLOSE_APPLICATION) {
                label.setIcon(ImageIcons.APP_EXIT_NO_HOVER.getImageIcon());
            } else {
                label.setIcon(ImageIcons.APP_LOG_OUT_NO_HOVER.getImageIcon());
            }
        }
    }

    private static class CancelLabelMouseListener implements MouseListener {

        private final ConfirmationView view;
        private final JLabel label;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link ConfirmationView} so we can access methods within the class
         * @param label the specific {@link JLabel}
         */
        public CancelLabelMouseListener(ConfirmationView view, JLabel label) {
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
            view.dispose();
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

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.APP_CANCEL_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.APP_CANCEL_NO_HOVER.getImageIcon());
        }
    }
}
