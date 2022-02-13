package com.mango.prjmango.student;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.dialogs.Dialog;
import com.mango.prjmango.components.listeners.TextFieldFocusListener;
import com.mango.prjmango.editaccount.EditAccountController;
import com.mango.prjmango.editaccount.EditAccountView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class CreateAStudentController {
    private static final String FIRST_NAME_FIELD_ORIGINAL = "First name";
    private static final String LAST_NAME_FIELD_ORIGINAL = "Last name";
    private static final String GRADE_FIELD_ORIGINAL = "Grade";
    private static final String BIO_FIELD_FIELD = "Bio";
    private static final String ERROR_MESSAGE_TITLE = "INVALID";

    //private final CreateAStudentView createAStudentView;

    public CreateAStudentController(CreateAStudentView createAStudentView) {
        createAStudentView.getSaveButton().addActionListener(new saveButtonActionListener(createAStudentView));
        createAStudentView.getMyAccountButton().addActionListener(new MyAccountButtonActionListener(createAStudentView));

        createAStudentView.getFirstNameText().addFocusListener(new TextFieldFocusListener(createAStudentView.getFirstNameText(), FIRST_NAME_FIELD_ORIGINAL));
        createAStudentView.getLastNameText().addFocusListener(new TextFieldFocusListener(createAStudentView.getLastNameText(), LAST_NAME_FIELD_ORIGINAL));
        createAStudentView.getGradeText().addFocusListener(new TextFieldFocusListener(createAStudentView.getGradeText(), GRADE_FIELD_ORIGINAL));
        createAStudentView.getBioText().addFocusListener(new TextFieldFocusListener(createAStudentView.getBioText(), BIO_FIELD_FIELD));

    }


    private static class saveButtonActionListener implements ActionListener {

        private final CreateAStudentView view;

//        public saveButtonActionListener(CreateAStudentView view){
//
//            this.view = view;
//        }

        public saveButtonActionListener(CreateAStudentView view){
            this.view = view;

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            final String MESSAGE_TITLE = "Invalid";
//            if(student == null){
//                student = new Student();
//            }
            Student student = new Student();
            student.setFirstName(view.getFirstNameText().getText());
            student.setLastName(view.getLastNameText().getText());
            student.setGrade(view.getGradeText().getText());
            student.setBio(view.getBioText().getText());

            //RegisterStudent register = new RegisterStudent();
            if(!(student.getFirstName().length() >= 1 && student.getFirstName().length() <= 20)){
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Enter a Valid First Name.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else if(!(student.getLastName().length() >= 1 && student.getLastName().length() <= 20)) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Enter a Valid Last Name.",
                        ERROR_MESSAGE_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }else if(!(student.getGrade().length() >= 1 && student.getGrade().length() <= 20)) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                   "Enter a valid grade.",
                   ERROR_MESSAGE_TITLE,
                   JOptionPane.ERROR_MESSAGE);

            }else {
                if(RegisterStudent.createStudent(student)){
                    Dialog.openDialog(Dialog.ACCOUNT_CREATED);

                    view.getFirstNameText().setText("");
                    view.getLastNameText().setText("");
                    view.getGradeText().setText("");
                    view.getBioText().setText("");

                    System.out.println("Clicked on Create A student");

                }else {
                    System.out.println("Error registering student");
                }


            }
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
    private static class FirstNameMouseListener implements MouseListener {

        private final CreateAStudentView createAStudentView;

        public FirstNameMouseListener(CreateAStudentView createAStudentView) { this.createAStudentView = createAStudentView; }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(createAStudentView.getFirstNameText().getText().equals("First Name")){
                createAStudentView.getFirstNameText().setText("");

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
