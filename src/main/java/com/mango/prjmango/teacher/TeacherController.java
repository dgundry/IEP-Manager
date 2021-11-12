package com.mango.prjmango.teacher;


import com.mango.prjmango.editaccount.EditAccountController;
import com.mango.prjmango.editaccount.EditAccountView;
import com.mango.prjmango.student.CreateAStudentView;
import com.mango.prjmango.student.StudentController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherController {

    public TeacherController(TeacherView teacherView){
        teacherView.getCreateStudentButton().addActionListener(new CreateStudentButtonActionListener());
        teacherView.getMyAccountButton().addActionListener(new MyAccountButtonActionListener());
    }

    private static class CreateStudentButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateAStudentView createAStudent = new CreateAStudentView();
            new StudentController(createAStudent);
            System.out.println("Clicked on Create A student");
        }
    }
    private static class MyAccountButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            EditAccountView editAccountView = new EditAccountView();
            new EditAccountController(editAccountView);
            System.out.println("Clicked on EditAccount");
        }
    }
}
