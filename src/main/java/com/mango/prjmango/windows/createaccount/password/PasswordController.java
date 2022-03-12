package com.mango.prjmango.windows.createaccount.password;


import com.mango.prjmango.MainFrame;
import com.mango.prjmango.createaccount.Register;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.utilities.User;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.createaccount.basicinfo.BasicInfoController;
import com.mango.prjmango.windows.createaccount.basicinfo.BasicInfoView;
import com.mango.prjmango.windows.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.prjmango.windows.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.windows.login.LoginController;
import com.mango.prjmango.windows.login.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class PasswordController {

    public PasswordController(PasswordView view, User user) {
        JLabel nextLabel = view.getNextLabel();
        JLabel backLabel = view.getBackLabel();

        nextLabel.addMouseListener(new NextLabelMouseListener( view, nextLabel,user));
        backLabel.addMouseListener(new BackLabelMouseListener(backLabel, user));


    }

    private static class NextLabelMouseListener implements MouseListener{
        private final PasswordView view;
        private final JLabel label;
        private final User user;


        public NextLabelMouseListener(PasswordView view, JLabel label, User user){
            this.view = view;
            this.label = label;
            this.user = user;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            view.getInvalidLabel().setText("");

            char[] password1 = view.getCreatePasswordField().getPassword();

            char[] password2 = view.getConfirmPasswordField().getPassword();


            if(password1.length == 0){
                view.getInvalidLabel().setText("First password field is empty!");
                view.getInvalidLabel().setForeground(Color.RED);
                view.getCreatePasswordField().requestFocus();
            }else if(password2.length == 0) {
                view.getInvalidLabel().setText("confirm password field is empty!");
                view.getInvalidLabel().setForeground(Color.RED);
                view.getConfirmPasswordField().requestFocus();
            } else if(!Arrays.equals(password1, password2)) {
                view.getInvalidLabel().setText("Passwords do not match!");
                view.getInvalidLabel().setForeground(Color.RED);
                view.getCreatePasswordField().requestFocus();
            } else {
                Register register = new Register();
                user.setSecurityQ1(user.getSecurityQ1()+1);
                user.setSecurityQ2(user.getSecurityQ2()+1);
                user.setPassword1(view.getCreatePasswordField().getPassword());
                user.setPassword2(view.getConfirmPasswordField().getPassword());

                if (register.createUser(user)) {
                    //Dialog.openDialog(Dialog.ACCOUNT_CREATED); <----Temporary Change

                    JOptionPane.showMessageDialog(
                            MainFrame.getFrame(),
                            "Account created!",
                            "Success!",
                            JOptionPane.PLAIN_MESSAGE);

                    LoginView loginView = new LoginView();
                    new LoginController(loginView);
                    MainWindowView.setActiveDisplay(loginView);
                } else {
                    JOptionPane.showMessageDialog(
                            MainFrame.getFrame(),
                            "Something went wrong with registering.",
                            "FAILURE",
                            JOptionPane.ERROR_MESSAGE);
                }
            }


        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }


    private static class BackLabelMouseListener implements MouseListener {

        private final JLabel label;
        private final User user;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param label the specific {@link JLabel}
         * @param user  the current {@link User} object that is creating their account
         */
        public BackLabelMouseListener(JLabel label, User user) {
            this.label = label;
            this.user  = user;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
            new SecurityQuestionsController(securityQuestionsView, user);
            MainWindowView.setActiveDisplay(securityQuestionsView);
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

