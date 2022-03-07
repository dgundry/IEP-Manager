package com.mango.prjmango.windows.activities.dolch.assignment;

import com.mango.prjmango.windows.activities.fry.assignment.FryAssignmentController;
import com.mango.prjmango.windows.activities.fry.assignment.FryAssignmentView;
import com.mango.prjmango.windows.common.ImageIcons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DolchAssignmentController {

    public DolchAssignmentController(DolchAssignmentView view) {
        JLabel correctLabel = view.getCorrectLabel();
        JLabel incorrectLabel = view.getIncorrectLabel();

        correctLabel.addMouseListener(new DolchAssignmentController.CorrectLabelMouseListener(view, correctLabel));
        incorrectLabel.addMouseListener(new DolchAssignmentController.IncorrectLabelMouseListener(view, incorrectLabel));
    }
    private static class CorrectLabelMouseListener implements MouseListener {

        private final DolchAssignmentView view;
        private final JLabel label;

        public CorrectLabelMouseListener(DolchAssignmentView view, JLabel label) {
            this.label = label;
            this.view  = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            view.getAssignment().setStudentAnswer(true);
            if(view.getAssignment().hasNextQuestion()){
                view.getWordLabel().setText(view.getAssignment().getNextQuestion());
                view.getNumberWordLabel().setText(view.getAssignment().getCurrentQuestionIndex()+1 + "/" + view.getAssignment().getTotalQuestions());
            }else{
                //assignment is done, go to final score screen
            }
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.FRY_ASSIGNMENT_CORRECT_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.FRY_ASSIGNMENT_CORRECT_NO_HOVER.getImageIcon());
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

    private static class IncorrectLabelMouseListener implements MouseListener {

        private final DolchAssignmentView view;
        private final JLabel label;

        public IncorrectLabelMouseListener(DolchAssignmentView view, JLabel label) {
            this.label = label;
            this.view  = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            view.getAssignment().setStudentAnswer(false);
            if(view.getAssignment().hasNextQuestion()){
                view.getWordLabel().setText(view.getAssignment().getNextQuestion());
                view.getNumberWordLabel().setText(view.getAssignment().getCurrentQuestionIndex()+1 + "/" + view.getAssignment().getTotalQuestions());
            }else{
                //assignment is done, go to final score screen
            }
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.FRY_ASSIGNMENT_INCORRECT_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.FRY_ASSIGNMENT_INCORRECT_NO_HOVER.getImageIcon());
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
