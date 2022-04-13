package com.mango.prjmango.ui.students.edit;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.common.PencilEditor;
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
        PencilEditor editFirstNameLabel = view.getEditFirstNameLabel();
        PencilEditor editLastNameLabel  = view.getEditLastNameLabel();
        PencilEditor editGradeLabel     = view.getEditGradeLabel();
        PencilEditor editBioLabel       = view.getEditBioLabel();

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

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        public void mouseClicked(MouseEvent e) {
            view.getInformationLabel().setText("");

            String studentsFirstNameTextField = view.getStudentFirstNameTextField().getText().trim();
            String studentLastNameTextField = view.getStudentLastNameTextField().getText().trim();
            String gradeComboBox = Objects.requireNonNull(view.getGradeComboBox().getSelectedItem()).toString();
            String bioTextField = view.getBioTextField().getText().trim();

            if(Main.getStudents().getStudents().size() <= 0) {
                view.getInformationLabel().setText("You do not have any students.");
                view.getInformationLabel().setForeground(Color.RED);
                view.getStudentFirstNameTextField().requestFocus();
            } else if(((Student)view.getNameComboBox().getSelectedItem()).getStudentID() == 0) {
                view.getInformationLabel().setText("Please select a student.");
                view.getInformationLabel().setForeground(Color.RED);
                view.getNameComboBox().requestFocus();
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
                view.getNameComboBox().setModel(new DefaultComboBoxModel<>(new Vector<>(Main.getStudents().getStudents())));
                view.getNameComboBox().insertItemAt(new Student(0,"Select A Student"), 0);
                view.getNameComboBox().setSelectedIndex(0);
                view.getStudentFirstNameTextField().setEnabled(false);
                view.getStudentLastNameTextField().setEnabled(false);
                view.getBioTextField().setEnabled(false);
                view.getGradeComboBox().setEnabled(false);

                view.getEditFirstNameLabel().setIcon(
                        ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
                view.getEditLastNameLabel().setIcon(
                        ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
                view.getEditGradeLabel().setIcon(
                        ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
                view.getEditBioLabel().setIcon(
                        ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());

                view.getEditFirstNameLabel().setInEditMode(false);
                view.getEditLastNameLabel().setInEditMode(false);
                view.getEditGradeLabel().setInEditMode(false);
                view.getEditBioLabel().setInEditMode(false);
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

        private static boolean isBlank(String str) {
            return str.equals("");
        }
    }

    private static class EditLabelMouseListener implements MouseListener {

        private final PencilEditor label;
        private final JComponent component;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param label     the specific {@link PencilEditor}
         * @param component the specific {@link JComponent}
         */
        public EditLabelMouseListener(PencilEditor label, JComponent component) {
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
            if (label.isInEditMode()) {
                label.setInEditMode(false);
                component.setEnabled(false);
                label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            } else {
                label.setInEditMode(true);
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
            if (!label.isInEditMode()) {
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
            if (!label.isInEditMode()) {
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

    private static class StudentItemListener implements ItemListener {

        private final EditStudentView view;
        private final JComboBox<Student> studentComboBox;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link ItemListener}
         * methods.
         *
         * @param view            the {@link EditStudentView} to access other {@link JComponent}'s
         * @param studentComboBox the {@link JComboBox} of {@link Student}'s
         */
        public StudentItemListener(EditStudentView view, JComboBox<Student> studentComboBox) {
            this.view = view;
            this.studentComboBox = studentComboBox;
        }

        /**
         * Invoked when an item has been selected or deselected by the user.
         * The code written for this method performs the operations
         * that need to occur when an item is selected (or deselected).
         *
         * @param e the {@link ItemEvent}
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (studentComboBox.getSelectedIndex() == 0) {
                resetFields();
                return;
            }

            Student selectedStudent = (Student) studentComboBox.getSelectedItem();

            if (selectedStudent.getStudentID() != 0) {
                resetFields();
                view.getStudentFirstNameTextField().setText(selectedStudent.getFirstName());
                view.getStudentLastNameTextField().setText(selectedStudent.getLastName());
                view.getBioTextField().setText(selectedStudent.getBio());
                view.getGradeComboBox().setSelectedIndex(Integer.parseInt(selectedStudent.getGrade())-1);
            }
        }

        private void resetFields() {
            view.getStudentFirstNameTextField().setText("");
            view.getStudentLastNameTextField().setText("");
            view.getGradeComboBox().setSelectedIndex(0);
            view.getBioTextField().setText("");

            view.getStudentFirstNameTextField().setEnabled(false);
            view.getStudentLastNameTextField().setEnabled(false);
            view.getGradeComboBox().setEnabled(false);
            view.getBioTextField().setEnabled(false);

            view.getEditFirstNameLabel().setIcon(
                    ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            view.getEditLastNameLabel().setIcon(
                    ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            view.getEditGradeLabel().setIcon(
                    ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
            view.getEditBioLabel().setIcon(
                    ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());

            view.getEditFirstNameLabel().setInEditMode(false);
            view.getEditLastNameLabel().setInEditMode(false);
            view.getEditGradeLabel().setInEditMode(false);
            view.getEditBioLabel().setInEditMode(false);
        }
    }
}
