package com.mango.app.createaccount.password;

import com.mango.app.components.*;
import com.mango.app.createaccount.User;
import com.mango.app.createaccount.securityquestions.*;
import com.mango.app.mainloginpage.MainLoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getCreateAccountButton().addActionListener(new CreateAccountButtonActionListener());
        view.getCreateAccountButton().addMouseListener(new ButtonMouseListener(view.getCreateAccountButton()));
    }

    private static class BackButtonActionListener implements ActionListener {

        private final PasswordView view;
        private final User user;

        public BackButtonActionListener(PasswordView view, User user) {
            this.view = view;
            this.user = user;
        }
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */

        public void actionPerformed(ActionEvent e){
            user.setPassword1(view.getPasswordText().getText());
            user.setPassword2(view.getConfirmPasswordText().getText());

            SecurityQuestionsView securityQuestionsView = new SecurityQuestionsView();
            securityQuestionsView.getSecurityQuestionOneDropDown().setSelectedIndex(user.getSecurityQ1());
            securityQuestionsView.getSecurityQuestionTwoDropDown().setSelectedIndex(user.getSecurityQ2());
            securityQuestionsView.getSecurityOneAnsText().setText(user.getSecurityA1());
            securityQuestionsView.getSecurityTwoAnsText().setText(user.getSecurityA2());

            new SecurityQuestionsController(securityQuestionsView, user);
            MainLoginView.setActivePanel(securityQuestionsView.getSecurityQuestionsPanel());
        }
    }

    private static class CreateAccountButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //Add user to database
            //Verify all input
        }
    }
}
