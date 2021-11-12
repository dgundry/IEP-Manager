package com.mango.prjmango.student;

import com.mango.prjmango.editaccount.EditAccountController;
import com.mango.prjmango.editaccount.EditAccountView;
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
