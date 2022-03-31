package com.mango.prjmango.ui.students.create;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.utilities.DatabaseCommands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class CreateStudentController {
    public CreateStudentController(CreateStudentView view) {
        JLabel saveLabel = view.getSaveLabel();

        saveLabel.addMouseListener(new SaveStudentMouseListener(view, saveLabel));
    }

    private static class SaveStudentMouseListener implements MouseListener {

        private final CreateStudentView view;
        private final JLabel label;

        public SaveStudentMouseListener(CreateStudentView view, JLabel label) {
            this.view = view;
            this.label = label;

        }

        public void mouseClicked(MouseEvent e) {
            view.getInformationLabel().setText("");

            String studentsFirstNameTextField = view.getStudentFirstNameTextField().getText().trim();
            String studentLastNameTextField = view.getStudentLastNameTextField().getText().trim();
            String gradeComboBox = Objects.requireNonNull(view.getGradeComboBox().getSelectedItem()).toString();
            String bioTextField = view.getBioTextArea().getText().trim();

            if (isBlank(studentsFirstNameTextField)) {
                view.getInformationLabel().setText("Please enter a valid first name!");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentFirstNameTextField().requestFocus();
            } else if (isBlank(studentLastNameTextField)) {
                view.getInformationLabel().setText("Please enter a valid last name!");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentLastNameTextField().requestFocus();
            } else {
                view.getInformationLabel().setText(view.getStudentFirstNameTextField().getText() + " has been added to the class!");
                view.getInformationLabel().setForeground(Color.GREEN);
                DatabaseCommands.registerStudent(studentsFirstNameTextField, studentLastNameTextField, gradeComboBox, bioTextField);
                Main.setStudents(new Students(Main.getActiveUser().getTeacherId()));
                view.getStudentFirstNameTextField().setText("");
                view.getStudentLastNameTextField().setText("");
                view.getGradeComboBox().setSelectedIndex(0);
                view.getBioTextArea().setText("");
                view.getStudentFirstNameTextField().requestFocus();
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_HOVERED.getImageIcon());
        }


        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        }

        private static boolean isBlank(String str) {
            return str.equals("");
        }

    }
}
