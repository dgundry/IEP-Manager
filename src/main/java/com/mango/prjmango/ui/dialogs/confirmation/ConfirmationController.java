package com.mango.prjmango.ui.dialogs.confirmation;

import com.mango.prjmango.Main;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.activities.sightwords.SightController;
import com.mango.prjmango.ui.activities.sightwords.SightView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.login.LoginController;
import com.mango.prjmango.ui.login.LoginView;
import com.mango.prjmango.ui.sideoptions.SideOptionsView;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.Tabs;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * Handles all user interaction with the pop-up dialogs.
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

                    SideOptionsView.getAccountTabLabel().setIcon(ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon());
                    SideOptionsView.getStudentsTabLabel().setIcon(ImageIcons.STUDENT_TAB_HOVERED.getImageIcon());
                    SideOptionsView.getActivitiesTabLabel().setIcon(ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
                    SideOptionsView.getReportsTabLabel().setIcon(ImageIcons.REPORTS_TAB_NO_HOVER.getImageIcon());
                    MainWindowView.setCurrentlyActiveTab(Tabs.STUDENTS);

                    view.dispose();

                    LoginView loginView = new LoginView();
                    new LoginController(loginView);
                    MainWindowView.setActiveDisplay(loginView);

                    Main.setActiveUser(null);
                    break;
                case 1:
                    DatabaseConnection.closeConnection();
                    view.dispose();
                    System.exit(0);
                    break;
                case 2:
                    view.dispose();

                    SightView fryView = new SightView();
                    new SightController(fryView);
                    ActivitiesView.setActiveDisplay(fryView);

                    break;
                case 3:
                    view.dispose();

                    LoginView logView = new LoginView();
                    new LoginController(logView);
                    MainWindowView.setActiveDisplay(logView);

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
            switch(selectedDialog.ordinal()) {
                case 0:
                    label.setIcon(ImageIcons.APP_LOG_OUT_HOVERED.getImageIcon());
                    break;
                case 1:
                    label.setIcon(ImageIcons.APP_EXIT_HOVERED.getImageIcon());
                    break;
                case 2:
                case 3:
                    label.setIcon(ImageIcons.OK_BUTTON_HOVERED.getImageIcon());
                    break;
                default:
                    break;
            }
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            switch(selectedDialog.ordinal()) {
                case 0:
                    label.setIcon(ImageIcons.APP_LOG_OUT_NO_HOVER.getImageIcon());
                    break;
                case 1:
                    label.setIcon(ImageIcons.APP_EXIT_NO_HOVER.getImageIcon());
                    break;
                case 2:
                case 3:
                    label.setIcon(ImageIcons.OK_BUTTON_NO_HOVER.getImageIcon());
                    break;
                default:
                    break;
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
