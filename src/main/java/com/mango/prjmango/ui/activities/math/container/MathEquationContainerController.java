package com.mango.prjmango.ui.activities.math.container;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.Outlines.Outlines;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.activities.FinishAssignmentController;
import com.mango.prjmango.ui.activities.FinishAssignmentView;
import com.mango.prjmango.ui.activities.math.MathAssignment;
import com.mango.prjmango.ui.activities.math.MathEquation;
import com.mango.prjmango.ui.activities.upload.UploadController;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.students.StudentsController;
import com.mango.prjmango.ui.students.StudentsView;
import com.mango.prjmango.utilities.dbcommands.UserCommands;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MathEquationContainerController {

    private JTextField answerField;
    public MathEquationContainerController(MathEquationContainer view, MathAssignment mathAssignment) {
        answerField = view.getAnswerTextField();
        view.setMathEquation(new MathEquation(mathAssignment.getCurrentQuestion()));
        JLabel nextLabel = view.getNextLabel();
        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel, mathAssignment));
        view.getAnswerTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitAnswer(view, mathAssignment);
                }
            }
        });
    }
    private static void submitAnswer(MathEquationContainer view, MathAssignment mathAssignment) {
        try {
            mathAssignment.answerQuestion(Integer.parseInt(view.getAnswerTextField().getText()));
            if(mathAssignment.hasNextQuestion()) {
                mathAssignment.nextQuestion();
                view.setMathEquation(new MathEquation(mathAssignment.getCurrentQuestion()));
                view.getCurrentNumberLabel().setText(mathAssignment.getCurrentQuestionIndex() + 1 + "/" + mathAssignment.getNumberOfQuestions());
                view.getAnswerTextField().setText("");
                view.getAnswerTextField().requestFocus();
            }else{
                FinishAssignmentView finishAssignmentView = new FinishAssignmentView(mathAssignment);
                new FinishAssignmentController(finishAssignmentView);
                ActivitiesView.setActiveDisplay(finishAssignmentView);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid answer");
        }
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final MathEquationContainer view;
        private final JLabel label;
        private final MathAssignment mathAssignment;

        public NextLabelMouseListener(MathEquationContainer view, JLabel label, MathAssignment mathAssignment) {
            this.view  = view;
            this.label = label;
            this.mathAssignment = mathAssignment;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link java.awt.event.MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            //TODO check answer
            submitAnswer(view, mathAssignment);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.NEXT_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.NEXT_NO_HOVER.getImageIcon());
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }
}
