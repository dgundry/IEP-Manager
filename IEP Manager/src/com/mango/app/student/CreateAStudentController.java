package com.mango.app.student;

import com.mango.app.editaccount.EditAccountController;
import com.mango.app.editaccount.EditAccountView;
import com.mango.app.student.CreateAStudentView;
import com.mango.app.student.StudentController;

import com.mango.app.utilities.Encryption;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAStudentController {

    public CreateAStudentController(CreateAStudentView createAStudentView) {
        createAStudentView.getCreateStudentButton().addActionListener(new CreateStudentButtonActionListener());
        createAStudentView.getMyAccountButton().addActionListener(new MyAccountButtonActionListener(createAStudentView));

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
        private final CreateAStudentView view;

        public MyAccountButtonActionListener(CreateAStudentView createAStudentView) {
            this.view = createAStudentView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCreateAStudentWindow().dispose();
            EditAccountView editAccountView = new EditAccountView();
            new EditAccountController(editAccountView);
            System.out.println("Clicked on EditAccount");
        }
    }
}
