package com.mango.prjmango.createaccount.securityquestions;


import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import lombok.Getter;

public class SecurityQuestionsView extends RoundedPanel {

    private static final Logger logger = Logger.getLogger(SecurityQuestionsView.class.getName());

    private @Getter JButton nextButton;
    private @Getter JButton backButton;

    private @Getter JTextField securityOneAnsText;
    private @Getter JTextField securityTwoAnsText;

    private @Getter JComboBox<String> securityQuestionOne;
    private @Getter JComboBox<String> securityQuestionTwo;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public SecurityQuestionsView() {
        this.setLayout(null);
        this.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
        createDropDownQuestions();
    }

    private void createComponents() {
        LoginPageComponents.setCommonComponents(this);

        JLabel securityQuestionsHeader = createLabel("Security Questions", FontType.FONT_20_BOLD);
        securityQuestionsHeader.setBounds(0, (int) (this.getHeight() * 0.38), this.getWidth(),30);

        JLabel securityOneHeader = createLabel("Security Question #1", FontType.FONT_12_BOLD);
        securityOneHeader.setBounds(0,( int) (this.getHeight() * 0.48), this.getWidth(),15);

        JLabel securityOneAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityOneAnsHeader.setBounds(0, (int) (this.getHeight() * 0.56), this.getWidth(),15);

        securityOneAnsText = new JTextField();
        securityOneAnsText.setBounds(
                (int) (this.getWidth() * 0.5) - ((int) (this.getWidth() * 0.65) / 2),
                (int) (this.getHeight() * 0.59),
                (int) (this.getWidth() * 0.65),
                30);
        securityOneAnsText.setBackground(Color.WHITE);

        JLabel securityTwoHeader = createLabel("Security Question #2", FontType.FONT_12_BOLD);
        securityTwoHeader.setBounds(0,( int) (this.getHeight() * 0.65), this.getWidth(),15);

        JLabel securityTwoAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityTwoAnsHeader.setBounds(0, (int) (this.getHeight() * 0.74), this.getWidth(),15);

        securityTwoAnsText = new JTextField();
        securityTwoAnsText.setBounds(
                (int) (this.getWidth() * 0.5) - ((int) (this.getWidth() * 0.65) / 2),
                (int) (this.getHeight() * 0.77),
                (int) (this.getWidth() * 0.65),
                30);
        securityTwoAnsText.setBackground(Color.WHITE);

        nextButton = createButton("Next");
        nextButton.setBounds(
                (int) (this.getWidth() * 0.65) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.83),
                (int) (this.getWidth() * 0.20),
                30);

        backButton = createButton("Back");
        backButton.setBounds(
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
        this.add(backButton);
    }

    private void createDropDownQuestions() {
        String sql = "SELECT question FROM question;";
        Vector<String> securityQuestionList = new Vector<>();

        try (PreparedStatement statement = Main.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            do {
                securityQuestionList.add(resultSet.getString(1));
            } while (resultSet.next());
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        securityQuestionList.remove(0);

        securityQuestionOne = new JComboBox<>(securityQuestionList);
        securityQuestionOne.setSelectedIndex(0);
        securityQuestionOne.setBounds(
                (int) (this.getWidth() * 0.5) - ((int) (this.getWidth() * 0.65) / 2),
                (int) (this.getHeight() * 0.51),
                (int) (this.getWidth() * 0.65),
                30);
        securityQuestionOne.setBackground(Color.WHITE);

        securityQuestionTwo = new JComboBox<>(securityQuestionList);
        securityQuestionTwo.setSelectedIndex(0);
        securityQuestionTwo.setBounds(
                (int) (this.getWidth() * 0.5) - ((int) (this.getWidth() * 0.65) / 2),
                (int) (this.getHeight() * 0.68),
                (int) (this.getWidth() * 0.65),
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
