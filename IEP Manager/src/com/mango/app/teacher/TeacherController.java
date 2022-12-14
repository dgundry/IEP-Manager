package com.mango.app.teacher;

import com.mango.app.editaccount.EditAccountController;
import com.mango.app.editaccount.EditAccountView;
import com.mango.app.student.CreateAStudentView;
import com.mango.app.student.StudentController;
import com.mango.app.utilities.Encryption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherController {

    private static Encryption encryption= new Encryption();

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
