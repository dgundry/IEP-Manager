package com.mango.prjmango.windows.students.create;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.EmailValidation;
import com.mango.prjmango.windows.account.editprofile.EditProfileView;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class CreateStudentController {
    public CreateStudentController(CreateStudentView view){
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

        public void mouseClicked(MouseEvent e){
            view.getInformationLabel().setText("");

            String studentsFirstNameTextField = view.getStudentFirstNameTextField().getText().trim();
            String studentLastNameTextField = view.getStudentLastNameTextField().getText().trim();
            String gradeComboBox = Objects.requireNonNull(view.getGradeComboBox().getSelectedItem()).toString();
            String bioTextField = view.getBioTextField().getText().trim();

            if (isBlank(studentsFirstNameTextField)) {
                view.getInformationLabel().setText("Please enter a valid first name!");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentFirstNameTextField().requestFocus();
            } else if(isBlank(studentLastNameTextField)) {
                view.getInformationLabel().setText("Please enter a valid last name!");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentLastNameTextField().requestFocus();
            } else {
                view.getInformationLabel().setText(view.getStudentFirstNameTextField().getText() +" has been added to the class!");
                view.getInformationLabel().setForeground(Color.GREEN);
                DatabaseCommands.registerStudent(studentsFirstNameTextField,studentLastNameTextField,gradeComboBox,bioTextField);
                Main.students = new Students(Main.activeUser.getTeacherId());
                view.getStudentFirstNameTextField().setText("");
                view.getStudentLastNameTextField().setText("");
                view.getGradeComboBox().setSelectedIndex(0);
                view.getBioTextField().setText("");
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
