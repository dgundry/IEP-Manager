package com.mango.prjmango.windows.students.create;

import com.mango.prjmango.components.Components;
import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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


//        gradeComboBox = new JComboBox<>(gradeArr);
//        gradeComboBox.setOpaque(false);
//        gradeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        gradeComboBox.setForeground(LIGHT_GREY);
//        gradeComboBox.setModel(new DefaultComboBoxModel<>(gradeArr));
//
        String[] gradeArr = new String[] {"1","2","3","4","5"};

        List<String> gradeList = Arrays.asList(gradeArr);

        gradeComboBox = Components.JComboBox(gradeList);

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
                                .addGap(23, 23, 23)
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
                                                .addComponent(createStudenttHeaderLabel)
                                                .addComponent(studentsFirstNameTextField)))
                                .addContainerGap(378, Short.MAX_VALUE))
        );
        createStudentPanelLayout.setVerticalGroup(
                createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createStudentPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(createStudenttHeaderLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentsFirstNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentsFirstNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(studentsLastNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentLastNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gradeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bioLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bioTextField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
