package com.mango.prjmango.createaccount.securityquestions;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.Components;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import com.mango.prjmango.utilities.DatabaseCommands;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lombok.Getter;

/**
 * This class creates the Security Questions page for the Create Account section.
 */
public class SecurityQuestionsView extends RoundedPanel {

    @Getter private JButton nextButton;
    @Getter private JButton backButton;

    @Getter private JTextField securityOneAnsText;
    @Getter private JTextField securityTwoAnsText;

    @Getter private JComboBox<String> securityQuestionOne;
    @Getter private JComboBox<String> securityQuestionTwo;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public SecurityQuestionsView() {
        setLayout(null);
        setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
        createDropDownQuestions();
    }

    private void createComponents() {
        LoginPageComponents.setCommonComponents(this);

        JLabel securityQuestionsHeader = Components.JLabel("Security Questions", FontType.FONT_20_BOLD);
        securityQuestionsHeader.setBounds(0, (int) (getHeight() * 0.38), getWidth(),30);

        JLabel securityOneHeader = Components.JLabel("Security Question #1", FontType.FONT_12_BOLD);
        securityOneHeader.setBounds(0,( int) (getHeight() * 0.48), getWidth(),15);

        JLabel securityOneAnsHeader = Components.JLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityOneAnsHeader.setBounds(0, (int) (getHeight() * 0.56), getWidth(),15);

        JLabel securityTwoHeader = Components.JLabel("Security Question #2", FontType.FONT_12_BOLD);
        securityTwoHeader.setBounds(0,( int) (getHeight() * 0.65), getWidth(),15);

        JLabel securityTwoAnsHeader = Components.JLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityTwoAnsHeader.setBounds(0, (int) (getHeight() * 0.74), getWidth(),15);

        securityOneAnsText = Components.JTextField("");
        securityOneAnsText.setBounds(
                (int) (getWidth() * 0.5) - ((int) (getWidth() * 0.65) / 2),
                (int) (getHeight() * 0.59),
                (int) (getWidth() * 0.65),
                30);

        securityTwoAnsText = Components.JTextField("");
        securityTwoAnsText.setBounds(
                (int) (getWidth() * 0.5) - ((int) (getWidth() * 0.65) / 2),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.65),
                30);

        nextButton = Components.JButton("Next");
        nextButton.setBounds(
                (int) (getWidth() * 0.65) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.83),
                (int) (getWidth() * 0.20),
                30);

        backButton = Components.JButton("Back");
        backButton.setBounds(
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
        add(backButton);
    }

    private void createDropDownQuestions() {
        List<String> securityQuestionList = DatabaseCommands.getDropDownQuestions();

        securityQuestionList.remove(0);

        securityQuestionOne = Components.JComboBox(securityQuestionList);
        securityQuestionOne.setBounds(
                (int) (getWidth() * 0.5) - ((int) (getWidth() * 0.65) / 2),
                (int) (getHeight() * 0.51),
                (int) (getWidth() * 0.65),
                30);

        securityQuestionTwo = Components.JComboBox(securityQuestionList);
        securityQuestionTwo.setBounds(
                (int) (getWidth() * 0.5) - ((int) (getWidth() * 0.65) / 2),
                (int) (getHeight() * 0.68),
                (int) (getWidth() * 0.65),
                30);

        add(securityQuestionOne);
        add(securityQuestionTwo);
    }
}
