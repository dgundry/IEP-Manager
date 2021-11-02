package com.mango.app.createaccount.securityquestions;

import com.mango.app.createaccount.User;
import com.mango.app.createaccount.CreateAccountController;
import com.mango.app.createaccount.CreateAccountView;
import com.mango.app.createaccount.password.PasswordController;
import com.mango.app.createaccount.password.PasswordView;
import com.mango.app.mainloginpage.MainLoginView;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.*;
import java.util.*;

public class SecurityQuestionsOneController {

    public SecurityQuestionsOneController(SecurityQuestionsPageOneView view, User user) {
        view.getBackButton().addActionListener(new BackButtonActionListener());
        view.getBackButton().addMouseListener(new BackButtonMouseListener(view));

        view.getNextButton().addActionListener(new NextButtonActionListener(user));
        view.getNextButton().addMouseListener(new NextButtonMouseListener(view));
    }

    private static class BackButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            CreateAccountView createAccountView = new CreateAccountView();
            new CreateAccountController(createAccountView);
            MainLoginView.setActivePanel(createAccountView.getCreateAccountPanel());
        }
    }

    private static class BackButtonMouseListener implements MouseListener {

        private final SecurityQuestionsPageOneView view;

        public BackButtonMouseListener(SecurityQuestionsPageOneView view) {
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

    private static class NextButtonActionListener implements ActionListener {

        private final User user;

        public NextButtonActionListener(User user) { this.user = user; }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            PasswordView passwordView = new PasswordView();
            new PasswordController(passwordView, user);
            MainLoginView.setActivePanel(passwordView.getCreatePasswordPanel());
        }
    }

    private static class NextButtonMouseListener implements MouseListener {

        private final SecurityQuestionsPageOneView view;

        public NextButtonMouseListener(SecurityQuestionsPageOneView view) {
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
