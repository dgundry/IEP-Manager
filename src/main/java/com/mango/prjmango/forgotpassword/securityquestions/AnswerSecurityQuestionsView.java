package com.mango.prjmango.forgotpassword.securityquestions;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.Components;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import com.mango.prjmango.utilities.DatabaseCommands;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lombok.Getter;

/**
 * This class creates the Answer Security Questions page for the Forgot Password section.
 */
public class AnswerSecurityQuestionsView extends RoundedPanel {

    @Getter private final int teacherID;

    @Getter private JButton nextButton;
    @Getter private JButton cancelButton;

    @Getter private JTextField securityOneAnsText;
    @Getter private JTextField securityTwoAnsText;

    @Getter private JLabel securityQuestionOne;
    @Getter private JLabel securityQuestionTwo;

    @Getter private final int[] questionIndexes;
    @Getter private final String[] question_texts;

    /**
     * The constructor which sets up the GUI for the Answer Security Questions page.
     */
    public AnswerSecurityQuestionsView(int teacherID) {
        this.teacherID = teacherID;

        setLayout(null);
        setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
        questionIndexes = DatabaseCommands.getQuestionIds(teacherID);
        question_texts = DatabaseCommands.getQuestionTexts(questionIndexes);
        setQuestions();
    }

    private void createComponents() {
        LoginPageComponents.setCommonComponents(this);

        JLabel securityQuestionsHeader = Components.JLabel("Security Questions", FontType.FONT_20_BOLD);
        securityQuestionsHeader.setBounds(0, (int) (getHeight() * 0.38), getWidth(), 30);

        JLabel securityOneHeader = Components.JLabel("Security Question #1", FontType.FONT_12_BOLD);
        securityOneHeader.setBounds(0, (int) (getHeight() * 0.48), getWidth(), 15);

        JLabel securityOneAnsHeader = Components.JLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityOneAnsHeader.setBounds(0, (int) (getHeight() * 0.56), getWidth(), 15);

        JLabel securityTwoHeader = Components.JLabel("Security Question #2", FontType.FONT_12_BOLD);
        securityTwoHeader.setBounds(0, (int) (getHeight() * 0.65), getWidth(), 15);

        JLabel securityTwoAnsHeader = Components.JLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityTwoAnsHeader.setBounds(0, (int) (getHeight() * 0.74), getWidth(), 15);

        securityOneAnsText = Components.JTextField("Answer #1");
        securityOneAnsText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.59),
                (int) (getWidth() * 0.5),
                30);

        securityTwoAnsText = Components.JTextField("Answer #2");
        securityTwoAnsText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.5),
                30);

        nextButton = Components.JButton("Next");
        nextButton.setBounds(
                (int) (getWidth() * 0.65) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.83),
                (int) (getWidth() * 0.20),
                30);

        cancelButton = Components.JButton("Cancel");
        cancelButton.setBounds(
                (int) (getWidth() * 0.35) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.83),
                (int) (getWidth() * 0.20),
                30);

        add(securityQuestionsHeader);
        add(securityOneHeader);
        add(securityOneAnsHeader);
        add(securityTwoHeader);
        add(securityTwoAnsHeader);
        add(securityOneAnsText);
        add(securityTwoAnsText);
        add(nextButton);
        add(cancelButton);
    }

    private void setQuestions() {
        securityQuestionOne = Components.JLabel(question_texts[0], FontType.FONT_12_BOLD);
        securityQuestionOne.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.51),
                (int) (getWidth() * 0.5),
                30);

        securityQuestionTwo = Components.JLabel(question_texts[1], FontType.FONT_12_BOLD);
        securityQuestionTwo.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.68),
                (int) (getWidth() * 0.5),
                30);

        add(securityQuestionOne);
        add(securityQuestionTwo);
    }
}
