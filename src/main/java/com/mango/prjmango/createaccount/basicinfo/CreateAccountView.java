package com.mango.prjmango.createaccount.basicinfo;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * This class creates the Basic Info page when the user clicks Create Account.
 */
public class CreateAccountView extends RoundedPanel {

    @Getter private JButton nextButton;
    @Getter private JButton backButton;

    @Getter private JTextField firstNameText;
    @Getter private JTextField lastNameText;
    @Getter private JTextField emailText;

    private final Insets MARGINS = new Insets(0, 5, 0, 5);

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public CreateAccountView() {
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

        JLabel createAccountHeader = createLabel("Create Account", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (this.getHeight() * 0.38), this.getWidth(),30);

        JLabel enterFirstNameHeader = createLabel("Enter First Name", FontType.FONT_12_BOLD);
        enterFirstNameHeader.setBounds(0,( int) (this.getHeight() * 0.48), this.getWidth(),15);

        firstNameText = new JTextField("First name");
        firstNameText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.51),
                (int) (this.getWidth() * 0.5),
                30);
        firstNameText.setBackground(Color.WHITE);
        firstNameText.setMargin(MARGINS);

        JLabel enterLastNameHeader = createLabel("Enter Last Name", FontType.FONT_12_BOLD);
        enterLastNameHeader.setBounds(0, (int) (this.getHeight() * 0.58), this.getWidth(),15);

        lastNameText = new JTextField("Last name");
        lastNameText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.61),
                (int) (this.getWidth() * 0.5),
                30);
        lastNameText.setBackground(Color.WHITE);
        lastNameText.setMargin(MARGINS);

        JLabel emailHeader = createLabel("Enter Email", FontType.FONT_12_BOLD);
        emailHeader.setBounds(0, (int) (this.getHeight() * 0.68), this.getWidth(),15);

        emailText = new JTextField("Email");
        emailText.setBounds(
                (int) (this.getWidth() * 0.5) - (int) (this.getWidth() * 0.25),
                (int) (this.getHeight() * 0.71),
                (int) (this.getWidth() * 0.5),
                30);
        emailText.setBackground(Color.WHITE);
        emailText.setMargin(MARGINS);

        nextButton = createButton("Next");
        nextButton.setBounds(
                (int) (this.getWidth() * 0.65) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.77),
                (int) (this.getWidth() * 0.20),
                30);

        backButton = createButton("Back");
        backButton.setBounds(
                (int) (this.getWidth() * 0.35) - (int) (this.getWidth() * 0.10),
                (int) (this.getHeight() * 0.77),
                (int) (this.getWidth() * 0.20),
                30);

        this.add(createAccountHeader);
        this.add(enterFirstNameHeader);
        this.add(emailHeader);
        this.add(enterLastNameHeader);
        this.add(firstNameText);
        this.add(lastNameText);
        this.add(emailText);
        this.add(nextButton);
        this.add(backButton);
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
