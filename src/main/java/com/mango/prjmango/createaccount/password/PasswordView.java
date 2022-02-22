package com.mango.prjmango.createaccount.password;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.Components;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import lombok.Getter;

/**
 * This class creates the Create Password page for the Create Account section.
 */
public class PasswordView extends RoundedPanel {

    @Getter private JButton backButton;
    @Getter private JButton createAccountButton;

    @Getter private JPasswordField passwordText;
    @Getter private JPasswordField confirmPasswordText;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public PasswordView() {
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

        JLabel createAccountHeader = Components.JLabel("Create Account", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (getHeight() * 0.38), getWidth(),30);

        JLabel passwordHeader = Components.JLabel("Create Password", FontType.FONT_12_BOLD);
        passwordHeader.setBounds(0,( int) (getHeight() * 0.48), getWidth(),15);

        JLabel confirmPasswordHeader = Components.JLabel("Confirm Password", FontType.FONT_12_BOLD);
        confirmPasswordHeader.setBounds(0, (int) (getHeight() * 0.62), getWidth(),15);

        passwordText = Components.JPasswordField("", false);
        passwordText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.54),
                (int) (getWidth() * 0.5),
                30);

        confirmPasswordText = Components.JPasswordField("", false);
        confirmPasswordText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.68),
                (int) (getWidth() * 0.5),
                30);

        backButton = Components.JButton("Back");
        backButton.setBounds(
                (int) (getWidth() * 0.35) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.20),
                30);

        createAccountButton = Components.JButton("Create Account");
        createAccountButton.setBounds(
                (int) (getWidth() * 0.40) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.83),
                (int) (getWidth() * 0.40),
                30);

        add(createAccountHeader);
        add(passwordHeader);
        add(confirmPasswordHeader);
        add(passwordText);
        add(confirmPasswordText);
        add(backButton);
        add(createAccountButton);
    }
}
