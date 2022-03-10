package com.mango.prjmango.windows.students;

import com.mango.prjmango.utilities.subtabs.ActivitiesSubTab;
import com.mango.prjmango.utilities.subtabs.StudentsSubTabs;
import com.mango.prjmango.windows.activities.math.MathController;
import com.mango.prjmango.windows.activities.math.MathView;
import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.Components;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.students.view.ViewStudentController;
import com.mango.prjmango.windows.students.view.ViewStudentView;
import lombok.Getter;

import javax.swing.*;


public class StudentsView {
    private static JLabel pickStudentHeaderLabel;

    @Getter private static JLabel studentBackgroundLabel;

    @Getter private static JLabel viewStudentsLabel;
    @Getter private static JLabel createStudentLabel;


    private static JSeparator horizSeparator;
    private static JSeparator vertSeparator;

    public static StudentsSubTabs currentlyActiveTab = StudentsSubTabs.VIEW;
    public static StudentsSubTabs previouslyActiveTab = null;

    public StudentsView(){
        createComponents();



        ViewStudentView viewStudent = new ViewStudentView();
        new ViewStudentController(viewStudent);
        setActiveDisplay(viewStudent);
    }
    private static void createComponents() {
        studentBackgroundLabel = new JLabel();
        studentBackgroundLabel.setIcon(ImageIcons.ACTIVE_TAB_BACKGROUND.getImageIcon());

        pickStudentHeaderLabel = Components.JLabel(
                "Pick an Assignment",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);

        viewStudentsLabel             = new JLabel(ImageIcons.ACTIVITIES_MATH_SELECTED.getImageIcon());
        createStudentLabel            = new JLabel(ImageIcons.ACTIVITIES_FRY_NO_HOVER.getImageIcon());

        horizSeparator = Components.JSeparator(SwingConstants.HORIZONTAL);
        vertSeparator  = Components.JSeparator(SwingConstants.VERTICAL);
    }
    public static void setActiveDisplay(JPanel displayPanel) {
        studentBackgroundLabel.removeAll();

        GroupLayout pickAnAssignmentPanelLayout = new GroupLayout(studentBackgroundLabel);
        studentBackgroundLabel.setLayout(pickAnAssignmentPanelLayout);
        pickAnAssignmentPanelLayout.setHorizontalGroup(
                pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(horizSeparator)
                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pickStudentHeaderLabel)
                                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(
                                                                        GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(
                                                                        createStudentLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(
                                                                        viewStudentsLabel,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(
                                                        vertSeparator,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        18,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(
                                                        displayPanel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(325, Short.MAX_VALUE))
        );
        pickAnAssignmentPanelLayout.setVerticalGroup(
                pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                .addComponent(
                                        pickStudentHeaderLabel,
                                        GroupLayout.PREFERRED_SIZE,
                                        59,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(
                                        horizSeparator,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(vertSeparator)
                                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(
                                                                        viewStudentsLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        createStudentLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addContainerGap())
                                                        .addGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                pickAnAssignmentPanelLayout.createSequentialGroup()
                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                displayPanel,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE))))))
        );

        studentBackgroundLabel.updateUI();
    }
    public static void clearLayout(){
        studentBackgroundLabel.removeAll();
        studentBackgroundLabel.updateUI();
    }
}