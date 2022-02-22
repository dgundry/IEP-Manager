package com.mango.prjmango.windows.dialogs.applicationexit;

import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.Images;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class ApplicationExitController {

    /**
     * Constructor. Adds {@link MouseListener}'s to specific {@link JLabel}'s on the {@link ApplicationExitView}.
     *
     * @param view the {@link ApplicationExitView} to access the specific {@link JLabel}'s
     */
    public ApplicationExitController(ApplicationExitView view) {
        JLabel exitLabel = view.getExitLabel();
        JLabel cancelLabel = view.getCancelLabel();

        exitLabel.addMouseListener(new ExitLabelMouseListener(view, exitLabel));
        cancelLabel.addMouseListener(new CancelLabelMouseListener(view, cancelLabel));
    }

    private static class ExitLabelMouseListener implements MouseListener {

        private final ApplicationExitView view;
        private final JLabel label;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link ApplicationExitView} so we can access methods within the class
         * @param label the specific {@link JLabel}
         */
        public ExitLabelMouseListener(ApplicationExitView view, JLabel label) {
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
            DatabaseConnection.closeConnection();
            view.dispose();
            System.exit(0);
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
            label.setIcon(Images.APP_EXIT_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(Images.APP_EXIT_NO_HOVER.getImageIcon());
        }
    }

    private static class CancelLabelMouseListener implements MouseListener {

        private final ApplicationExitView view;
        private final JLabel label;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link ApplicationExitView} so we can access methods within the class
         * @param label the specific {@link JLabel}
         */
        public CancelLabelMouseListener(ApplicationExitView view, JLabel label) {
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
            label.setIcon(Images.APP_CANCEL_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(Images.APP_CANCEL_NO_HOVER.getImageIcon());
        }
    }
}
