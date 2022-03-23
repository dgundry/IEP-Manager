package com.mango.prjmango.ui.students.edit;

import com.mango.prjmango.ui.common.ImageIcons;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class EditStudentController {
    public EditStudentController(EditStudentView view) {
        JLabel saveLabel = view.getSaveLabel();
        JLabel editFirstNameLabel = view.getEditFirstNameLabel();
        JLabel editLastNameLabel  = view.getEditLastNameLabel();
        JLabel editGradeLabel     = view.getEditGradeLabel();
        JLabel editBioLabel       = view.getEditBioLabel();

        JTextField firstNameTextField = view.getStudentFirstNameTextField();
        JTextField lastNameTextField  = view.getStudentLastNameTextField();

        JComboBox<String> gradeComboBox = view.getGradeComboBox();

        JTextArea bioTextField = view.getBioTextField();

        saveLabel.addMouseListener(new SaveStudentMouseListener(view, saveLabel));
        editFirstNameLabel.addMouseListener(new EditLabelMouseListener(editFirstNameLabel, firstNameTextField));
        editLastNameLabel.addMouseListener(new EditLabelMouseListener(editLastNameLabel, lastNameTextField));
        editGradeLabel.addMouseListener(new EditLabelMouseListener(editGradeLabel, gradeComboBox));
        editBioLabel.addMouseListener(new EditLabelMouseListener(editBioLabel, bioTextField));
    }

    private static class SaveStudentMouseListener implements MouseListener {

        private final EditStudentView view;
        private final JLabel label;

        public SaveStudentMouseListener(EditStudentView view, JLabel label) {
            this.view = view;
            this.label = label;

        }

        public void mouseClicked(MouseEvent e) {
            view.getInformationLabel().setText("");

            String studentsFirstNameTextField = view.getStudentFirstNameTextField().getText().trim();
            String studentLastNameTextField = view.getStudentLastNameTextField().getText().trim();
            String gradeComboBox = Objects.requireNonNull(view.getGradeComboBox().getSelectedItem()).toString();
            String bioTextField = view.getBioTextField().getText().trim();

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
//                DatabaseCommands.registerStudent(studentsFirstNameTextField,studentLastNameTextField,gradeComboBox,bioTextField);
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

    private static class EditLabelMouseListener implements MouseListener {

        private final JLabel label;
        private final JComponent component;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param label     the specific {@link JLabel}
         * @param component the specific {@link JComponent}
         */
        public EditLabelMouseListener(JLabel label, JComponent component) {
            this.label = label;
            this.component = component;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            if (component.isEnabled()) {
                component.setEnabled(false);
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            } else {
                component.setEnabled(true);
                component.requestFocus();
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon());
            }

            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            if (label.getIcon().equals(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon())) {
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon());
            }

            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            if (label.getIcon().equals(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon())) {
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            }

            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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