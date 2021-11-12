package com.mango.prjmango.forgotpassword;

import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.mainloginpage.MainLoginView;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class ForgotPasswordController {

    public ForgotPasswordController(SecurityQuestionsView view) {
        view.getBackButton().addActionListener(new SQPOBackButtonActionListener());
        view.getNextButton().addActionListener(new SQPONextButtonActionListener());

        view.getBackButton().addMouseListener(new SQPOBackButtonMouseListener(view));
        view.getNextButton().addMouseListener(new SQPONextButtonMouseListener(view));
    }


    private static class SQPOBackButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginPageView loginPageView = new LoginPageView();
            new LoginPageController(loginPageView);
            MainLoginView.setActivePanel(loginPageView);
        }
    }

    private static class SQPONextButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Next button clicked.");
        }
    }

    private static class SQPOBackButtonMouseListener implements MouseListener {

        private final SecurityQuestionsView view;

        public SQPOBackButtonMouseListener(SecurityQuestionsView view) {
            this.view = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            view.getBackButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getBackButton().setFont(view.getBackButton().getFont().deriveFont(Font.BOLD));

            Font font = view.getBackButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            view.getBackButton().setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            view.getBackButton().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            view.getBackButton().setFont(view.getBackButton().getFont().deriveFont(Font.PLAIN));

            Font font = view.getBackButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            view.getBackButton().setFont(font.deriveFont(attributes));
        }
    }

    private static class SQPONextButtonMouseListener implements MouseListener {

        private final SecurityQuestionsView view;

        public SQPONextButtonMouseListener(SecurityQuestionsView view) {
            this.view = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            view.getNextButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getNextButton().setFont(view.getNextButton().getFont().deriveFont(Font.BOLD));

            Font font = view.getNextButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            view.getNextButton().setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {
            view.getNextButton().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            view.getNextButton().setFont(view.getNextButton().getFont().deriveFont(Font.PLAIN));

            Font font = view.getNextButton().getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            view.getNextButton().setFont(font.deriveFont(attributes));
        }
    }
}
