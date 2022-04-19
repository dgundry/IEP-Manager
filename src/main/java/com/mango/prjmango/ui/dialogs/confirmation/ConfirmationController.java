package com.mango.prjmango.ui.dialogs.confirmation;

import com.mango.prjmango.Main;
import com.mango.prjmango.assignment.Assignments;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.activities.math.MathController;
import com.mango.prjmango.ui.activities.math.MathView;
import com.mango.prjmango.ui.activities.sightwords.SightController;
import com.mango.prjmango.ui.activities.sightwords.SightView;
import com.mango.prjmango.ui.activities.upload.UploadController;
import com.mango.prjmango.ui.activities.upload.UploadView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.login.LoginController;
import com.mango.prjmango.ui.login.LoginView;
import com.mango.prjmango.ui.sideoptions.SideOptionsView;
import com.mango.prjmango.ui.students.StudentsView;
import com.mango.prjmango.ui.students.view.ViewStudentController;
import com.mango.prjmango.ui.students.view.ViewStudentView;
import com.mango.prjmango.ui.students.view.reports.ReportsController;
import com.mango.prjmango.ui.students.view.reports.ReportsView;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.utilities.dbcommands.StudentCommands;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Handles all user interaction with the pop-up dialogs.
 */
public class ConfirmationController {

    /**
     * Constructor. Adds {@link MouseListener}'s to specific {@link JLabel}'s on the {@link ConfirmationView}.
     *
     * @param view the {@link ConfirmationView} to access the specific {@link JLabel}'s
     */
    private int studentID = 0;
    private int assignmentID = 0;
    public ConfirmationController(ConfirmationView view) {
        JLabel exitLabel = view.getExitLabel();
        JLabel cancelLabel = view.getCancelLabel();

        exitLabel.addMouseListener(new ExitLabelMouseListener(view, exitLabel, view.getSelectedDialog(),assignmentID,studentID));
        cancelLabel.addMouseListener(new CancelLabelMouseListener(view, cancelLabel));
    }
    public ConfirmationController(ConfirmationView view,int studentID, int assignmentID) {
        this.assignmentID = assignmentID;
        this.studentID = studentID;
        JLabel exitLabel = view.getExitLabel();
        JLabel cancelLabel = view.getCancelLabel();

        exitLabel.addMouseListener(new ExitLabelMouseListener(view, exitLabel, view.getSelectedDialog(),assignmentID,studentID));
        cancelLabel.addMouseListener(new CancelLabelMouseListener(view, cancelLabel));
    }

    private static class ExitLabelMouseListener implements MouseListener {

        private final ConfirmationView view;
        private final JLabel label;
        private final Dialogs selectedDialog;
        private final int assignmentID;
        private final int studentID;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view           the {@link ConfirmationView} so we can access methods within the class
         * @param label          the specific {@link JLabel}
         * @param selectedDialog the specific {@link Dialogs}
         */
        public ExitLabelMouseListener(ConfirmationView view, JLabel label, Dialogs selectedDialog, int assignmentID, int studentID) {
            this.view = view;
            this.label = label;
            this.selectedDialog = selectedDialog;
            this.assignmentID = assignmentID;
            this.studentID = studentID;


            view.addKeyListener(new KeyListener() {

                LoginView loginView;

                /**
                 * Handles the keyTyped event by invoking the
                 * keyTyped methods on listener-a and listener-b.
                 *
                 * @param e the {@link KeyEvent}
                 */
                @Override
                public void keyTyped(KeyEvent e) { /* Not needed */ }

                /**
                 * Handles the keyPressed event by invoking the
                 * keyPressed methods on listener-a and listener-b.
                 *
                 * @param e the {@link KeyEvent}
                 */
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        switch (selectedDialog.ordinal()) {
                            case 0:

                                SideOptionsView.getAccountTabLabel().setIcon(ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon());
                                SideOptionsView.getStudentsTabLabel().setIcon(ImageIcons.STUDENT_TAB_HOVERED.getImageIcon());
                                SideOptionsView.getActivitiesTabLabel().setIcon(ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
                                MainWindowView.setCurrentlyActiveTab(Tabs.STUDENTS);

                                view.dispose();

                                loginView = new LoginView();
                                new LoginController(loginView);
                                MainWindowView.setActiveDisplay(loginView);
                                loginView.getEmailField().requestFocus();

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

                                loginView = new LoginView();
                                new LoginController(loginView);
                                MainWindowView.setActiveDisplay(loginView);
                                loginView.getEmailField().requestFocus();

                                break;
                            case 4:
                                view.dispose();

                                UploadView uploadView = new UploadView();
                                new UploadController(uploadView);
                                ActivitiesView.setActiveDisplay(uploadView);

                                break;
                            case 5:
                                view.dispose();
                                MathView mathView = new MathView();
                                new MathController(mathView);
                                ActivitiesView.setActiveDisplay(mathView);
                                break;

                            default:
                                break;
                        }
                    }
                }

                /**
                 * Handles the keyReleased event by invoking the
                 * keyReleased methods on listener-a and listener-b.
                 *
                 * @param e the {@link KeyEvent}
                 */
                @Override
                public void keyReleased(KeyEvent e) { /* Not needed */ }
            });
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @SneakyThrows
        @Override
        public void mouseClicked(MouseEvent e) {

            LoginView loginView;

            switch (selectedDialog.ordinal()) {
                case 0:

                    SideOptionsView.getAccountTabLabel().setIcon(ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon());
                    SideOptionsView.getStudentsTabLabel().setIcon(ImageIcons.STUDENT_TAB_HOVERED.getImageIcon());
                    SideOptionsView.getActivitiesTabLabel().setIcon(ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
                    MainWindowView.setCurrentlyActiveTab(Tabs.STUDENTS);

                    view.dispose();

                    loginView = new LoginView();
                    new LoginController(loginView);
                    MainWindowView.setActiveDisplay(loginView);
                    loginView.getEmailField().requestFocus();

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

                    loginView = new LoginView();
                    new LoginController(loginView);
                    MainWindowView.setActiveDisplay(loginView);
                    loginView.getEmailField().requestFocus();

                    break;
                case 4:
                    view.dispose();

                    UploadView uploadView = new UploadView();
                    new UploadController(uploadView);
                    ActivitiesView.setActiveDisplay(uploadView);

                    break;
                case 5:
                    view.dispose();
                    MathView mathView = new MathView();
                    new MathController(mathView);
                    ActivitiesView.setActiveDisplay(mathView);

                    break;

                case 6:
                    view.dispose();
                    //DELETE assignment
                    if(assignmentID != 0) {
                        StudentCommands.removeStudentAssignment(assignmentID);
                        Main.setAssignments(new Assignments(Main.getActiveUser().getTeacherId()));
                        ReportsView reportsView = new ReportsView(StudentCommands.getStudentFullName(studentID));
                        new ReportsController(reportsView, studentID);
                        StudentsView.setActiveDisplay(reportsView);
                    }
                    break;
                case 7:
                    view.dispose();
                    //DELETE student
                    if(studentID != 0) {
                        StudentCommands.deleteStudentAndAssignments(studentID);
                        Main.setStudents(new Students(Main.getActiveUser().getTeacherId()));
                        ViewStudentView viewStudent = new ViewStudentView();
                        new ViewStudentController(viewStudent);
                        StudentsView.setActiveDisplay(viewStudent);
                    }
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
                    label.setIcon(ImageIcons.APP_EXIT_HOVERED.getImageIcon());
                    break;
                case 3:
                    label.setIcon(ImageIcons.OK_BUTTON_HOVERED.getImageIcon());
                    break;
                case 4:
                    label.setIcon(ImageIcons.APP_EXIT_HOVERED.getImageIcon());
                    break;
                case 5:
                    label.setIcon(ImageIcons.OK_BUTTON_HOVERED.getImageIcon());
                    break;
                case 6:
                    label.setIcon(ImageIcons.OK_BUTTON_HOVERED.getImageIcon());
                    break;
                case 7:
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
                    label.setIcon(ImageIcons.APP_EXIT_NO_HOVER.getImageIcon());
                    break;
                case 3:
                    label.setIcon(ImageIcons.OK_BUTTON_NO_HOVER.getImageIcon());
                    break;
                case 4:
                    label.setIcon(ImageIcons.APP_EXIT_NO_HOVER.getImageIcon());
                    break;
                case 5:
                    label.setIcon(ImageIcons.OK_BUTTON_NO_HOVER.getImageIcon());
                    break;
                case 6:
                    label.setIcon(ImageIcons.OK_BUTTON_NO_HOVER.getImageIcon());
                    break;
                case 7:
                    label.setIcon(ImageIcons.OK_BUTTON_NO_HOVER.getImageIcon());
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
