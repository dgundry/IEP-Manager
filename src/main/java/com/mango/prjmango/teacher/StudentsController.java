package com.mango.prjmango.teacher;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.editaccount.EditAccountView;
import com.mango.prjmango.student.CreateAStudentView;
import com.mango.prjmango.student.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsController {

    public StudentsController(StudentsView studentsView){

    }

    private static class MyAccountButtonActionListener implements ActionListener {
        private final StudentsView view;

        public MyAccountButtonActionListener(StudentsView studentsView) {
            this.view = studentsView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentsView studentsView = new StudentsView();
            //new EditAccountController(editAccountView);
            MainFrame.setTeacherView(studentsView);
            System.out.println("Clicked on EditAccount");
        }
    }
}
