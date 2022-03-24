package com.mango.prjmango.ui.students.edit;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.utilities.dbcommands.StudentCommands;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
        JComboBox<Student> studentComboBox = view.getNameComboBox();

        JTextArea bioTextField = view.getBioTextField();

        saveLabel.addMouseListener(new SaveStudentMouseListener(view, saveLabel));
        editFirstNameLabel.addMouseListener(new EditLabelMouseListener(editFirstNameLabel, firstNameTextField));
        editLastNameLabel.addMouseListener(new EditLabelMouseListener(editLastNameLabel, lastNameTextField));
        editGradeLabel.addMouseListener(new EditLabelMouseListener(editGradeLabel, gradeComboBox));
        editBioLabel.addMouseListener(new EditLabelMouseListener(editBioLabel, bioTextField));
        studentComboBox.addItemListener(new StudentItemListener(view, studentComboBox));
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

            if(Main.getStudents().getStudents().size() <= 0){
                view.getInformationLabel().setText("You do not have any students.");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentFirstNameTextField().requestFocus();
            } else if (isBlank(studentsFirstNameTextField)) {
                view.getInformationLabel().setText("Please enter a valid first name!");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentFirstNameTextField().requestFocus();
            } else if (isBlank(studentLastNameTextField)) {
                view.getInformationLabel().setText("Please enter a valid last name!");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentLastNameTextField().requestFocus();
            } else {
                int studentID = ((Student) view.getNameComboBox().getSelectedItem()).getStudentID();
                view.getInformationLabel().setText(view.getStudentFirstNameTextField().getText() + " has been updated!");
                view.getInformationLabel().setForeground(Color.GREEN);
                StudentCommands.updateStudent(studentID,studentsFirstNameTextField,studentLastNameTextField,gradeComboBox,bioTextField);
                Main.setStudents(new Students(LoggedInUser.getTeacherId()));
                view.getStudentFirstNameTextField().setEnabled(false);
                view.getStudentLastNameTextField().setEnabled(false);
                view.getBioTextField().setEnabled(false);
                view.getGradeComboBox().setEnabled(false);
                view.getNameComboBox().setModel(new DefaultComboBoxModel<>(new Vector<>(Main.getStudents().getStudents())));
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

    private class StudentItemListener implements ItemListener {
        private EditStudentView view;
        private JComboBox<Student> studentComboBox;
        public StudentItemListener(EditStudentView view, JComboBox<Student> studentComboBox) {
            this.view = view;
            this.studentComboBox = studentComboBox;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            Student selectedStudent = (Student) studentComboBox.getSelectedItem();
            view.getStudentFirstNameTextField().setText(selectedStudent.getFirstName());
            view.getStudentLastNameTextField().setText(selectedStudent.getLastName());
            view.getBioTextField().setText(selectedStudent.getBio());
            view.getGradeComboBox().setSelectedIndex(Integer.parseInt(selectedStudent.getGrade())-1);
        }
    }
}