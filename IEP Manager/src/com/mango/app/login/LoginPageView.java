package com.mango.app.login;

import com.mango.app.Main;
import com.mango.app.components.FontType;
import com.mango.app.components.RoundedPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Creates the main log in panel for the user.
 */
public class LoginPageView {

    private final RoundedPanel loginPanel;

    private JButton loginButton;
    private JButton createAccountButton;
    private JButton forgotPasswordButton;

    private JTextField emailText;
    private JTextField passwordText;

    public LoginPageView() {
        loginPanel = new RoundedPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(
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
                (int) (loginPanel.getWidth() * 0.5) - 50,
                (int) (loginPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
               "src/com/mango/app/utilities/images/Mango3.png",
               50,
               50)));
        mangoLogo.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - 25,
                (loginPanel.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (loginPanel.getHeight() * 0.28) , loginPanel.getWidth(),45);

        JLabel signInHeader = createLabel("Sign in", FontType.FONT_20_BOLD);
        signInHeader.setBounds(0, (int) (loginPanel.getHeight() * 0.38), loginPanel.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - (int) (loginPanel.getWidth() * 0.20),
                (int) (loginPanel.getHeight() * 0.45),
                (int) (loginPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel enterEmailHeader = createLabel("Enter Email", FontType.FONT_12_BOLD);
        enterEmailHeader.setBounds(0,( int) (loginPanel.getHeight() * 0.48), loginPanel.getWidth(),15);

        emailText = new JTextField("Email");
        emailText.setBounds(
                (int) (loginPanel.getWidth() * 0.5) - (int) (loginPanel.getWidth() * 0.25),
                (int) (loginPanel.getHeight() * 0.54),
                (int) (loginPanel.getWidth() * 0.5),
                30);
        emailText.setBackground(Color.WHITE);

        JLabel enterPasswordHeader = createLabel("Enter Password", FontType.FONT_12_BOLD);
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
        loginPanel.add(signInHeader);
        loginPanel.add(separatorHeader);
        loginPanel.add(enterEmailHeader);
        loginPanel.add(enterPasswordHeader);
        loginPanel.add(emailText);
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
        button.setFocusPainted(false);
        return button;
    }

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public RoundedPanel getLoginPanel() { return loginPanel; }

    public JButton getLoginButton() { return loginButton; }

    public JButton getForgotPasswordButton() { return forgotPasswordButton; }

    public JButton getCreateAccountButton() { return createAccountButton; }

    public JTextField getEmailText() { return emailText; }

    public JTextField getPasswordText() { return passwordText; }
}
