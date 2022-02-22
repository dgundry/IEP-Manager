package com.mango.prjmango.forgotpassword.password;

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
 * This class creates the Change Password page for the Forgot Password section.
 */
public class ChangePasswordView extends RoundedPanel {

    @Getter private final int teacherID;

    @Getter private JButton cancelButton;
    @Getter private JButton changePasswordButton;

    @Getter private JPasswordField passwordText;
    @Getter private JPasswordField confirmPasswordText;

    /**
     * The constructor which sets up the GUI for the change password page.
     */
    public ChangePasswordView(int teacherID) {
        this.teacherID = teacherID;

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

        JLabel createAccountHeader = Components.JLabel("Change Password", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (getHeight() * 0.38), getWidth(),30);

        JLabel passwordHeader = Components.JLabel("New Password", FontType.FONT_12_BOLD);
        passwordHeader.setBounds(0, (int) (getHeight() * 0.48), getWidth(), 15);

        JLabel confirmPasswordHeader = Components.JLabel("Confirm New Password", FontType.FONT_12_BOLD);
        confirmPasswordHeader.setBounds(0, (int) (getHeight() * 0.62), getWidth(), 15);

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

        cancelButton = Components.JButton("Cancel");
        cancelButton.setBounds(
                (int) (getWidth() * 0.5) - ((int) (getWidth() * 0.2) / 2),
                (int) (getHeight() * 0.83),
                (int) (getWidth() * 0.20),
                30);

        changePasswordButton = Components.JButton("Change Password");
        changePasswordButton.setBounds(
                (int) (getWidth() * 0.40) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.40),
                30);

        add(createAccountHeader);
        add(passwordHeader);
        add(confirmPasswordHeader);
        add(passwordText);
        add(confirmPasswordText);
        add(cancelButton);
        add(changePasswordButton);
    }
}
