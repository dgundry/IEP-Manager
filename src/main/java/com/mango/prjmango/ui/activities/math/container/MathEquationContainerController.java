package com.mango.prjmango.ui.activities.math.container;

import com.mango.prjmango.ui.activities.math.MathAssignment;
import com.mango.prjmango.ui.activities.math.MathEquation;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class MathEquationContainerController {

    public MathEquationContainerController(MathEquationContainer view, MathAssignment mathAssignment) {
        view.setMathEquation(new MathEquation(mathAssignment.getCurrentQuestion()));

        JLabel nextLabel = view.getNextLabel();
        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel));
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final MathEquationContainer view;
        private final JLabel label;

        public NextLabelMouseListener(MathEquationContainer view, JLabel label) {
            this.view  = view;
            this.label = label;
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
