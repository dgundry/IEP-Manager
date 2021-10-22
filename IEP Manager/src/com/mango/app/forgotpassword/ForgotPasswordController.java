package com.mango.app.forgotpassword;

import com.mango.app.login.*;
import com.mango.app.mainloginpage.*;
import java.awt.event.*;

public class ForgotPasswordController {

    public ForgotPasswordController(SecurityQuestionsPageOneView view) {
        view.getBackButton().addActionListener(new SQPOBackButtonActionListener());
    }

    public ForgotPasswordController(SecurityQuestionsPageTwoView securityQuestionsPageTwoView) {}

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
            MainLoginView.setActivePanel(loginPageView.getLoginPanel());
        }
    }
}
