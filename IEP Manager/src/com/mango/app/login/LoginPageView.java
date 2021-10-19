package com.mango.app.login;

import com.mango.app.*;
import com.mango.app.components.*;
import com.mango.app.utilities.*;
import java.awt.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * Creates the Login page view for the user.
 */
public class LoginPageView {

    private static final Logger logger = Logger.getLogger(LoginPageView.class.getName());

    private JFrame loginWindow;

    private BackgroundPanel backgroundLoginPanel;
    private RoundedPanel loginPanel;

    private JLabel schoolLogo;
    private JLabel mangoLogo;
    private JLabel titleHeader;
    private JLabel signinHeader;
    private JLabel enterEmailHeader;
    private JLabel enterPasswordHeader;

    private JButton loginButton;
    private JButton createAccountButton;
    private JButton forgotPasswordButton;

    private JTextField emailText;
    private JTextField passwordText;

    private JSeparator separatorHeader;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.getScreenWidth(), Main.getScreenHeight());

    /**
     * The constructor which sets up the GUI for the login page.
     */
    public LoginPageView(OSUtils.OS osType) {
        createFrame();
        createPanels();
        createComponents();

        loginWindow.getContentPane().add(backgroundLoginPanel);
        loginWindow.pack();
        loginWindow.setLocationRelativeTo(null);
        loginWindow.setVisible(true);
    }

    private void createFrame() {
        loginWindow = new JFrame();
        loginWindow.setPreferredSize(WINDOW_DIMENSIONS);
        loginWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        loginWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createPanels() {
        try {
            backgroundLoginPanel = new BackgroundPanel();
            backgroundLoginPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/Ariel-City-of-Lawrenceburg1.png")));
            backgroundLoginPanel.setLayout(null);
            backgroundLoginPanel.setBounds(0, 0, 100, 100);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }

        loginPanel = new RoundedPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(
                (int) (Main.getScreenWidth() * 0.5) - ((int) (Main.getScreenWidth() * 0.16)),
                (int) (Main.getScreenHeight() * 0.125),
                (int) (Main.getScreenWidth() * 0.3),
                (int) (Main.getScreenHeight() * 0.70));

        backgroundLoginPanel.add(loginPanel);
    }

    private void createComponents() {
        schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/PawLogo.png",
                      (229 / 2),
                      110)));
        schoolLogo.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - 50,
                (int) (loginPanel.getHeight() * 0.05),
                (229 / 2),
                110);

       mangoLogo = new JLabel(new ImageIcon(getScaledImage(
               "src/com/mango/app/utilities/images/Mango3.png",
               50,
               50)));
        mangoLogo.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - 25,
                (loginPanel.getHeight() - 75),
                50,
                50);

        titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (loginPanel.getHeight() * 0.28) , loginPanel.getWidth(),45);

        signinHeader = createLabel("Sign in", FontType.FONT_20_BOLD);
        signinHeader.setBounds(0, (int) (loginPanel.getHeight() * 0.38), loginPanel.getWidth(),30);

        separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - (int) (loginPanel.getWidth() * 0.20),
                (int) (loginPanel.getHeight() * 0.45),
                (int) (loginPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        enterEmailHeader = createLabel("Enter Email", FontType.FONT_12_BOLD);
        enterEmailHeader.setBounds(0,( int) (loginPanel.getHeight() * 0.48), loginPanel.getWidth(),15);

        emailText = new JTextField("Email");
        emailText.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - (int) (loginPanel.getWidth() * 0.25),
                (int) (loginPanel.getHeight() * 0.54),
                (int) (loginPanel.getWidth() * 0.5),
                30);
        emailText.setBackground(Color.WHITE);

        enterPasswordHeader = createLabel("Enter Password", FontType.FONT_12_BOLD);
        enterPasswordHeader.setBounds(0, (int) (loginPanel.getHeight() * 0.62), loginPanel.getWidth(),15);

        passwordText = new JTextField("Password");
        passwordText.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - (int) (loginPanel.getWidth() * 0.25),
                (int) (loginPanel.getHeight() * 0.68),
                (int) (loginPanel.getWidth() * 0.5),
                30);
        passwordText.setBackground(Color.WHITE);

        loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(245,102,0));
        loginButton.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - (int) (loginPanel.getWidth() * 0.10),
                (int) (loginPanel.getHeight() * 0.78),
                (int) (loginPanel.getWidth() * 0.20),
                30);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);

        createAccountButton = createButton("Create Account");
        createAccountButton.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - (int) (loginPanel.getWidth() * 0.4),
                (int) (loginPanel.getHeight() * 0.88),
                (int) (loginPanel.getWidth() * 0.35),
                15);

        forgotPasswordButton = createButton("Forgot Password");
        forgotPasswordButton.setBounds(
                (int) (loginPanel.getWidth() * 0.5) + (int) (loginPanel.getWidth() * 0.05),
                (int) (loginPanel.getHeight() * 0.88),
                (int) (loginPanel.getWidth() * 0.35),
                15);

        loginPanel.add(schoolLogo);
        loginPanel.add(mangoLogo);
        loginPanel.add(titleHeader);
        loginPanel.add(signinHeader);
        loginPanel.add(separatorHeader);
        loginPanel.add(enterEmailHeader);
        loginPanel.add(emailText);
        loginPanel.add(enterPasswordHeader);
        loginPanel.add(passwordText);
        loginPanel.add(loginButton);
        loginPanel.add(createAccountButton);
        loginPanel.add(forgotPasswordButton);
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

    public JButton getLoginButton() { return loginButton; }

    public JButton getForgotPasswordButton() { return forgotPasswordButton; }

    public JButton getCreateAccountButton() { return createAccountButton; }

    public JTextField getEmailText() { return emailText; }

    public JTextField getPasswordText() { return passwordText; }
}
