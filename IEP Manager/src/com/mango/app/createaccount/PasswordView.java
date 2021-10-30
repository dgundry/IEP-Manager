package com.mango.app.createaccount;

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

public class PasswordView {
    private static final Logger logger = Logger.getLogger(PasswordView.class.getName());

    private JFrame createAccountWindow;

    private BackgroundPanel backgroundCreateAccountPanel;
    private RoundedPanel createAccountPanel;

    private JLabel schoolLogo;
    private JLabel mangoLogo;
    private JLabel titleHeader;
    private JLabel createAccountHeader;
    private JLabel passwordHeader;
    private JLabel confirmPasswordHeader;

    private JButton nextButton;
    private JButton backButton;
    private JButton createAccountButton;

    private JPasswordField passwordText;
    private JPasswordField confirmPasswordText;

    private JSeparator separatorHeader;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    /**
     * The constructor which sets up the GUI for the create account page.
     */

    public PasswordView(){

            createFrame();
            createPanels();
            createComponents();

            createAccountWindow.setResizable(false);
            createAccountWindow.getContentPane().add(backgroundCreateAccountPanel);
            createAccountWindow.pack();
            createAccountWindow.setLocationRelativeTo(null);
            createAccountWindow.setVisible(true);
        }

        private void createFrame() {
            createAccountWindow = new JFrame();
            createAccountWindow.setPreferredSize(WINDOW_DIMENSIONS);
            createAccountWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
            createAccountWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        private void createPanels() {
            try {
                backgroundCreateAccountPanel = new BackgroundPanel();
                backgroundCreateAccountPanel.setBackground(
                        ImageIO.read(new File("src/com/mango/app/utilities/images/Ariel-City-of-Lawrenceburg1.png")));
                backgroundCreateAccountPanel.setLayout(null);
                backgroundCreateAccountPanel.setBounds(0, 0, 100, 100);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Could not load background image.");
            }

            createAccountPanel = new RoundedPanel();
            createAccountPanel.setLayout(null);
            createAccountPanel.setBounds(
                    (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                    (int) (Main.SCREEN_HEIGHT * 0.125),
                    (int) (Main.SCREEN_WIDTH * 0.3),
                    (int) (Main.SCREEN_HEIGHT * 0.70));

            backgroundCreateAccountPanel.add(createAccountPanel);
        }

        private void createComponents() {
            schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                    "src/com/mango/app/utilities/PawLogo.png",
                    (229 / 2),
                    110)));
            schoolLogo.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.5) - 50,
                    (int) (createAccountPanel.getHeight() * 0.05),
                    (229 / 2),
                    110);

            mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                    "src/com/mango/app/utilities/Mango3.png",
                    50,
                    50)));
            mangoLogo.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.5) - 25,
                    (createAccountPanel.getHeight() - 75),
                    50,
                    50);

            titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
            titleHeader.setBounds(0, (int) (createAccountPanel.getHeight() * 0.28) , createAccountPanel.getWidth(),45);

            createAccountHeader = createLabel("Create Account", FontType.FONT_20_BOLD);
            createAccountHeader.setBounds(0, (int) (createAccountPanel.getHeight() * 0.38), createAccountPanel.getWidth(),30);

            separatorHeader = new JSeparator(SwingConstants.CENTER);
            separatorHeader.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.5) - (int) (createAccountPanel.getWidth() * 0.20),
                    (int) (createAccountPanel.getHeight() * 0.45),
                    (int) (createAccountPanel.getWidth() * 0.40),
                    1);
            separatorHeader.setBackground(Color.WHITE);

            passwordHeader = createLabel("Create Password", FontType.FONT_12_BOLD);
            passwordHeader.setBounds(0,( int) (createAccountPanel.getHeight() * 0.48), createAccountPanel.getWidth(),15);

            passwordText = new JPasswordField("");
            passwordText.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.5) - (int) (createAccountPanel.getWidth() * 0.25),
                    (int) (createAccountPanel.getHeight() * 0.54),
                    (int) (createAccountPanel.getWidth() * 0.5),
                    30);
            passwordText.setBackground(Color.WHITE);

            confirmPasswordHeader = createLabel("Confirm Password", FontType.FONT_12_BOLD);
            confirmPasswordHeader.setBounds(0, (int) (createAccountPanel.getHeight() * 0.62), createAccountPanel.getWidth(),15);

            confirmPasswordText = new JPasswordField("");
            confirmPasswordText.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.5) - (int) (createAccountPanel.getWidth() * 0.25),
                    (int) (createAccountPanel.getHeight() * 0.68),
                    (int) (createAccountPanel.getWidth() * 0.5),
                    30);
            confirmPasswordText.setBackground(Color.WHITE);

            nextButton = new JButton("Next");
            nextButton.setForeground(Color.WHITE);
            nextButton.setBackground(new Color(245,102,0));
            nextButton.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.65) - (int) (createAccountPanel.getWidth() * 0.10),
                    (int) (createAccountPanel.getHeight() * 0.77),
                    (int) (createAccountPanel.getWidth() * 0.20),
                    30);
            nextButton.setOpaque(true);
            nextButton.setBorderPainted(false);
            nextButton.setFocusPainted(false);

            backButton = createButton("Back");
            backButton.setForeground(Color.WHITE);
            backButton.setBackground(new Color(245,102,0));
            backButton.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.35) - (int) (createAccountPanel.getWidth() * 0.10),
                    (int) (createAccountPanel.getHeight() * 0.77),
                    (int) (createAccountPanel.getWidth() * 0.20),
                    30);
            backButton.setOpaque(true);
            backButton.setBorderPainted(false);
            backButton.setFocusPainted(false);

            createAccountButton = createButton("Create Account");
            createAccountButton.setForeground(Color.WHITE);
            createAccountButton.setBackground(new Color(245,102,0));
            createAccountButton.setBounds(
                    (int) (createAccountPanel.getWidth() * 0.40) - (int) (createAccountPanel.getWidth() * 0.10),
                    (int) (createAccountPanel.getHeight() * 0.83),
                    (int) (createAccountPanel.getWidth() * 0.40),
                    30);
            createAccountButton.setOpaque(true);
            createAccountButton.setBorderPainted(false);
            createAccountButton.setFocusPainted(false);
            createAccountButton.setEnabled(false);

            createAccountPanel.add(schoolLogo);
            createAccountPanel.add(mangoLogo);
            createAccountPanel.add(titleHeader);
            createAccountPanel.add(createAccountHeader);
            createAccountPanel.add(separatorHeader);
            createAccountPanel.add(passwordHeader);
            createAccountPanel.add(passwordText);
            createAccountPanel.add(confirmPasswordHeader);
            createAccountPanel.add(confirmPasswordText);
            createAccountPanel.add(nextButton);
            createAccountPanel.add(backButton);
            createAccountPanel.add(createAccountButton);
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
        public JButton getCreateAccountButton(){ return createAccountButton; };
        public JButton getBackButton(){ return backButton; };
        public JTextField getPasswordText(){ return passwordText; }
        public JTextField getConfirmPasswordText(){ return confirmPasswordText; }

}

