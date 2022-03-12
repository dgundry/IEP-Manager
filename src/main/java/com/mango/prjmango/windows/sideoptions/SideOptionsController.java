package com.mango.prjmango.windows.sideoptions;

import com.mango.prjmango.Main;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.windows.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.windows.dialogs.confirmation.Dialogs;
import com.mango.prjmango.windows.sideoptions.listeners.TabListeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

import static com.mango.prjmango.utilities.Tabs.STUDENTS;

public class SideOptionsController {

    public SideOptionsController() {
        JLabel accountTabLabel    = SideOptionsView.getAccountTabLabel();
        JLabel studentsTabLabel   = SideOptionsView.getStudentsTabLabel();
        JLabel activitiesTabLabel = SideOptionsView.getActivitiesTabLabel();
        JLabel reportsTabLabel    = SideOptionsView.getReportsTabLabel();
        JLabel logOutLabel        = SideOptionsView.getLogOutLabel();

        accountTabLabel.addMouseListener(new TabListeners(
                accountTabLabel,
                ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.ACCOUNT_TAB_HOVERED.getImageIcon(),
                Tabs.ACCOUNT));
        studentsTabLabel.addMouseListener(new TabListeners(
                studentsTabLabel,
                ImageIcons.STUDENT_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.STUDENT_TAB_HOVERED.getImageIcon(),
                STUDENTS));
        activitiesTabLabel.addMouseListener(new TabListeners(
                activitiesTabLabel,
                ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_TAB_HOVERED.getImageIcon(),
                Tabs.ACTIVITIES));
        reportsTabLabel.addMouseListener(new TabListeners(
                reportsTabLabel,
                ImageIcons.REPORTS_TAB_NO_HOVER.getImageIcon(),
                ImageIcons.REPORTS_TAB_HOVERED.getImageIcon(),
                Tabs.REPORTS));
        logOutLabel.addMouseListener(new LogOutLabelMouseListener(logOutLabel));
    }

    private static class LogOutLabelMouseListener implements MouseListener {

        private final JLabel label;

        public LogOutLabelMouseListener(JLabel label) {
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
