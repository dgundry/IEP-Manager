package com.mango.prjmango.login;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.Components;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import lombok.Getter;

/**
 * Creates the main log in panel for the user.
 */
public class LoginPageView extends RoundedPanel {

    @Getter private JButton loginButton;
    @Getter private JButton createAccountButton;
    @Getter private JButton forgotPasswordButton;

    @Getter private JTextField emailText;
    @Getter private JPasswordField passwordText;

    private final Color TEXT_LIGHT_BLUE = new Color(3, 179, 235);
    private final Color BUTTON_ORANGE = new Color(245, 102, 0);

    /**
     * Constructor. Sets the layout of the GUI and calls method(s) to create
     * {@link JComponent}'s.
     */
    public LoginPageView() {
        setLayout(null);
        setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
    }

    private void createComponents() {
        LoginPageComponents.setCommonComponents(this);

        JLabel signInHeader = Components.JLabel("Sign in", FontType.FONT_20_BOLD);
        signInHeader.setBounds(0, (int) (getHeight() * 0.38), getWidth(),30);

        JLabel enterEmailHeader = Components.JLabel("Enter Email", FontType.FONT_12_BOLD);
        enterEmailHeader.setBounds(0,(int) (getHeight() * 0.48), getWidth(),15);

        JLabel enterPasswordHeader = Components.JLabel("Enter Password", FontType.FONT_12_BOLD);
        enterPasswordHeader.setBounds(0, (int) (getHeight() * 0.62), getWidth(),15);

        emailText = Components.JTextField("Email");
        emailText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.54),
                (int) (getWidth() * 0.5),
                30);
        emailText.setName("emailText");

        passwordText = Components.JPasswordField("Password", true);
        passwordText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.68),
                (int) (getWidth() * 0.5),
                30);
        passwordText.setName("passwordText");

        loginButton = Components.JButton("Login", Color.WHITE, BUTTON_ORANGE);
        loginButton.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.78),
                (int) (getWidth() * 0.20),
                30);

        createAccountButton = Components.JButton("Create Account", TEXT_LIGHT_BLUE);
        createAccountButton.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.4),
                (int) (getHeight() * 0.88),
                (int) (getWidth() * 0.35),
                15);

        forgotPasswordButton = Components.JButton("Forgot Password", TEXT_LIGHT_BLUE);
        forgotPasswordButton.setBounds(
                (int) (getWidth() * 0.5) + (int) (getWidth() * 0.05),
                (int) (getHeight() * 0.88),
                (int) (getWidth() * 0.35),
                15);

        add(signInHeader);
        add(enterEmailHeader);
        add(enterPasswordHeader);
        add(emailText);
        add(passwordText);
        add(loginButton);
        add(createAccountButton);
        add(forgotPasswordButton);
    }
}
