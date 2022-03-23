package com.mango.prjmango.ui.students.edit;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import lombok.Getter;

public class EditStudentView extends JPanel {

    private JLabel nameComboBoxLabel;
    private JLabel editStudentHeaderLabel;
    private JLabel studentsFirstNameLabel;
    private JLabel studentsLastNameLabel;
    private JLabel gradeLabel;
    private JLabel bioLabel;

    @Getter private JLabel informationLabel;
    @Getter private JLabel saveLabel;

    @Getter private JTextField studentFirstNameTextField;
    @Getter private JTextField studentLastNameTextField;

    @Getter private JTextArea bioTextField;

    @Getter private JComboBox<String> gradeComboBox;

    @Getter private JLabel editFirstNameLabel;
    @Getter private JLabel editLastNameLabel;
    @Getter private JLabel editGradeLabel;
    @Getter private JLabel editBioLabel;

    @Getter private JComboBox<Student> nameComboBox;

    public EditStudentView() {
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        editStudentHeaderLabel = Components.JLabel(
                "Edit a Student",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY);
        nameComboBoxLabel = Components.JLabel(
                "Name:",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        studentsFirstNameLabel = Components.JLabel(
                "First Name:",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        studentsLastNameLabel = Components.JLabel(
                "Last Name:",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        gradeLabel = Components.JLabel(
                "Grade:",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        bioLabel = Components.JLabel("Bio:", Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        informationLabel = Components.JLabel(" ", Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);

        editFirstNameLabel = new JLabel(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
        editLastNameLabel  = new JLabel(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
        editGradeLabel     = new JLabel(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
        editBioLabel       = new JLabel(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
        saveLabel          = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        studentFirstNameTextField = Components.JTextField("");
        studentFirstNameTextField.setEnabled(false);

        studentLastNameTextField = Components.JTextField("");
        studentLastNameTextField.setEnabled(false);

        bioTextField = Components.JTextArea("");
        bioTextField.setEnabled(false);

        String[] gradeArr = new String[] {"1","2","3","4","5"};
        List<String> gradeList = Arrays.asList(gradeArr);
        gradeComboBox = Components.JComboBox(gradeList);
        gradeComboBox.setEnabled(false);

        nameComboBox = new JComboBox<>(new Vector<>(Main.getStudents().getStudents()));
        nameComboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        nameComboBox.setBackground(Colors.DARK_GREY);
        nameComboBox.setForeground(Colors.LIGHT_GREY);
    }

    private void createLayout() {
        GroupLayout createStudentPanelLayout = new GroupLayout(this);
        setLayout(createStudentPanelLayout);
        createStudentPanelLayout.setHorizontalGroup(
                createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING,createStudentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(informationLabel)
                                        .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addGroup(createStudentPanelLayout.createSequentialGroup()
                                                        .addComponent(bioTextField, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(editBioLabel))
                                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bioLabel)
                                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                                            .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(editGradeLabel))
                                                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                                                .addComponent(studentLastNameTextField, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(editLastNameLabel))
                                                        .addComponent(studentsLastNameLabel)
                                                        .addComponent(studentsFirstNameLabel)
                                                        .addComponent(editStudentHeaderLabel)
                                                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                                                .addComponent(studentFirstNameTextField, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(editFirstNameLabel)))
                                                .addComponent(nameComboBox, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nameComboBoxLabel)
                                                .addComponent(gradeLabel)))
                                .addContainerGap(378, Short.MAX_VALUE))
        );
        createStudentPanelLayout.setVerticalGroup(
                createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(editStudentHeaderLabel)
                                .addGap(67, 67, 67)
                                .addComponent(nameComboBoxLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameComboBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentsFirstNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentFirstNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editFirstNameLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentsLastNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentLastNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editLastNameLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editGradeLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bioLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bioTextField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editBioLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addContainerGap(974, Short.MAX_VALUE))
        );
    }
}
