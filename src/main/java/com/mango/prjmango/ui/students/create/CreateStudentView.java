package com.mango.prjmango.ui.students.create;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import java.util.Arrays;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import lombok.Getter;

/**
 * The user interface design of the Create Student page.
 */
public class CreateStudentView extends JPanel {

    private JLabel createStudentHeaderLabel;
    private JLabel studentsFirstNameLabel;
    private JLabel studentsLastNameLabel;
    private JLabel gradeLabel;
    private JLabel bioLabel;

    @Getter private JLabel informationLabel;
    @Getter private JLabel saveLabel;

    @Getter private JTextField studentFirstNameTextField;
    @Getter private JTextField studentLastNameTextField;

    @Getter private JTextArea bioTextArea;

    @Getter private JComboBox<String> gradeComboBox;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public CreateStudentView() {
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        createStudentHeaderLabel = Components.JLabel(
                "Create A Student",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY);
        studentsFirstNameLabel = Components.JLabel(
                "First Name",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        studentsLastNameLabel = Components.JLabel(
                "Last Name",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);

        gradeLabel       = Components.JLabel("Grade", Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        bioLabel         = Components.JLabel("Bio",   Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        informationLabel = Components.JLabel(" ",      Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);

        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        studentFirstNameTextField = Components.JTextField("");
        studentLastNameTextField  = Components.JTextField("");
        studentFirstNameTextField.requestFocus();
        
        bioTextArea = Components.JTextArea("");

        String[] gradeArr = new String[]{"1", "2", "3", "4", "5"};
        List<String> gradeList = Arrays.asList(gradeArr);
        gradeComboBox = Components.JComboBox(gradeList);
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
                                                .addComponent(bioTextArea, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
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
                                .addContainerGap()
                                .addComponent(createStudentHeaderLabel)
                                .addGap(67, 67, 67)
                                .addComponent(studentsFirstNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentFirstNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentsLastNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentLastNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bioLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bioTextArea, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createStudentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addContainerGap(974, Short.MAX_VALUE))
        );
    }
}
