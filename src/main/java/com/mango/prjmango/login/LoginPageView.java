package com.mango.prjmango.login;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.utilities.ImagePaths;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * Creates the main log in panel for the user.
 */
public class LoginPageView extends RoundedPanel {

    private @Getter JButton loginButton;
    private @Getter JButton createAccountButton;
    private @Getter JButton forgotPasswordButton;

    private @Getter JTextField emailText;
    private @Getter JPasswordField passwordText;

    public LoginPageView() {
        this.setLayout(null);
        this.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
    }

    private void createComponents() {
        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                ImagePaths.SCHOOL_LOGO,
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (this.getWidth() * 0.5) - 50,
                (int) (this.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                ImagePaths.MANGO_LOGO,
                50,
                50)));
        mangoLogo.setBounds(
                (int) (this.getWidth() * 0.5) - 25,
                (this.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (this.getHeight() * 0.28) , this.getWidth(),45);

        JLabel signInHeader = createLabel("Sign in", FontType.FONT_20_BOLD);
        signInHeader.setBounds(0, (int) (this.getHeight() * 0.38), this.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.20),
                (int) (this.getHeight() * 0.45),
                (int) (this.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel enterEmailHeader = createLabel("Enter Email", FontType.FONT_12_BOLD);
        enterEmailHeader.setBounds(0,( int) (this.getHeight() * 0.48), this.getWidth(),15);

        emailText = new JTextField("Email");
        emailText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.54),
                (int) (this.getWidth() * 0.5),
                30);
        emailText.setBackground(Color.WHITE);
        emailText.setName("emailText");

        JLabel enterPasswordHeader = createLabel("Enter Password", FontType.FONT_12_BOLD);
        enterPasswordHeader.setBounds(0, (int) (this.getHeight() * 0.62), this.getWidth(),15);

        passwordText = new JPasswordField("");
        passwordText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.68),
                (int) (this.getWidth() * 0.5),
                30);
        passwordText.setBackground(Color.WHITE);
        passwordText.setEchoChar((char) 0);
        passwordText.setName("passwordText");

        loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(245,102,0));
        loginButton.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.78),
                (int) (this.getWidth() * 0.20),
                30);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);

        createAccountButton = createButton("Create Account");
        createAccountButton.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.4),
                (int) (this.getHeight() * 0.88),
                (int) (this.getWidth() * 0.35),
                15);

        forgotPasswordButton = createButton("Forgot Password");
        forgotPasswordButton.setBounds(
                (int) (this.getWidth() * 0.5) + (int) (this.getWidth() * 0.05),
                (int) (this.getHeight() * 0.88),
                (int) (this.getWidth() * 0.35),
                15);

        this.add(schoolLogo);
        this.add(mangoLogo);
        this.add(titleHeader);
        this.add(signInHeader);
        this.add(separatorHeader);
        this.add(enterEmailHeader);
        this.add(enterPasswordHeader);
        this.add(emailText);
        this.add(passwordText);
        this.add(loginButton);
        this.add(createAccountButton);
        this.add(forgotPasswordButton);
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
}
