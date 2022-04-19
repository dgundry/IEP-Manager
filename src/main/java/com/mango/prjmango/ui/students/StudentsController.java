package com.mango.prjmango.ui.students;

import com.mango.prjmango.utilities.subtabs.StudentsSubTabs;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.students.listeners.StudentsSubTabListener;
import javax.swing.JLabel;

public class StudentsController {


    public StudentsController(StudentsView view){
        JLabel viewStudent = StudentsView.getViewStudentsLabel();
        JLabel createStudent = StudentsView.getCreateStudentLabel();
        JLabel editStudent = StudentsView.getEditStudentLabel();
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
        editStudent.addMouseListener(new StudentsSubTabListener(
                editStudent,
                ImageIcons.STUDENTS_EDIT_NO_HOVER.getImageIcon(),
                ImageIcons.STUDENTS_EDIT_HOVERED.getImageIcon(),
                ImageIcons.STUDENTS_EDIT_SELECTED.getImageIcon(),
                StudentsSubTabs.EDIT));
    }
}
