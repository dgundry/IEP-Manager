package com.mango.prjmango.forgotpassword.password;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import lombok.Getter;

public class ChangePasswordView extends RoundedPanel {

    private final @Getter int teacherID;

    private @Getter JButton cancelButton;
    private @Getter JButton changePasswordButton;

    private @Getter JPasswordField passwordText;
    private @Getter JPasswordField confirmPasswordText;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public ChangePasswordView(int teacherID) {
        this.teacherID = teacherID;

        this.setLayout(null);
        this.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
    }

    private void createComponents() {
        LoginPageComponents.setCommonComponents(this);

        JLabel createAccountHeader = createLabel("Change Password", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (this.getHeight() * 0.38), this.getWidth(),30);

        JLabel passwordHeader = createLabel("New Password", FontType.FONT_12_BOLD);
        passwordHeader.setBounds(0,( int) (this.getHeight() * 0.48), this.getWidth(),15);

        passwordText = new JPasswordField("");
        passwordText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.54),
                (int) (this.getWidth() * 0.5),
                30);
        passwordText.setBackground(Color.WHITE);

        JLabel confirmPasswordHeader = createLabel("Confirm New Password", FontType.FONT_12_BOLD);
        confirmPasswordHeader.setBounds(0, (int) (this.getHeight() * 0.62), this.getWidth(),15);

        confirmPasswordText = new JPasswordField("");
        confirmPasswordText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.68),
                (int) (this.getWidth() * 0.5),
                30);
        confirmPasswordText.setBackground(Color.WHITE);

        cancelButton = createButton("Cancel");
        cancelButton.setBounds(
                (int) (this.getWidth() * 0.5) - ((int) (this.getWidth() * 0.2)/2),
                (int) (this.getHeight() * 0.83),
                (int) (this.getWidth() * 0.20),
                30);

        changePasswordButton = createButton("Change Password");
        changePasswordButton.setBounds(
                (int) (this.getWidth() * 0.40) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.77),
                (int) (this.getWidth() * 0.40),
                30);

        this.add(createAccountHeader);
        this.add(passwordHeader);
        this.add(confirmPasswordHeader);
        this.add(passwordText);
        this.add(confirmPasswordText);
        this.add(cancelButton);
        this.add(changePasswordButton);
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
