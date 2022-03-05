package com.mango.prjmango.windows.sideoptions;

import com.mango.prjmango.utilities.ImageIcons;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.windows.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.windows.dialogs.confirmation.Dialogs;
import com.mango.prjmango.windows.sideoptions.listeners.TabListeners;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class SideOptionsController {

    public SideOptionsController(SideOptionsView view) {
        JLabel accountTabLabel    = view.getAccountTabLabel();
        JLabel studentsTabLabel   = view.getStudentsTabLabel();
        JLabel activitiesTabLabel = view.getActivitiesTabLabel();
        JLabel reportsTabLabel    = view.getReportsTabLabel();
        JLabel logOutLabel        = view.getLogOutLabel();

        accountTabLabel.addMouseListener(new TabListeners(
                accountTabLabel,
                ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.ACCOUNT_TAB_HOVERED.getImageIcon(),
                Tabs.ACCOUNT,
                view));
        studentsTabLabel.addMouseListener(new TabListeners(
                studentsTabLabel,
                ImageIcons.STUDENT_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.STUDENT_TAB_HOVERED.getImageIcon(),
                Tabs.STUDENTS,
                view));
        activitiesTabLabel.addMouseListener(new TabListeners(
                activitiesTabLabel,
                ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_TAB_HOVERED.getImageIcon(),
                Tabs.ACTIVITIES,
                view));
        reportsTabLabel.addMouseListener(new TabListeners(
                reportsTabLabel,
                ImageIcons.REPORTS_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.REPORTS_TAB_HOVERED.getImageIcon(),
                Tabs.REPORTS,
                view));
        logOutLabel.addMouseListener(new LogOutLabelMouseListener(view, logOutLabel));
    }

    private static class LogOutLabelMouseListener implements MouseListener {

        private final SideOptionsView view;
        private final JLabel label;

        public LogOutLabelMouseListener(SideOptionsView view, JLabel label) {
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
            ConfirmationView confirmationView =
                    new ConfirmationView("Are you sure want to log out?", Dialogs.LOG_OUT);
            new ConfirmationController(confirmationView);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setIcon(ImageIcons.LOG_OUT_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            label.setIcon(ImageIcons.LOG_OUT_NO_HOVER.getImageIcon());
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
