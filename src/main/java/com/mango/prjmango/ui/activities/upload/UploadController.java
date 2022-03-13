package com.mango.prjmango.ui.activities.upload;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.common.ImageIcons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;

public class UploadController {

    public UploadController(UploadView view) {
        JLabel saveLabel = view.getSaveLabel();
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
                statement.setInt(1, Main.activeUser.getTeacherId());
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
            UploadView uploadView = new UploadView();
            new UploadController(uploadView);
            ActivitiesView.setActiveDisplay(uploadView);
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
}
