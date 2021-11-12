package com.mango.prjmango.createaccount;

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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import lombok.Getter;

public class CreateAccountView {

    private final @Getter RoundedPanel createAccountPanel;

    private @Getter JButton nextButton;
    private @Getter JButton backButton;

    private @Getter JTextField firstNameText;
    private @Getter JTextField lastNameText;
    private @Getter JTextField emailText;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public CreateAccountView() {
        createAccountPanel = new RoundedPanel();
        createAccountPanel.setLayout(null);
        createAccountPanel.setBounds(
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
                (int) (createAccountPanel.getWidth() * 0.5) - 50,
                (int) (createAccountPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                ImagePaths.MANGO_LOGO,
                50,
                50)));
        mangoLogo.setBounds(
                (int) (createAccountPanel.getWidth() * 0.5) - 25,
                (createAccountPanel.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (createAccountPanel.getHeight() * 0.28) , createAccountPanel.getWidth(),45);

        JLabel createAccountHeader = createLabel("Create Account", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (createAccountPanel.getHeight() * 0.38), createAccountPanel.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (createAccountPanel.getWidth() * 0.5) - (int) (createAccountPanel.getWidth() * 0.20),
                (int) (createAccountPanel.getHeight() * 0.45),
                (int) (createAccountPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel enterFirstNameHeader = createLabel("Enter First Name", FontType.FONT_12_BOLD);
        enterFirstNameHeader.setBounds(0,( int) (createAccountPanel.getHeight() * 0.48), createAccountPanel.getWidth(),15);

        firstNameText = new JTextField("First name");
        firstNameText.setBounds(
                (int) (createAccountPanel.getWidth() * 0.5) - (int) (createAccountPanel.getWidth() * 0.25),
                (int) (createAccountPanel.getHeight() * 0.51),
                (int) (createAccountPanel.getWidth() * 0.5),
                30);
        firstNameText.setBackground(Color.WHITE);

        JLabel enterLastNameHeader = createLabel("Enter Last Name", FontType.FONT_12_BOLD);
        enterLastNameHeader.setBounds(0, (int) (createAccountPanel.getHeight() * 0.58), createAccountPanel.getWidth(),15);

        lastNameText = new JTextField("Last name");
        lastNameText.setBounds(
                (int) (createAccountPanel.getWidth() * 0.5) - (int) (createAccountPanel.getWidth() * 0.25),
                (int) (createAccountPanel.getHeight() * 0.61),
                (int) (createAccountPanel.getWidth() * 0.5),
                30);
        lastNameText.setBackground(Color.WHITE);

        JLabel emailHeader = createLabel("Enter Email", FontType.FONT_12_BOLD);
        emailHeader.setBounds(0, (int) (createAccountPanel.getHeight() * 0.68), createAccountPanel.getWidth(),15);

        emailText = new JTextField("Email");
        emailText.setBounds(
                (int) (createAccountPanel.getWidth() * 0.5) - (int) (createAccountPanel.getWidth() * 0.25),
                (int) (createAccountPanel.getHeight() * 0.71),
                (int) (createAccountPanel.getWidth() * 0.5),
                30);
        emailText.setBackground(Color.WHITE);

        nextButton = createButton("Next");
        nextButton.setBounds(
                (int) (createAccountPanel.getWidth() * 0.65) - (int) (createAccountPanel.getWidth() * 0.10),
                (int) (createAccountPanel.getHeight() * 0.77),
                (int) (createAccountPanel.getWidth() * 0.20),
                30);

        backButton = createButton("Back");
        backButton.setBounds(
                (int) (createAccountPanel.getWidth() * 0.35) - (int) (createAccountPanel.getWidth() * 0.10),
                (int) (createAccountPanel.getHeight() * 0.77),
                (int) (createAccountPanel.getWidth() * 0.20),
                30);

        createAccountPanel.add(schoolLogo);
        createAccountPanel.add(mangoLogo);
        createAccountPanel.add(titleHeader);
        createAccountPanel.add(createAccountHeader);
        createAccountPanel.add(separatorHeader);
        createAccountPanel.add(enterFirstNameHeader);
        createAccountPanel.add(emailHeader);
        createAccountPanel.add(enterLastNameHeader);
        createAccountPanel.add(firstNameText);
        createAccountPanel.add(lastNameText);
        createAccountPanel.add(emailText);
        createAccountPanel.add(nextButton);
        createAccountPanel.add(backButton);
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

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
