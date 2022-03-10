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
                ImageIcons.STUDENTS_VIEW_NO_HOVER.getImageIcon(),
                ImageIcons.STUDENTS_VIEW_HOVERED.getImageIcon(),
                ImageIcons.STUDENTS_VIEW_SELECTED.getImageIcon(),
                StudentsSubTabs.VIEW));
        createStudent.addMouseListener(new StudentsSubTabListener(
                createStudent,
                ImageIcons.STUDENTS_CREATE_NO_HOVER.getImageIcon(),
                ImageIcons.STUDENTS_CREATE_HOVERED.getImageIcon(),
                ImageIcons.STUDENTS_CREATE_SELECTED.getImageIcon(),
                StudentsSubTabs.CREATE));
    }
}
