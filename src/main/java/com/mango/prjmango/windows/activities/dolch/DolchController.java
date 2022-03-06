package com.mango.prjmango.windows.activities.dolch;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.student.CreateAStudentController;
import com.mango.prjmango.student.CreateAStudentView;
import com.mango.prjmango.windows.activities.assignment.CreateAssignment;
import com.mango.prjmango.windows.activities.assignment.SightWords;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DolchController {

    public DolchController(DolchView view) {
        //view.startDolchButton().addActionListener(new StartDolchActionListener());
    }
//    private static class StartDolchActionListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            SightWords questions = new SightWords();
//            CreateAssignment assignment = new CreateAssignment(view.getStudentNameField(),view.getAssignmentNameField(),questions.getDolchQuestions(view.getQuestionsComboBox()));
//            AssignmentView assignmentView = new AssignmentView(assignment);
//            MainFrame.setTeacherView(assignmentView);
//        }
//    }
}
