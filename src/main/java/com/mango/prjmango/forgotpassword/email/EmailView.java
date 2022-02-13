package com.mango.prjmango.forgotpassword.email;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.Components;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lombok.Getter;

/**
 * This class creates the Email page for the Forgot Password section.
 */
public class EmailView extends RoundedPanel {

    @Getter private JButton nextButton;
    @Getter private JButton cancelButton;

    @Getter private JTextField emailText;

    /**
     * The constructor which sets up the GUI for the Email page.
     */
    public EmailView() {
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

        JLabel createAccountHeader = Components.JLabel("Reset Password", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (getHeight() * 0.38), getWidth(), 30);

        JLabel enterEmailHeader = Components.JLabel("Enter Email", FontType.FONT_12_BOLD);
        enterEmailHeader.setBounds(0, (int) (getHeight() * 0.48), getWidth(), 15);

        emailText = Components.JTextField("Email");
        emailText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.51),
                (int) (getWidth() * 0.5),
                30);

        nextButton = Components.JButton("Next");
        nextButton.setBounds(
                (int) (getWidth() * 0.65) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.20),
                30);

        cancelButton = Components.JButton("Cancel");
        cancelButton.setBounds(
                (int) (getWidth() * 0.35) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.20),
                30);

        add(createAccountHeader);
        add(enterEmailHeader);
        add(emailText);
        add(nextButton);
        add(cancelButton);
    }
}
