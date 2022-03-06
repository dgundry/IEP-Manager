package com.mango.prjmango.windows.createaccount.securityquestions;

import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.createaccount.basicinfo.BasicInfoController;
import com.mango.prjmango.windows.createaccount.basicinfo.BasicInfoView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class SecurityQuestionsController {

    public SecurityQuestionsController(SecurityQuestionsView view) {
        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener(view, nextLabel));
        backLabel.addMouseListener(new BackLabelMouseListener(view, backLabel));
    }

    private static class NextLabelMouseListener implements MouseListener {

        private final SecurityQuestionsView view;
        private final JLabel label;

        public NextLabelMouseListener(SecurityQuestionsView view, JLabel label) {
            this.view = view;
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
            //password page
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

    private static class BackLabelMouseListener implements MouseListener {

        private final SecurityQuestionsView view;
        private final JLabel label;

        public BackLabelMouseListener(SecurityQuestionsView view, JLabel label) {
            this.view = view;
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
            //password page
            BasicInfoView basicInfoView = new BasicInfoView();
            new BasicInfoController(basicInfoView);
            MainWindowView.setActiveDisplay(basicInfoView);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.BACK_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.BACK_NO_HOVER.getImageIcon());
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
