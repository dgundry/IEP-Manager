package com.mango.prjmango.ui.activities.sightwords;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.activities.dolch.DolchWords;
import com.mango.prjmango.ui.activities.fry.FryWords;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.Color;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

public class SightView extends JPanel {

    private JLabel assignmentHeaderLabel;
    private JLabel assignmentLabel;
    private JLabel studentsNameLabel;

    @Getter private JLabel beginLabel;
    @Getter private JComboBox<Object> sightWordComboBox;
    @Getter private JComboBox<Student> studentsNameComboBox;

    public SightView(){
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        if(LoggedInUser.getCurrentMenu() == 1) {
            assignmentHeaderLabel = Components.JLabel(
                    "Fry Sight Words",
                    Fonts.SEGOE_UI_24.getFont(),
                    Colors.LIGHT_GREY,
                    SwingConstants.LEADING);
            assignmentLabel = Components.JLabel(
                    "Pick Fry Sight Word Assignment",
                    Fonts.SEGOE_UI_18.getFont(),
                    Colors.LIGHT_GREY,
                    SwingConstants.LEADING);
        } else if(LoggedInUser.getCurrentMenu() == 2) {
            assignmentHeaderLabel = Components.JLabel(
                    "Dolch Sight Words",
                    Fonts.SEGOE_UI_24.getFont(),
                    Colors.LIGHT_GREY,
                    SwingConstants.LEADING);
            assignmentLabel = Components.JLabel(
                    "Pick Dolch Sight Word Assignment",
                    Fonts.SEGOE_UI_18.getFont(),
                    Colors.LIGHT_GREY,
                    SwingConstants.LEADING);
        }

        studentsNameLabel = Components.JLabel(
                "Student's Name",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);

        sightWordComboBox = Components.JComboBox();
        if (LoggedInUser.getCurrentMenu() == 1) {
            sightWordComboBox.setModel(new DefaultComboBoxModel<>(FryWords.values()));
        } else if(LoggedInUser.getCurrentMenu() == 2) {
            sightWordComboBox.setModel(new DefaultComboBoxModel<>(DolchWords.values()));
        }

        studentsNameComboBox = new JComboBox<>(new Vector<>(Main.getStudents().getStudents()));
        studentsNameComboBox.setBackground(Color.WHITE);

        beginLabel = new JLabel(ImageIcons.FRY_BEGIN_NO_HOVER.getImageIcon());
    }
    private void createLayout() {
        GroupLayout assignmentPanelLayout = new GroupLayout(this);
        setLayout(assignmentPanelLayout);
        assignmentPanelLayout.setHorizontalGroup(
                assignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(assignmentPanelLayout.createSequentialGroup()
                                .addGroup(assignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                studentsNameComboBox,
                                                GroupLayout.Alignment.TRAILING,
                                                0,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(
                                                sightWordComboBox,
                                                GroupLayout.Alignment.TRAILING,
                                                0,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(assignmentPanelLayout.createSequentialGroup()
                                                .addGroup(assignmentPanelLayout.createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addComponent(assignmentHeaderLabel)
                                                        .addComponent(
                                                                studentsNameLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                245,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                assignmentLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                282,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(assignmentPanelLayout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(
                                        beginLabel,
                                        GroupLayout.PREFERRED_SIZE,
                                        168,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(185, Short.MAX_VALUE))
        );
        assignmentPanelLayout.setVerticalGroup(
                assignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(assignmentPanelLayout.createSequentialGroup()
                                .addComponent(assignmentHeaderLabel)
                                .addGap(60, 60, 60)
                                .addComponent(assignmentLabel)
                                .addGap(18, 18, 18)
                                .addComponent(
                                        sightWordComboBox,
                                        GroupLayout.PREFERRED_SIZE,
                                        39,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(studentsNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(
                                        studentsNameComboBox,
                                        GroupLayout.PREFERRED_SIZE,
                                        39,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)
                                .addComponent(beginLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 504, Short.MAX_VALUE))
        );
    }
}
