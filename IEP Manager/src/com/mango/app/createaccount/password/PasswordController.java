package com.mango.app.createaccount.password;

import com.mango.app.createaccount.User;
import com.mango.app.createaccount.CreateAccountController;
import com.mango.app.createaccount.CreateAccountView;
import com.mango.app.createaccount.securityquestions.*;
import com.mango.app.mainloginpage.MainLoginView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class PasswordController {

    public PasswordController(PasswordView view, User user) {
        System.out.println(user);
        if(!user.getPassword1().equals("")){
            System.out.println("test");
            view.getPasswordText().setText(user.getPassword1());
        }
        if(!user.getPassword2().equals("")){
            view.getConfirmPasswordText().setText(user.getPassword2());
        }
        view.getBackButton().addActionListener(new BackButtonActionListener(view, user));
        view.getBackButton().addMouseListener(new BackButtonMouseListener(view));
    }

    private static class BackButtonActionListener implements ActionListener {

        private final PasswordView view;
        private User user;

        private BackButtonActionListener(PasswordView view, User user) { this.view = view; this.user = user;}
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */

        public void actionPerformed(ActionEvent e){
            User newUser = user.copyUser();
            newUser.setPassword1(view.getPasswordText().getText());
            newUser.setPassword2(view.getConfirmPasswordText().getText());
            System.out.println(newUser);

            SecurityQuestionsPageOneView securityQuestionsPageOneView = new SecurityQuestionsPageOneView();
            //populate text fields with the user's security questions in the text fields / dropdown
            new SecurityQuestionsOneController(securityQuestionsPageOneView, newUser);
            MainLoginView.setActivePanel(securityQuestionsPageOneView.getSecurityQuestionsPanel());
        }
    }

    private static class BackButtonMouseListener implements MouseListener {

        private final PasswordView view;

        private BackButtonMouseListener(PasswordView view) { this.view = view; }


        public void mouseClicked(MouseEvent e) {/* Not Needed */}

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
}
