package com.mango.app.forgotpassword;

import com.mango.app.Main;
import com.mango.app.components.BackgroundPanel;
import com.mango.app.components.FontType;
import com.mango.app.components.RoundedPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecurityQuestionsOneView {
    private static final Logger logger = Logger.getLogger(com.mango.app.createaccount.SecurityQuestionOneView.class.getName());

    private JFrame changePasswordWindow;

    private BackgroundPanel backgroundChangePasswordPanel;
    private RoundedPanel changePasswordPanel;

    private JLabel schoolLogo;
    private JLabel mangoLogo;
    private JLabel titleHeader;
    private JLabel forgotPasswordHeader;
    private JLabel securityOneHeader;
    private JLabel securityOneAnsHeader;

    private JButton nextButton;
    private JButton backButton;
    private JButton changePasswordButton;

    private JTextField securityOneText;
    private JTextField securityOneAnsText;


    private JSeparator separatorHeader;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.getScreenWidth(), Main.getScreenHeight());

    /**
     * The constructor which sets up the GUI for the create account page.
     */

    public SecurityQuestionsOneView(){

        createFrame();
        createPanels();
        createComponents();

        changePasswordWindow.setResizable(false);
        changePasswordWindow.getContentPane().add(backgroundChangePasswordPanel);
        changePasswordWindow.pack();
        changePasswordWindow.setLocationRelativeTo(null);
        changePasswordWindow.setVisible(true);
    }

    private void createFrame() {
        changePasswordWindow = new JFrame();
        changePasswordWindow.setPreferredSize(WINDOW_DIMENSIONS);
        changePasswordWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        changePasswordWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createPanels() {
        try {
            backgroundChangePasswordPanel = new BackgroundPanel();
            backgroundChangePasswordPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/Ariel-City-of-Lawrenceburg1.png")));
            backgroundChangePasswordPanel.setLayout(null);
            backgroundChangePasswordPanel.setBounds(0, 0, 100, 100);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }

        changePasswordPanel = new RoundedPanel();
        changePasswordPanel.setLayout(null);
        changePasswordPanel.setBounds(
                (int) (Main.getScreenWidth() * 0.5) - ((int) (Main.getScreenWidth() * 0.16)),
                (int) (Main.getScreenHeight() * 0.125),
                (int) (Main.getScreenWidth() * 0.3),
                (int) (Main.getScreenHeight() * 0.70));

        backgroundChangePasswordPanel.add(changePasswordPanel);
    }

    private void createComponents() {
        schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - 50,
                (int) (changePasswordPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/Mango3.png",
                50,
                50)));
        mangoLogo.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - 25,
                (changePasswordPanel.getHeight() - 75),
                50,
                50);

        titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.28) , changePasswordPanel.getWidth(),45);

        forgotPasswordHeader = createLabel("Forgot Password", FontType.FONT_20_BOLD);
        forgotPasswordHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.38), changePasswordPanel.getWidth(),30);

        separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - (int) (changePasswordPanel.getWidth() * 0.20),
                (int) (changePasswordPanel.getHeight() * 0.45),
                (int) (changePasswordPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        securityOneHeader = createLabel("Security Question #1", FontType.FONT_12_BOLD);
        securityOneHeader.setBounds(0,( int) (changePasswordPanel.getHeight() * 0.48), changePasswordPanel.getWidth(),15);

        securityOneText = new JTextField("Security Question #1");
        securityOneText.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - (int) (changePasswordPanel.getWidth() * 0.25),
                (int) (changePasswordPanel.getHeight() * 0.54),
                (int) (changePasswordPanel.getWidth() * 0.5),
                30);
        securityOneText.setBackground(Color.WHITE);

        securityOneAnsHeader = createLabel("Enter Answer", FontType.FONT_12_BOLD);
        securityOneAnsHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.62), changePasswordPanel.getWidth(),15);

        securityOneAnsText = new JTextField("Answer #1");
        securityOneAnsText.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - (int) (changePasswordPanel.getWidth() * 0.25),
                (int) (changePasswordPanel.getHeight() * 0.68),
                (int) (changePasswordPanel.getWidth() * 0.5),
                30);
        securityOneAnsText.setBackground(Color.WHITE);

        nextButton = new JButton("Next");
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(245,102,0));
        nextButton.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.65) - (int) (changePasswordPanel.getWidth() * 0.10),
                (int) (changePasswordPanel.getHeight() * 0.77),
                (int) (changePasswordPanel.getWidth() * 0.20),
                30);
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(false);
        nextButton.setFocusPainted(false);

        backButton = createButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(245,102,0));
        backButton.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.35) - (int) (changePasswordPanel.getWidth() * 0.10),
                (int) (changePasswordPanel.getHeight() * 0.77),
                (int) (changePasswordPanel.getWidth() * 0.20),
                30);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        changePasswordButton = createButton("Change Password");
        changePasswordButton.setForeground(Color.WHITE);
        changePasswordButton.setBackground(new Color(245,102,0));
        changePasswordButton.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.40) - (int) (changePasswordPanel.getWidth() * 0.10),
                (int) (changePasswordPanel.getHeight() * 0.83),
                (int) (changePasswordPanel.getWidth() * 0.40),
                30);
        changePasswordButton.setOpaque(true);
        changePasswordButton.setBorderPainted(false);
        changePasswordButton.setFocusPainted(false);
        changePasswordButton.setEnabled(false);

        changePasswordPanel.add(schoolLogo);
        changePasswordPanel.add(mangoLogo);
        changePasswordPanel.add(titleHeader);
        changePasswordPanel.add(forgotPasswordHeader);
        changePasswordPanel.add(separatorHeader);
        changePasswordPanel.add(securityOneHeader);
        changePasswordPanel.add(securityOneText);
        changePasswordPanel.add(securityOneAnsHeader);
        changePasswordPanel.add(securityOneAnsText);
        changePasswordPanel.add(nextButton);
        changePasswordPanel.add(backButton);
        changePasswordPanel.add(changePasswordButton);
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
    public JButton getNextButton(){ return nextButton; };
    public JButton getChangePasswordButton(){ return changePasswordButton; };
    public JButton getBackButton(){ return backButton; };
    public JTextField getSecurityOneText(){ return securityOneText; }
    public JTextField getSecurityOneAnsText(){ return securityOneAnsText; }

}

