package com.mango.prjmango.windows.students;

import com.mango.prjmango.utilities.subtabs.ActivitiesSubTab;
import com.mango.prjmango.utilities.subtabs.StudentsSubTabs;
import com.mango.prjmango.windows.activities.listeners.ActivitiesSubTabListener;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.students.listeners.StudentsSubTabListener;

import javax.swing.*;

public class StudentsController {
    public StudentsController(StudentsView view){
        JLabel viewStudent = StudentsView.getViewStudentsLabel();
        JLabel createStudent = StudentsView.getCreateStudentLabel();
        viewStudent.addMouseListener(new StudentsSubTabListener(
                viewStudent,
                ImageIcons.ACTIVITIES_MATH_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_MATH_HOVERED.getImageIcon(),
                ImageIcons.ACTIVITIES_MATH_SELECTED.getImageIcon(),
                StudentsSubTabs.VIEW));
        createStudent.addMouseListener(new StudentsSubTabListener(
                createStudent,
                ImageIcons.ACTIVITIES_FRY_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_FRY_HOVERED.getImageIcon(),
                ImageIcons.ACTIVITIES_FRY_SELECTED.getImageIcon(),
                StudentsSubTabs.CREATE));
    }
}
