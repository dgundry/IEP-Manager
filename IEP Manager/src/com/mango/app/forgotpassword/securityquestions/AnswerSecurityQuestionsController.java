package com.mango.app.forgotpassword.securityquestions;

import com.mango.app.Main;
import com.mango.app.components.listeners.ButtonMouseListener;
import com.mango.app.forgotpassword.password.ChangePasswordController;
import com.mango.app.forgotpassword.password.ChangePasswordView;
import com.mango.app.login.LoginPageController;
import com.mango.app.login.LoginPageView;
import com.mango.app.mainloginpage.MainLoginView;
import com.mango.app.utilities.Encryption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnswerSecurityQuestionsController {
    private static final Logger logger = Logger.getLogger(AnswerSecurityQuestionsController.class.getName());
    public AnswerSecurityQuestionsController(AnswerSecurityQuestionsView view, int teacher_id) {
        view.getCancelButton().addActionListener(new AnswerSecurityQuestionsController.CancelButtonActionListener(view));
        view.getCancelButton().addMouseListener(new ButtonMouseListener(view.getCancelButton()));

        view.getNextButton().addActionListener(new AnswerSecurityQuestionsController.NextButtonActionListener(view));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));


        view.getSecurityOneAnsText().addMouseListener(new SecurityQuestionOneMouseListener(view));
        view.getSecurityTwoAnsText().addMouseListener(new SecurityQuestionTwoMouseListener(view));


    }

    private static class CancelButtonActionListener implements ActionListener {

        public CancelButtonActionListener(AnswerSecurityQuestionsView view) {
        }
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
                JOptionPane.showMessageDialog(
                        MainLoginView.getLoginWindow(),
                        "Security Questions do not match our records.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);
            }else{
                System.out.println("Answers are correct.");
                ChangePasswordView changePasswordView = new ChangePasswordView(view.getTeacher_id());
                new ChangePasswordController(changePasswordView);
                MainLoginView.setActivePanel(changePasswordView.getChangePasswordPanel());
            }
        }
    }
    private static class SecurityQuestionOneMouseListener implements MouseListener {

        private final AnswerSecurityQuestionsView answerSecurityQuestionsView;

        public SecurityQuestionOneMouseListener(AnswerSecurityQuestionsView answerSecurityQuestionsView) { this.answerSecurityQuestionsView = answerSecurityQuestionsView; }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(answerSecurityQuestionsView.getSecurityOneAnsText().getText().equals("Security #1")){
                answerSecurityQuestionsView.getSecurityOneAnsText().setText("");

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
    private static class SecurityQuestionTwoMouseListener implements MouseListener {

        private final AnswerSecurityQuestionsView answerSecurityQuestionsView;

        public SecurityQuestionTwoMouseListener(AnswerSecurityQuestionsView answerSecurityQuestionsView) { this.answerSecurityQuestionsView = answerSecurityQuestionsView; }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(answerSecurityQuestionsView.getSecurityTwoAnsText().getText().equals("Security #2")){
                answerSecurityQuestionsView.getSecurityTwoAnsText().setText("");

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
}
