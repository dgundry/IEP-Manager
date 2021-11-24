package com.mango.prjmango.forgotpassword.email;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import lombok.Getter;

public class EmailView extends RoundedPanel {

    private @Getter JButton nextButton;
    private @Getter JButton cancelButton;

    private @Getter JTextField emailText;

    public EmailView() {
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

        JLabel createAccountHeader = createLabel("Reset Password", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (this.getHeight() * 0.38), this.getWidth(),30);

        JLabel enterEmailHeader = createLabel("Enter Email", FontType.FONT_12_BOLD);
        enterEmailHeader.setBounds(0,( int) (this.getHeight() * 0.48), this.getWidth(),15);

        emailText = new JTextField("Email");
        emailText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.51),
                (int) (this.getWidth() * 0.5),
                30);
        emailText.setBackground(Color.WHITE);

        nextButton = createButton("Next");
        nextButton.setBounds(
                (int) (this.getWidth() * 0.65) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.77),
                (int) (this.getWidth() * 0.20),
                30);

        cancelButton = createButton("Cancel");
        cancelButton.setBounds(
                (int) (this.getWidth() * 0.35) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.77),
                (int) (this.getWidth() * 0.20),
                30);

        this.add(createAccountHeader);
        this.add(enterEmailHeader);
        this.add(emailText);
        this.add(nextButton);
        this.add(cancelButton);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(245,102,0));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setEnabled(true);
        return button;
    }
}
