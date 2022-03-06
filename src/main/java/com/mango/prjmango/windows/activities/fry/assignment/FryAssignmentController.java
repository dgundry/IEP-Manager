package com.mango.prjmango.windows.activities.fry.assignment;

import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class FryAssignmentController {

    public FryAssignmentController(FryAssignmentView view) {
        JLabel correctLabel = view.getCorrectLabel();
        JLabel incorrectLabel = view.getIncorrectLabel();

        correctLabel.addMouseListener(new CorrectLabelMouseListener(view, correctLabel));
        incorrectLabel.addMouseListener(new IncorrectLabelMouseListener(view, incorrectLabel));
    }

    private static class CorrectLabelMouseListener implements MouseListener {

        private final FryAssignmentView view;
        private final JLabel label;

        public CorrectLabelMouseListener(FryAssignmentView view, JLabel label) {
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
            //track how many are incorrect
            //change to the next word
            //increase the #/100
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

        private final FryAssignmentView view;
        private final JLabel label;

        public IncorrectLabelMouseListener(FryAssignmentView view, JLabel label) {
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
            //track how many are incorrect
            //change to the next word
            //increase the #/100
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
