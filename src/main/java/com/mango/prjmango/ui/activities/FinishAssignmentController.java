package com.mango.prjmango.ui.activities;

import com.mango.prjmango.Main;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.ui.dialogs.confirmation.Dialogs;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import javax.swing.JLabel;

public class FinishAssignmentController {

    public FinishAssignmentController(FinishAssignmentView view){
        JLabel submitLabel = view.getSubmitLabel();
        submitLabel.addMouseListener(new SubmitLabelMouseListener(view, submitLabel));
    }

    private static class SubmitLabelMouseListener implements MouseListener {

        private final FinishAssignmentView view;
        private final JLabel label;

        public SubmitLabelMouseListener(FinishAssignmentView view, JLabel label) {
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
            String sql = "INSERT INTO assignment(teacher_id, student_id,title,earned_points,total_points,date,comment) VALUES(?,?,?,?,?,date('now','localtime'),?);";
            try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
                statement.setInt(1, Main.activeUser.getTeacherId());
                statement.setInt(2, view.getAssignment().getStudent().getStudentID());
                statement.setString(3, view.getAssignment().getAssignmentName());
                statement.setInt(4, view.getAssignment().getCorrectAnswers());
                statement.setInt(5, view.getAssignment().getTotalQuestions());
                statement.setString(6, view.getCommentsTextArea().getText());
                statement.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            ConfirmationView confirmationView =
                    new ConfirmationView("Assignment saved!", Dialogs.ASSIGNMENT_SAVED);
            new ConfirmationController(confirmationView);
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
