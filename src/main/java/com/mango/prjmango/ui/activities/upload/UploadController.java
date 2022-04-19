package com.mango.prjmango.ui.activities.upload;

import com.mango.prjmango.Main;
import com.mango.prjmango.Outlines.Outline;
import com.mango.prjmango.assignment.Assignments;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.ui.dialogs.confirmation.Dialogs;
import com.mango.prjmango.utilities.DatabaseConnection;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UploadController {

    public UploadController(UploadView view) {
        JLabel saveLabel = view.getSaveLabel();
        JTextField earnedField = view.getPointsEarnedTextField();
        JTextField maximumField = view.getMaximumPointsTextField();
        JComboBox activityComboBox = view.getAssignmentNameDropdown();

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

        activityComboBox.addItemListener(new AssignmentChangedListener(view, activityComboBox));
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
            view.getInformationLabel().setText("");

            String assignmentName = view.getAssignmentNameTextField().getText().trim();
            String earnedPoints  = view.getPointsEarnedTextField().getText().trim();
            String maximumPoints     = view.getMaximumPointsTextField().getText().trim();
            int assignmentComboBoxIndex = view.getAssignmentNameDropdown().getSelectedIndex();
            int studentComboBoxIndex = view.getStudentNameDropdown().getSelectedIndex();
            if(assignmentName.isEmpty() && assignmentComboBoxIndex == 0) {
                view.getInformationLabel().setForeground(Color.RED);
                view.getInformationLabel().setText("Please Enter Assignment Name or Select an Assignment from the Dropdown");
            }else if(earnedPoints.isEmpty()) {
                view.getInformationLabel().setForeground(Color.RED);
                view.getInformationLabel().setText("Please enter a number of points earned");
            }else if(maximumPoints.isEmpty()) {
                view.getInformationLabel().setForeground(Color.RED);
                view.getInformationLabel().setText("Please enter a number of points possible");
            }else {
                String assignmentNameString;
                if(assignmentName.isEmpty()){
                    assignmentNameString = view.getAssignmentNameDropdown().getSelectedItem().toString();
                }else{
                    assignmentNameString = assignmentName;
                }
                String sql = "INSERT INTO assignment(teacher_id, student_id,title,earned_points,total_points,date,comment) VALUES(?,?,?,?,?,date('" + view.getDateTextField().getText() + "'),?);";
                try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
                    statement.setInt(1, Main.getActiveUser().getTeacherId());
                    statement.setInt(2, ((Student) view.getStudentNameDropdown().getSelectedItem()).getStudentID());
                    statement.setString(3, assignmentNameString);
                    statement.setInt(4, Integer.parseInt(view.getPointsEarnedTextField().getText()));
                    statement.setInt(5, Integer.parseInt(view.getMaximumPointsTextField().getText()));
                    statement.setString(6, view.getCommentsTextField().getText());
                    statement.executeUpdate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                view.getInformationLabel().setForeground(Color.GREEN);
                view.getInformationLabel().setText("Uploaded Successfully");
                view.getAssignmentNameTextField().setText("");
                view.getMaximumPointsTextField().setText("");
                view.getPointsEarnedTextField().setText("");
                view.getCommentsTextField().setText("");
                view.getAssignmentNameDropdown().setSelectedIndex(0);
                Main.setAssignments(new Assignments(Main.getActiveUser().getTeacherId()));
                ConfirmationView confirmationView =
                        new ConfirmationView("Assignment Uploaded!", Dialogs.ASSIGNMENT_UPLOADED);
                new ConfirmationController(confirmationView);
            }
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

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) {
            view.getMaximumPointsTextField().setEditable(true);
            view.getMaximumPointsTextField().requestFocusInWindow();
        }

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
        public void mouseEntered(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) { /* Not needed */ }
    }

    private class earnedFieldMouseListener implements MouseListener {
        UploadView view;
        public earnedFieldMouseListener(UploadView view) {
            this.view = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) {
            view.getPointsEarnedTextField().setEditable(true);
            view.getPointsEarnedTextField().requestFocusInWindow();
        }

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
        public void mouseEntered(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) { /* Not needed */ }
    }

    private class AssignmentChangedListener implements ItemListener {
        UploadView view;
        JComboBox activityComboBox;
        public AssignmentChangedListener(UploadView view, JComboBox activityComboBox) {
            this.view = view;
            this.activityComboBox = activityComboBox;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(activityComboBox.getSelectedIndex() != 0) {
                    view.getMaximumPointsTextField().setText(((Outline)activityComboBox.getSelectedItem()).getMaximumPoints() + "");
                    view.getAssignmentNameTextField().setText(((Outline)activityComboBox.getSelectedItem()).toString());
                    view.getAssignmentNameTextField().setEditable(false);
                }else{
                    view.getMaximumPointsTextField().setText("");
                    view.getAssignmentNameTextField().setEditable(true);
                    view.getAssignmentNameTextField().setText("");
                }
            }
        }
    }
}
