package com.mango.prjmango.ui.activities.math;

import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class MathController {

    public MathController(MathView view) {
        JLabel beginPracticeLabel = view.getBeginPracticeLabel();

        beginPracticeLabel.addMouseListener(new BeginPracticeMouseListener(view, beginPracticeLabel));
    }

    private static class BeginPracticeMouseListener implements MouseListener {

        private final MathView view;
        private final JLabel label;

        public BeginPracticeMouseListener(MathView view, JLabel label) {
            this.view  = view;
            this.label = label;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.BEGIN_PRACTICE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.BEGIN_PRACTICE_NO_HOVER.getImageIcon());
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
