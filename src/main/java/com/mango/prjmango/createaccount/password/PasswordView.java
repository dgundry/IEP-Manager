package com.mango.prjmango.createaccount.password;

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
import javax.swing.SwingConstants;
import lombok.Getter;

public class PasswordView {

    private final @Getter RoundedPanel createPasswordPanel;

    private @Getter JButton backButton;
    private @Getter JButton createAccountButton;

    private @Getter JPasswordField passwordText;
    private @Getter JPasswordField confirmPasswordText;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public PasswordView() {
        createPasswordPanel = new RoundedPanel();
        createPasswordPanel.setLayout(null);
        createPasswordPanel.setBounds(
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
                (int) (createPasswordPanel.getWidth() * 0.5) - 50,
                (int) (createPasswordPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                ImagePaths.MANGO_LOGO,
                50,
                50)));
        mangoLogo.setBounds(
                (int) (createPasswordPanel.getWidth() * 0.5) - 25,
                (createPasswordPanel.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (createPasswordPanel.getHeight() * 0.28) , createPasswordPanel.getWidth(),45);

        JLabel createAccountHeader = createLabel("Create Account", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (createPasswordPanel.getHeight() * 0.38), createPasswordPanel.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (createPasswordPanel.getWidth() * 0.5) - (int) (createPasswordPanel.getWidth() * 0.20),
                (int) (createPasswordPanel.getHeight() * 0.45),
                (int) (createPasswordPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel passwordHeader = createLabel("Create Password", FontType.FONT_12_BOLD);
        passwordHeader.setBounds(0,( int) (createPasswordPanel.getHeight() * 0.48), createPasswordPanel.getWidth(),15);

        passwordText = new JPasswordField("");
        passwordText.setBounds(
                (int) (createPasswordPanel.getWidth() * 0.5) - (int) (createPasswordPanel.getWidth() * 0.25),
                (int) (createPasswordPanel.getHeight() * 0.54),
                (int) (createPasswordPanel.getWidth() * 0.5),
                30);
        passwordText.setBackground(Color.WHITE);

        JLabel confirmPasswordHeader = createLabel("Confirm Password", FontType.FONT_12_BOLD);
        confirmPasswordHeader.setBounds(0, (int) (createPasswordPanel.getHeight() * 0.62), createPasswordPanel.getWidth(),15);

        confirmPasswordText = new JPasswordField("");
        confirmPasswordText.setBounds(
                (int) (createPasswordPanel.getWidth() * 0.5) - (int) (createPasswordPanel.getWidth() * 0.25),
                (int) (createPasswordPanel.getHeight() * 0.68),
                (int) (createPasswordPanel.getWidth() * 0.5),
                30);
        confirmPasswordText.setBackground(Color.WHITE);

        backButton = createButton("Back");
        backButton.setBounds(
                (int) (createPasswordPanel.getWidth() * 0.35) - (int) (createPasswordPanel.getWidth() * 0.10),
                (int) (createPasswordPanel.getHeight() * 0.77),
                (int) (createPasswordPanel.getWidth() * 0.20),
                30);

        createAccountButton = createButton("Create Account");
        createAccountButton.setBounds(
                (int) (createPasswordPanel.getWidth() * 0.40) - (int) (createPasswordPanel.getWidth() * 0.10),
                (int) (createPasswordPanel.getHeight() * 0.83),
                (int) (createPasswordPanel.getWidth() * 0.40),
                30);

        createPasswordPanel.add(schoolLogo);
        createPasswordPanel.add(mangoLogo);
        createPasswordPanel.add(titleHeader);
        createPasswordPanel.add(createAccountHeader);
        createPasswordPanel.add(separatorHeader);
        createPasswordPanel.add(passwordHeader);
        createPasswordPanel.add(confirmPasswordHeader);
        createPasswordPanel.add(passwordText);
        createPasswordPanel.add(confirmPasswordText);
        createPasswordPanel.add(backButton);
        createPasswordPanel.add(createAccountButton);
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

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
