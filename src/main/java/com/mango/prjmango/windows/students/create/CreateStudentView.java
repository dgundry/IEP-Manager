package com.mango.prjmango.windows.students.create;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CreateStudentView extends JPanel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    private JLabel createStudenttHeaderLabel;
    private JLabel studentsFirstNameLabel;
    private JLabel studentsLastNameLabel;
    private JLabel gradeLabel;
    private JLabel bioLabel;
    private JLabel saveLabel;

    @Getter private JTextField studentsFirstNameTextField;
    @Getter private JTextField studentLastNameTextField;
    @Getter private JTextField bioTextField;

    private JComboBox gradeComboBox;


    public CreateStudentView(){
        setOpaque(false);

        createComponents();
        createLayout();

    }
    private void createComponents(){
        createStudenttHeaderLabel = createLabel("Create A Student", 24);
        studentsFirstNameLabel = createLabel("Student's First Name:", 18);
        studentsLastNameLabel = createLabel("Student's Last Name:", 18);
        gradeLabel = createLabel("Grade:", 18);
        bioLabel = createLabel("Bio:", 18);
        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        studentsFirstNameTextField = createTextField("");
        studentLastNameTextField = createTextField("");
        bioTextField = createTextField("");

        gradeComboBox = new JComboBox<>();
        gradeComboBox.setOpaque(false);
        gradeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        gradeComboBox.setForeground(LIGHT_GREY);
        gradeComboBox.setModel(new DefaultComboBoxModel<>());


    }


    private void gradeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void createLayout(){
        GroupLayout createStudentPanelLayout = new GroupLayout(this);
        setLayout(createStudentPanelLayout);
        createStudentPanelLayout.setHorizontalGroup(
                createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                .addContainerGap(114, Short.MAX_VALUE)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(studentsFirstNameLabel)
                                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentsFirstNameTextField, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bioTextField, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bioLabel)
                                                        .addComponent(gradeLabel)
                                                        .addComponent(studentLastNameTextField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentsLastNameLabel)
                                                        .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(createStudenttHeaderLabel))
                                .addGap(409, 409, Short.MAX_VALUE))
        );
        createStudentPanelLayout.setVerticalGroup(
                createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(createStudenttHeaderLabel)
                                .addGap(32, 32, 32)
                                .addComponent(studentsFirstNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentsFirstNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(studentsLastNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentLastNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(gradeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bioLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bioTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(1078, Short.MAX_VALUE))
        );
    }
    private JTextField createTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setMargin(new Insets(0, 5, 0, 5));
        textField.setBackground(DARK_GREY);
        textField.setForeground(LIGHT_GREY);
        textField.setCaretColor(LIGHT_GREY);
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        return textField;
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setForeground(LIGHT_GREY);
        return label;
    }


}
