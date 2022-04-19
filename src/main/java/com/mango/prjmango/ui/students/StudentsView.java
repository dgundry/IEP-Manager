package com.mango.prjmango.ui.students;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.students.create.CreateStudentController;
import com.mango.prjmango.ui.students.create.CreateStudentView;
import com.mango.prjmango.ui.students.edit.EditStudentController;
import com.mango.prjmango.ui.students.edit.EditStudentView;
import com.mango.prjmango.ui.students.view.ViewStudentController;
import com.mango.prjmango.ui.students.view.ViewStudentView;
import com.mango.prjmango.utilities.ImageUtils;
import com.mango.prjmango.utilities.subtabs.StudentsSubTabs;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class StudentsView {

    private static JLabel pickStudentHeaderLabel;

    @Getter private static JLabel studentBackgroundLabel;

    @Getter private static JLabel viewStudentsLabel;
    @Getter private static JLabel createStudentLabel;
    @Getter private static JLabel editStudentLabel;

    private static JSeparator horizSeparator;
    private static JSeparator vertSeparator;

    public static StudentsSubTabs currentlyActiveTab = StudentsSubTabs.VIEW;
    public static StudentsSubTabs previouslyActiveTab = null;

    public StudentsView() {
        createComponents();
        initLastUsedSubTub();

        studentBackgroundLabel.addComponentListener(new ComponentListener() {

            /**
             * Handles the componentResized event by invoking the
             * componentResized methods on listener-a and listener-b.
             *
             * @param e the component event
             */
            @Override
            public void componentResized(ComponentEvent e) {
                studentBackgroundLabel.setIcon(ImageUtils.getImageIcon(
                        ActivitiesView.class,
                        "/images/common/active-tab-background.png",
                        studentBackgroundLabel.getWidth(),
                        studentBackgroundLabel.getHeight()));
                studentBackgroundLabel.updateUI();
                studentBackgroundLabel.repaint();
            }

            /**
             * Handles the componentMoved event by invoking the
             * componentMoved methods on listener-a and listener-b.
             *
             * @param e the component event
             */
            @Override
            public void componentMoved(ComponentEvent e) { /* Not needed */ }

            /**
             * Handles the componentShown event by invoking the
             * componentShown methods on listener-a and listener-b.
             *
             * @param e the component event
             */
            @Override
            public void componentShown(ComponentEvent e) { /* Not needed */ }

            /**
             * Handles the componentHidden event by invoking the
             * componentHidden methods on listener-a and listener-b.
             *
             * @param e the component event
             */
            @Override
            public void componentHidden(ComponentEvent e) { /* Not needed */ }
        });
    }

    private static void initLastUsedSubTub() {
        switch (LoggedInUser.getStudentsSubTabIndex()) {
            case 0:
                ViewStudentView viewStudent = new ViewStudentView();
                new ViewStudentController(viewStudent);
                setActiveDisplay(viewStudent);
                break;
            case 1:
                CreateStudentView createStudentView = new CreateStudentView();
                new CreateStudentController(createStudentView);
                setActiveDisplay(createStudentView);
                break;
            case 2:
                EditStudentView editStudentView = new EditStudentView();
                new EditStudentController(editStudentView);
                setActiveDisplay(editStudentView);
                break;
            default:
                break;
        }
    }

    private static void createComponents() {
        studentBackgroundLabel = new JLabel();
        studentBackgroundLabel.setIcon(ImageIcons.ACTIVE_TAB_BACKGROUND.getImageIcon());

        pickStudentHeaderLabel = Components.JLabel(
                "Students",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);

        viewStudentsLabel  = new JLabel(ImageIcons.STUDENTS_VIEW_NO_HOVER.getImageIcon());
        createStudentLabel = new JLabel(ImageIcons.STUDENTS_CREATE_NO_HOVER.getImageIcon());
        editStudentLabel   = new JLabel(ImageIcons.STUDENTS_EDIT_NO_HOVER.getImageIcon());
        setSelectedSubTab();

        horizSeparator = Components.JSeparator(SwingConstants.HORIZONTAL);
        vertSeparator  = Components.JSeparator(SwingConstants.VERTICAL);
    }

    private static void setSelectedSubTab() {
        switch (LoggedInUser.getStudentsSubTabIndex()) {
            case 0:
                viewStudentsLabel.setIcon(ImageIcons.STUDENTS_VIEW_SELECTED.getImageIcon());
                break;
            case 1:
                createStudentLabel.setIcon(ImageIcons.STUDENTS_CREATE_SELECTED.getImageIcon());
                break;
            case 2:
                editStudentLabel.setIcon(ImageIcons.STUDENTS_EDIT_SELECTED.getImageIcon());
                break;
            default:
                break;
        }
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
                                                                        editStudentLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
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
                                                                .addComponent(
                                                                        editStudentLabel,
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
                                                                        .addGap(10, 10, 10)
                                                                        .addComponent(
                                                                                displayPanel,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE))))))
        );

        studentBackgroundLabel.updateUI();
    }
}
