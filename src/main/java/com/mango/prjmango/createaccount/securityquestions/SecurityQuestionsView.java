package com.mango.prjmango.createaccount.securityquestions;


import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SecurityQuestionsView {

    private static final Logger logger = Logger.getLogger(SecurityQuestionsView.class.getName());

    private final RoundedPanel securityQuestionsPanel;

    private JButton nextButton;
    private JButton backButton;

    private JTextField securityOneAnsText;
    private JTextField securityTwoAnsText;

    private JComboBox<String> securityQuestionOne;
    private JComboBox<String> securityQuestionTwo;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public SecurityQuestionsView() {
        securityQuestionsPanel = new RoundedPanel();
        securityQuestionsPanel.setLayout(null);
        securityQuestionsPanel.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
        createDropDownQuestions();
    }

    private void createComponents() {
        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/main/java/com/mango/prjmango/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - 50,
                (int) (securityQuestionsPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/main/java/com/mango/prjmango/utilities/images/Mango3.png",
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

        securityOneAnsText = new JTextField();
        securityOneAnsText.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - ((int) (securityQuestionsPanel.getWidth() * 0.65) / 2),
                (int) (securityQuestionsPanel.getHeight() * 0.59),
                (int) (securityQuestionsPanel.getWidth() * 0.65),
                30);
        securityOneAnsText.setBackground(Color.WHITE);

        JLabel securityTwoHeader = createLabel("Security Question #2", FontType.FONT_12_BOLD);
        securityTwoHeader.setBounds(0,( int) (securityQuestionsPanel.getHeight() * 0.65), securityQuestionsPanel.getWidth(),15);

        JLabel securityTwoAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityTwoAnsHeader.setBounds(0, (int) (securityQuestionsPanel.getHeight() * 0.74), securityQuestionsPanel.getWidth(),15);

        securityTwoAnsText = new JTextField();
        securityTwoAnsText.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - ((int) (securityQuestionsPanel.getWidth() * 0.65) / 2),
                (int) (securityQuestionsPanel.getHeight() * 0.77),
                (int) (securityQuestionsPanel.getWidth() * 0.65),
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
                (int) (securityQuestionsPanel.getWidth() * 0.5) - ((int) (securityQuestionsPanel.getWidth() * 0.65) / 2),
                (int) (securityQuestionsPanel.getHeight() * 0.51),
                (int) (securityQuestionsPanel.getWidth() * 0.65),
                30);
        securityQuestionOne.setBackground(Color.WHITE);

        securityQuestionTwo = new JComboBox<>(securityQuestionList);
        securityQuestionTwo.setSelectedIndex(0);
        securityQuestionTwo.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - ((int) (securityQuestionsPanel.getWidth() * 0.65) / 2),
                (int) (securityQuestionsPanel.getHeight() * 0.68),
                (int) (securityQuestionsPanel.getWidth() * 0.65),
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

    public JComboBox<String> getSecurityQuestionOneDropDown() { return securityQuestionOne; }
    public JComboBox<String> getSecurityQuestionTwoDropDown() { return securityQuestionTwo; }

    public JTextField getSecurityOneAnsText(){ return securityOneAnsText; }
    public JTextField getSecurityTwoAnsText(){ return securityTwoAnsText; }
}
