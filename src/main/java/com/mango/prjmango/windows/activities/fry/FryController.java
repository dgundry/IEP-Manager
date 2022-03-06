package com.mango.prjmango.windows.activities.fry;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.windows.activities.assignment.CreateAssignment;
import com.mango.prjmango.windows.activities.assignment.SightWords;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FryController {

    public FryController(FryView view) {
        //view.startFryButton().addActionListener(new StartFryActionListener());
    }
//    private static class StartFryActionListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            SightWords questions = new SightWords();
//            CreateAssignment assignment = new CreateAssignment(view.getStudentNameField(),view.getAssignmentNameField(),questions.getFryQuestions(view.getQuestionsComboBox()));
//            AssignmentView assignmentView = new AssignmentView(assignment);
//            MainFrame.setTeacherView(assignmentView);
//        }
//    }
}
