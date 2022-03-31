package com.mango.prjmango.ui.activities.upload;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.ui.dialogs.confirmation.Dialogs;
import com.mango.prjmango.utilities.DatabaseConnection;

import java.awt.event.*;
import java.sql.PreparedStatement;
import javax.swing.*;

public class UploadController {

    public UploadController(UploadView view) {
        JLabel saveLabel = view.getSaveLabel();
        JTextField earnedField = view.getPointsEarnedTextField();
        JTextField maximumField = view.getMaximumPointsTextField();
        maximumField.addKeyListener(new KeyAdapter() {
           public void keyPressed(KeyEvent event) {
               String value = maximumField.getText();
               int length = value.length();
               if((event.getKeyChar() >= '0' && event.getKeyChar() <= '9') || event.getKeyChar() == 8 || event.getKeyChar() == 46) {
                   maximumField.setEditable(true);
               }
               else{
                   maximumField.setEditable(false);
               }
           }
        });
        earnedField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                String value = earnedField.getText();
                int length = value.length();
                if((event.getKeyChar() >= '0' && event.getKeyChar() <= '9') || event.getKeyChar() == 8 || event.getKeyCode() == KeyEvent.VK_DELETE) {
                    earnedField.setEditable(true);
                }
                else{
                    earnedField.setEditable(false);
                }
            }
        });
        maximumField.addMouseListener(new maximumFieldMouseListener(view));
        earnedField.addMouseListener(new earnedFieldMouseListener(view));

        saveLabel.addMouseListener(new SaveLabelMouseListener(view, saveLabel));
    }
    private static class SaveLabelMouseListener implements MouseListener {

        private final UploadView view;
        private final JLabel label;

        public SaveLabelMouseListener(UploadView view, JLabel label) {
            this.label = label;
            this.view  = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            String sql = "INSERT INTO assignment(teacher_id, student_id,title,earned_points,total_points,date,comment) VALUES(?,?,?,?,?,date('" + view.getDateTextField().getText() + "'),?);";
            try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
                statement.setInt(1, Main.getActiveUser().getTeacherId());
                statement.setInt(2, ((Student)view.getStudentNameDropdown().getSelectedItem()).getStudentID());
                statement.setString(3, view.getAssignmentNameTextField().getText());
                statement.setInt(4, Integer.parseInt(view.getPointsEarnedTextField().getText()));
                statement.setInt(5, Integer.parseInt(view.getMaximumPointsTextField().getText()));
                statement.setString(6, view.getCommentsTextField().getText());
                statement.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //Dialog Box
            ConfirmationView confirmationView =
                    new ConfirmationView("Assignment Uploaded!", Dialogs.ASSIGNMENT_UPLOADED);
            new ConfirmationController(confirmationView);
//            UploadView uploadView = new UploadView();
//            new UploadController(uploadView);
//            ActivitiesView.setActiveDisplay(uploadView);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());
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

    private class maximumFieldMouseListener implements MouseListener {
        UploadView view;
        public maximumFieldMouseListener(UploadView view) {
            this.view = view;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            view.getMaximumPointsTextField().setEditable(true);
            view.getMaximumPointsTextField().requestFocusInWindow();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class earnedFieldMouseListener implements MouseListener {
        UploadView view;
        public earnedFieldMouseListener(UploadView view) {
            this.view = view;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            view.getPointsEarnedTextField().setEditable(true);
            view.getPointsEarnedTextField().requestFocusInWindow();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
