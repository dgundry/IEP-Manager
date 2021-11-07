package com.mango.app.forgotpassword.securityquestions;

import com.mango.app.Main;
import com.mango.app.components.ButtonMouseListener;
import com.mango.app.createaccount.CreateAccountController;
import com.mango.app.createaccount.CreateAccountView;
import com.mango.app.createaccount.User;
import com.mango.app.createaccount.password.PasswordController;
import com.mango.app.createaccount.password.PasswordView;
import com.mango.app.createaccount.securityquestions.SecurityQuestionsController;
import com.mango.app.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.app.forgotpassword.password.ChangePasswordController;
import com.mango.app.forgotpassword.password.ChangePasswordView;
import com.mango.app.mainloginpage.MainLoginView;
import com.mango.app.utilities.Encryption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnswerSecurityQuestionsController {
    private static final Logger logger = Logger.getLogger(AnswerSecurityQuestionsController.class.getName());
    public AnswerSecurityQuestionsController(AnswerSecurityQuestionsView view, int teacher_id) {
        view.getBackButton().addActionListener(new AnswerSecurityQuestionsController.BackButtonActionListener(view));
        view.getBackButton().addMouseListener(new ButtonMouseListener(view.getBackButton()));

        view.getNextButton().addActionListener(new AnswerSecurityQuestionsController.NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));
    }

    private static class BackButtonActionListener implements ActionListener {

        public BackButtonActionListener(AnswerSecurityQuestionsView view) {
        }
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private static class NextButtonActionListener implements ActionListener {

        private final AnswerSecurityQuestionsView view;
        public NextButtonActionListener(AnswerSecurityQuestionsView view) {
            this.view = view;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Encryption encryption = new Encryption();
            boolean hasFailed = false;
            String sql = "SELECT teacher_id, question_id, answer FROM questions WHERE (teacher_id = ? AND (question_id = ? OR question_id = ?));";
            try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
                statement.setString(1, String.valueOf(view.getTeacher_id()));
                statement.setString(2, String.valueOf(view.getQuestionIndexOne()));
                statement.setString(3, String.valueOf(view.getQuestionIndexTwo()));
                ResultSet resultSet = statement.executeQuery();
                do {
                    if(resultSet.getInt(2) == view.getQuestionIndexOne()){
                        if (!Encryption.encryptPassword(view.getSecurityOneAnsText().getText()).equals(resultSet.getString(3))){
                            System.out.println("Failed First");
                            hasFailed = true;
                        }
                    }else if(resultSet.getInt(2) == view.getQuestionIndexTwo()){
                        if (!Encryption.encryptPassword(view.getSecurityTwoAnsText().getText()).equals(resultSet.getString(3))){
                            System.out.println("Failed Second");
                            hasFailed = true;
                        }
                    }
                } while (resultSet.next() && !hasFailed);
            } catch (SQLException ex) {
                logger.log(Level.WARNING, ex.getMessage());
            }
            if(hasFailed){
                System.out.println("Answers are incorrect.");
            }else{
                System.out.println("Answers are correct.");
                ChangePasswordView changePasswordView = new ChangePasswordView(view.getTeacher_id());
                new ChangePasswordController(changePasswordView);
                MainLoginView.setActivePanel(changePasswordView.getChangePasswordPanel());
            }
        }
    }
}
