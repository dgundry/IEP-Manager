package com.mango.app.forgotpassword.securityquestions;

import com.mango.app.Main;
import com.mango.app.components.FontType;
import com.mango.app.components.RoundedPanel;
import com.mango.app.createaccount.securityquestions.SecurityQuestionsView;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnswerSecurityQuestionsView {
    private static final Logger logger = Logger.getLogger(SecurityQuestionsView.class.getName());

    private final RoundedPanel securityQuestionsPanel;

    private JButton nextButton;
    private JButton backButton;

    private JTextField securityOneAnsText;
    private JTextField securityTwoAnsText;

    private JLabel securityQuestionOne;
    private JLabel securityQuestionTwo;

    private final int teacher_id;
    private int[] question_ids = new int[2];
    private String[] question_texts = new String[2];

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public AnswerSecurityQuestionsView(int teacher_id) {
        this.teacher_id = teacher_id;
        securityQuestionsPanel = new RoundedPanel();
        securityQuestionsPanel.setLayout(null);
        securityQuestionsPanel.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
        question_ids = getQuestionIds();
        question_texts = getQuestionTexts();
        setQuestions();
    }

    private void createComponents() {
        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - 50,
                (int) (securityQuestionsPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/Mango3.png",
                50,
                50)));
        mangoLogo.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - 25,
                (securityQuestionsPanel.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (securityQuestionsPanel.getHeight() * 0.28) , securityQuestionsPanel.getWidth(),45);

        JLabel securityQuestionsHeader = createLabel("Security Questions", FontType.FONT_20_BOLD);
        securityQuestionsHeader.setBounds(0, (int) (securityQuestionsPanel.getHeight() * 0.38), securityQuestionsPanel.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.20),
                (int) (securityQuestionsPanel.getHeight() * 0.45),
                (int) (securityQuestionsPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel securityOneHeader = createLabel("Security Question #1", FontType.FONT_12_BOLD);
        securityOneHeader.setBounds(0,( int) (securityQuestionsPanel.getHeight() * 0.48), securityQuestionsPanel.getWidth(),15);

        JLabel securityOneAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityOneAnsHeader.setBounds(0, (int) (securityQuestionsPanel.getHeight() * 0.56), securityQuestionsPanel.getWidth(),15);

        securityOneAnsText = new JTextField("Answer #1");
        securityOneAnsText.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.25),
                (int) (securityQuestionsPanel.getHeight() * 0.59),
                (int) (securityQuestionsPanel.getWidth() * 0.5),
                30);
        securityOneAnsText.setBackground(Color.WHITE);

        JLabel securityTwoHeader = createLabel("Security Question #2", FontType.FONT_12_BOLD);
        securityTwoHeader.setBounds(0,( int) (securityQuestionsPanel.getHeight() * 0.65), securityQuestionsPanel.getWidth(),15);

        JLabel securityTwoAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityTwoAnsHeader.setBounds(0, (int) (securityQuestionsPanel.getHeight() * 0.74), securityQuestionsPanel.getWidth(),15);

        securityTwoAnsText = new JTextField("Answer #2");
        securityTwoAnsText.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.25),
                (int) (securityQuestionsPanel.getHeight() * 0.77),
                (int) (securityQuestionsPanel.getWidth() * 0.5),
                30);
        securityTwoAnsText.setBackground(Color.WHITE);

        nextButton = createButton("Next");
        nextButton.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.65) - (int) (securityQuestionsPanel.getWidth() * 0.10),
                (int) (securityQuestionsPanel.getHeight() * 0.83),
                (int) (securityQuestionsPanel.getWidth() * 0.20),
                30);

        backButton = createButton("Back");
        backButton.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.35) - (int) (securityQuestionsPanel.getWidth() * 0.10),
                (int) (securityQuestionsPanel.getHeight() * 0.83),
                (int) (securityQuestionsPanel.getWidth() * 0.20),
                30);

        securityQuestionsPanel.add(schoolLogo);
        securityQuestionsPanel.add(mangoLogo);
        securityQuestionsPanel.add(titleHeader);
        securityQuestionsPanel.add(securityQuestionsHeader);
        securityQuestionsPanel.add(separatorHeader);
        securityQuestionsPanel.add(securityOneHeader);
        securityQuestionsPanel.add(securityOneAnsHeader);
        securityQuestionsPanel.add(securityTwoHeader);
        securityQuestionsPanel.add(securityTwoAnsHeader);
        securityQuestionsPanel.add(securityOneAnsText);
        securityQuestionsPanel.add(securityTwoAnsText);
        securityQuestionsPanel.add(nextButton);
        securityQuestionsPanel.add(backButton);
    }

    private int[] getQuestionIds(){
        int[] questionIds = new int[2];
        int index = 0;
        String sql = "SELECT question_id FROM questions WHERE teacher_id = ?;";
        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            statement.setString(1, String.valueOf(teacher_id));
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
            statement.setString(1, String.valueOf(question_ids[0]));
            statement.setString(2, String.valueOf(question_ids[1]));
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
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.25),
                (int) (securityQuestionsPanel.getHeight() * 0.51),
                (int) (securityQuestionsPanel.getWidth() * 0.5),
                30);
        securityQuestionOne.setBackground(Color.WHITE);

        securityQuestionTwo = new JLabel(question_texts[1]);
        securityQuestionTwo.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.25),
                (int) (securityQuestionsPanel.getHeight() * 0.68),
                (int) (securityQuestionsPanel.getWidth() * 0.5),
                30);
        securityQuestionTwo.setBackground(Color.WHITE);
        securityQuestionsPanel.add(securityQuestionOne);
        securityQuestionsPanel.add(securityQuestionTwo);

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

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public RoundedPanel getSecurityQuestionsPanel() { return securityQuestionsPanel; }

    public JButton getNextButton(){ return nextButton; }
    public JButton getBackButton(){ return backButton; }

    public JLabel getSecurityQuestionOneDropDown() { return securityQuestionOne; }
    public JLabel getSecurityQuestionTwoDropDown() { return securityQuestionTwo; }

    public int getQuestionIndexOne(){ return question_ids[0]; }
    public int getQuestionIndexTwo(){ return question_ids[1]; }
    public int getTeacher_id(){ return teacher_id; }

    public JTextField getSecurityOneAnsText(){ return securityOneAnsText; }
    public JTextField getSecurityTwoAnsText(){ return securityTwoAnsText; }
}
