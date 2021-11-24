package com.mango.prjmango.forgotpassword.securityquestions;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import lombok.Getter;

public class AnswerSecurityQuestionsView extends RoundedPanel {

    private static final Logger logger = Logger.getLogger(AnswerSecurityQuestionsView.class.getName());

    private final @Getter int teacherID;

    private @Getter JButton nextButton;
    private @Getter JButton cancelButton;

    private @Getter JTextField securityOneAnsText;
    private @Getter JTextField securityTwoAnsText;

    private @Getter JLabel securityQuestionOne;
    private @Getter JLabel securityQuestionTwo;

    private final @Getter int[] questionIndexes;
    private final String[] question_texts;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public AnswerSecurityQuestionsView(int teacherID) {
        this.teacherID = teacherID;

        this.setLayout(null);
        this.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
        questionIndexes = getQuestionIds();
        question_texts = getQuestionTexts();
        setQuestions();
    }

    private void createComponents() {
        LoginPageComponents.setCommonComponents(this);

        JLabel securityQuestionsHeader = createLabel("Security Questions", FontType.FONT_20_BOLD);
        securityQuestionsHeader.setBounds(0, (int) (this.getHeight() * 0.38), this.getWidth(),30);

        JLabel securityOneHeader = createLabel("Security Question #1", FontType.FONT_12_BOLD);
        securityOneHeader.setBounds(0,( int) (this.getHeight() * 0.48), this.getWidth(),15);

        JLabel securityOneAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityOneAnsHeader.setBounds(0, (int) (this.getHeight() * 0.56), this.getWidth(),15);

        securityOneAnsText = new JTextField("Answer #1");
        securityOneAnsText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.59),
                (int) (this.getWidth() * 0.5),
                30);
        securityOneAnsText.setBackground(Color.WHITE);

        JLabel securityTwoHeader = createLabel("Security Question #2", FontType.FONT_12_BOLD);
        securityTwoHeader.setBounds(0,( int) (this.getHeight() * 0.65), this.getWidth(),15);

        JLabel securityTwoAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityTwoAnsHeader.setBounds(0, (int) (this.getHeight() * 0.74), this.getWidth(),15);

        securityTwoAnsText = new JTextField("Answer #2");
        securityTwoAnsText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.77),
                (int) (this.getWidth() * 0.5),
                30);
        securityTwoAnsText.setBackground(Color.WHITE);

        nextButton = createButton("Next");
        nextButton.setBounds(
                (int) (this.getWidth() * 0.65) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.83),
                (int) (this.getWidth() * 0.20),
                30);

        cancelButton = createButton("Cancel");
        cancelButton.setBounds(
                (int) (this.getWidth() * 0.35) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.83),
                (int) (this.getWidth() * 0.20),
                30);

        this.add(securityQuestionsHeader);
        this.add(securityOneHeader);
        this.add(securityOneAnsHeader);
        this.add(securityTwoHeader);
        this.add(securityTwoAnsHeader);
        this.add(securityOneAnsText);
        this.add(securityTwoAnsText);
        this.add(nextButton);
        this.add(cancelButton);
    }

    private int[] getQuestionIds(){
        int[] questionIds = new int[2];
        int index = 0;
        String sql = "SELECT question_id FROM questions WHERE teacher_id = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(teacherID));
            ResultSet resultSet = statement.executeQuery();
            do {
                if(index != 0){
                    if(questionIds[0] != resultSet.getInt(1)){
                        questionIds[index] = resultSet.getInt(1);
                    }
                }else {
                    questionIds[index] = resultSet.getInt(1);
                    index++;
                }
            } while (resultSet.next() && index <= 1);
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        System.out.println(questionIds[0]);
        System.out.println(questionIds[1]);
        return questionIds;
    }
    private String[] getQuestionTexts(){
        String[] questionTexts = new String[2];
        int index = 0;
        String sql = "SELECT question FROM question WHERE (question_id = ? OR question_id = ?);";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(questionIndexes[0]));
            statement.setString(2, String.valueOf(questionIndexes[1]));
            ResultSet resultSet2 = statement.executeQuery();
            do {
                if(index != 0){
                    if(questionTexts[0] != resultSet2.getString(1)){
                        questionTexts[index] = resultSet2.getString(1);
                    }
                }else {
                    questionTexts[index] = resultSet2.getString(1);
                    index++;
                }
            } while (resultSet2.next() && index <= 1);
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        return questionTexts;
    }
    private void setQuestions() {
        securityQuestionOne = new JLabel(question_texts[0]);
        securityQuestionOne.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.51),
                (int) (this.getWidth() * 0.5),
                30);
        securityQuestionOne.setBackground(Color.WHITE);

        securityQuestionTwo = new JLabel(question_texts[1]);
        securityQuestionTwo.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.68),
                (int) (this.getWidth() * 0.5),
                30);
        securityQuestionTwo.setBackground(Color.WHITE);
        this.add(securityQuestionOne);
        this.add(securityQuestionTwo);

    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(245,102,0));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }
}