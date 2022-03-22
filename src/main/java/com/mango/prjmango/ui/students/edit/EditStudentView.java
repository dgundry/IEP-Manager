package com.mango.prjmango.ui.students.edit;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import lombok.Getter;

public class EditStudentView extends JPanel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    private JLabel createStudentHeaderLabel;
    private JLabel studentsFirstNameLabel;
    private JLabel studentsLastNameLabel;
    private JLabel gradeLabel;
    private JLabel bioLabel;
    @Getter JLabel informationLabel;

    @Getter private JLabel saveLabel;

    @Getter private JTextField studentFirstNameTextField;
    @Getter private JTextField studentLastNameTextField;

    @Getter private JTextArea bioTextField;

    @Getter private JComboBox gradeComboBox;



    public EditStudentView(){
        setOpaque(false);

        createComponents();
        createLayout();

    }
    private void createComponents(){
        createStudentHeaderLabel       = createLabel("Create A Student", 24);
        studentsFirstNameLabel          = createLabel("Student's First Name:", 18);
        studentsLastNameLabel           = createLabel("Student's Last Name:", 18);
        gradeLabel                      = createLabel("Grade:", 18);
        bioLabel                        = createLabel("Bio:", 18);
        informationLabel                = createLabel("", 14);

        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        studentFirstNameTextField   = createTextField("");
        studentLastNameTextField     = createTextField("");
        bioTextField                 = createTextArea("");


//        gradeComboBox = new JComboBox<>(gradeArr);
//        gradeComboBox.setOpaque(false);
//        gradeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        gradeComboBox.setForeground(LIGHT_GREY);
//        gradeComboBox.setModel(new DefaultComboBoxModel<>(gradeArr));
//
        String[] gradeArr = new String[] {"1","2","3","4","5"};

        List<String> gradeList = Arrays.asList(gradeArr);

        gradeComboBox = Components.JComboBox("Grades", gradeList);

    }


    private void gradeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void createLayout(){
        GroupLayout createStudentPanelLayout = new GroupLayout(this);
        setLayout(createStudentPanelLayout);
        createStudentPanelLayout.setHorizontalGroup(
                createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING,createStudentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(informationLabel)
                                        .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(bioTextField, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bioLabel)
                                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(gradeLabel)
                                                        .addComponent(studentLastNameTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                        .addComponent(studentsLastNameLabel)
                                                        .addComponent(studentsFirstNameLabel)
                                                        .addComponent(createStudentHeaderLabel)
                                                        .addComponent(studentFirstNameTextField))))
                                .addContainerGap(378, Short.MAX_VALUE))
        );
        createStudentPanelLayout.setVerticalGroup(
                createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(createStudentHeaderLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentsFirstNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentFirstNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(studentsLastNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentLastNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gradeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bioLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bioTextField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addContainerGap(974, Short.MAX_VALUE))
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

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setMargin(new Insets(0, 10, 0, 10));
        textArea.setBackground(DARK_GREY);
        textArea.setForeground(LIGHT_GREY);
        textArea.setCaretColor(LIGHT_GREY);
        textArea.setFont(Fonts.SEGOE_UI_16.getFont());
        textArea.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 216), 2));
        return textArea;
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setForeground(LIGHT_GREY);
        return label;
    }

    public static JComboBox<String> JComboBox(String headerText, List<String> list) {
        JComboBox<String> comboBox = new JComboBox<>(new Vector<>(list));
        comboBox.setOpaque(false);
        comboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        comboBox.setBackground(Colors.DARK_GREY);
        comboBox.setForeground(Colors.LIGHT_GREY);
        comboBox.setBorder(BorderFactory.createTitledBorder(
                null,
                headerText,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY));
        comboBox.setPreferredSize(new Dimension(56, 20));
        return comboBox;
    }


}