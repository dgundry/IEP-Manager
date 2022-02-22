package com.mango.prjmango.forgotpassword.securityquestions;

import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.components.listeners.TextFieldFocusListener;
import com.mango.prjmango.forgotpassword.password.ChangePasswordController;
import com.mango.prjmango.forgotpassword.password.ChangePasswordView;
import com.mango.prjmango.utilities.DatabaseCommands;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import static com.mango.prjmango.Main.frame;

/**
 * Handles user interaction within the Answer Security Questions page on the Forgot Password section.
 */
public class AnswerSecurityQuestionsController {

    private final String SECURITY_ANSWER_1_DEFAULT = "Answer #1";
    private final String SECURITY_ANSWER_2_DEFAULT = "Answer #2";

    /**
     * Constructor. Initializes listeners for {@link JComponent}'s within the {@link AnswerSecurityQuestionsView}.
     *
     * @param view the {@link AnswerSecurityQuestionsView} to access {@link JComponent}'s
     */
    public AnswerSecurityQuestionsController(AnswerSecurityQuestionsView view) {
        view.getCancelButton().addActionListener(new CancelButtonActionListener());
        view.getCancelButton().addMouseListener(new ButtonMouseListener(view.getCancelButton()));

        view.getNextButton().addActionListener(new NextButtonActionListener(view, view.getTeacherID()));
        view.getNextButton().addMouseListener(new ButtonMouseListener(view.getNextButton()));

        view.getSecurityOneAnsText().addFocusListener(
                new TextFieldFocusListener(view.getSecurityOneAnsText(), SECURITY_ANSWER_1_DEFAULT));
        view.getSecurityTwoAnsText().addFocusListener(
                new TextFieldFocusListener(view.getSecurityTwoAnsText(), SECURITY_ANSWER_2_DEFAULT));
    }

    private static class CancelButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setLoginPage();
        }
    }

    private static class NextButtonActionListener implements ActionListener {

        private final AnswerSecurityQuestionsView view;

        private final int teacherId;

        public NextButtonActionListener(AnswerSecurityQuestionsView view, int teacherId) {
            this.view = view;
            this.teacherId = teacherId;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] questionIndexes = view.getQuestionIndexes();
            String answer1 = view.getSecurityOneAnsText().getText();
            String answer2 = view.getSecurityTwoAnsText().getText();

            boolean hasFailed = DatabaseCommands.isSecurityQuestionsAnswersCorrect(
                    teacherId, questionIndexes, answer1, answer2);

            if (hasFailed) {
                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Security Questions do not match our records.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                ChangePasswordView changePasswordView = new ChangePasswordView(teacherId);
                new ChangePasswordController(changePasswordView);
                MainFrame.setActivePanel(changePasswordView);
            }
        }
    }
}
