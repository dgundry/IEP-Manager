package com.mango.app.forgotpassword;

import com.mango.app.Main;
import com.mango.app.components.FontType;
import com.mango.app.components.RoundedPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class SecurityQuestionsPageOneView {

    private final RoundedPanel securityQuestionsPanel;

    private JButton nextButton;
    private JButton backButton;
    private JButton changePasswordButton;

    private JTextField securityOneText;
    private JTextField securityOneAnsText;

    /**
     * The constructor which sets up the GUI for the create account page.
     */

    public SecurityQuestionsPageOneView(){
        securityQuestionsPanel = new RoundedPanel();
        securityQuestionsPanel.setLayout(null);
        securityQuestionsPanel.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
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

        JLabel forgotPasswordHeader = createLabel("Forgot Password", FontType.FONT_20_BOLD);
        forgotPasswordHeader.setBounds(0, (int) (securityQuestionsPanel.getHeight() * 0.38), securityQuestionsPanel.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.20),
                (int) (securityQuestionsPanel.getHeight() * 0.45),
                (int) (securityQuestionsPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel securityOneHeader = createLabel("Security Question #1", FontType.FONT_12_BOLD);
        securityOneHeader.setBounds(0,( int) (securityQuestionsPanel.getHeight() * 0.48), securityQuestionsPanel.getWidth(),15);

        securityOneText = new JTextField("Security Question #1");
        securityOneText.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.25),
                (int) (securityQuestionsPanel.getHeight() * 0.54),
                (int) (securityQuestionsPanel.getWidth() * 0.5),
                30);
        securityOneText.setBackground(Color.WHITE);

        JLabel securityOneAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityOneAnsHeader.setBounds(0, (int) (securityQuestionsPanel.getHeight() * 0.62), securityQuestionsPanel.getWidth(),15);

        securityOneAnsText = new JTextField("Answer #1");
        securityOneAnsText.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.5) - (int) (securityQuestionsPanel.getWidth() * 0.25),
                (int) (securityQuestionsPanel.getHeight() * 0.68),
                (int) (securityQuestionsPanel.getWidth() * 0.5),
                30);
        securityOneAnsText.setBackground(Color.WHITE);

        nextButton = new JButton("Next");
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(245,102,0));
        nextButton.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.65) - (int) (securityQuestionsPanel.getWidth() * 0.10),
                (int) (securityQuestionsPanel.getHeight() * 0.77),
                (int) (securityQuestionsPanel.getWidth() * 0.20),
                30);
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(false);
        nextButton.setFocusPainted(false);

        backButton = createButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(245,102,0));
        backButton.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.35) - (int) (securityQuestionsPanel.getWidth() * 0.10),
                (int) (securityQuestionsPanel.getHeight() * 0.77),
                (int) (securityQuestionsPanel.getWidth() * 0.20),
                30);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        changePasswordButton = createButton("Change Password");
        changePasswordButton.setForeground(Color.WHITE);
        changePasswordButton.setBackground(new Color(245,102,0));
        changePasswordButton.setBounds(
                (int) (securityQuestionsPanel.getWidth() * 0.40) - (int) (securityQuestionsPanel.getWidth() * 0.10),
                (int) (securityQuestionsPanel.getHeight() * 0.83),
                (int) (securityQuestionsPanel.getWidth() * 0.40),
                30);
        changePasswordButton.setOpaque(true);
        changePasswordButton.setBorderPainted(false);
        changePasswordButton.setFocusPainted(false);
        changePasswordButton.setEnabled(false);

        securityQuestionsPanel.add(schoolLogo);
        securityQuestionsPanel.add(mangoLogo);
        securityQuestionsPanel.add(titleHeader);
        securityQuestionsPanel.add(forgotPasswordHeader);
        securityQuestionsPanel.add(separatorHeader);
        securityQuestionsPanel.add(securityOneHeader);
        securityQuestionsPanel.add(securityOneAnsHeader);
        securityQuestionsPanel.add(securityOneText);
        securityQuestionsPanel.add(securityOneAnsText);
        securityQuestionsPanel.add(nextButton);
        securityQuestionsPanel.add(backButton);
        securityQuestionsPanel.add(changePasswordButton);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(new Color(3,179,235));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public RoundedPanel getSecurityQuestionsPanel() { return securityQuestionsPanel; }

    public JButton getNextButton(){ return nextButton; }

    public JButton getChangePasswordButton(){ return changePasswordButton; }

    public JButton getBackButton(){ return backButton; }

    public JTextField getSecurityOneText(){ return securityOneText; }

    public JTextField getSecurityOneAnsText(){ return securityOneAnsText; }

}

