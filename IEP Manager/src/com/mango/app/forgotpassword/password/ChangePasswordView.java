package com.mango.app.forgotpassword.password;

import com.mango.app.Main;
import com.mango.app.components.FontType;
import com.mango.app.components.RoundedPanel;

import javax.swing.*;
import java.awt.*;

public class ChangePasswordView {

    private final RoundedPanel changePasswordPanel;

    private JButton cancelButton;
    private JButton changePasswordButton;

    private JPasswordField passwordText;
    private JPasswordField confirmPasswordText;

    private final int teacher_id;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public ChangePasswordView(int teacher_id) {
        this.teacher_id = teacher_id;
        changePasswordPanel = new RoundedPanel();
        changePasswordPanel.setLayout(null);
        changePasswordPanel.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
    }

    private void createComponents() {
        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - 50,
                (int) (changePasswordPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/Mango3.png",
                50,
                50)));
        mangoLogo.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - 25,
                (changePasswordPanel.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.28) , changePasswordPanel.getWidth(),45);

        JLabel createAccountHeader = createLabel("Change Password", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.38), changePasswordPanel.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - (int) (changePasswordPanel.getWidth() * 0.20),
                (int) (changePasswordPanel.getHeight() * 0.45),
                (int) (changePasswordPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel passwordHeader = createLabel("New Password", FontType.FONT_12_BOLD);
        passwordHeader.setBounds(0,( int) (changePasswordPanel.getHeight() * 0.48), changePasswordPanel.getWidth(),15);

        passwordText = new JPasswordField("");
        passwordText.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - (int) (changePasswordPanel.getWidth() * 0.25),
                (int) (changePasswordPanel.getHeight() * 0.54),
                (int) (changePasswordPanel.getWidth() * 0.5),
                30);
        passwordText.setBackground(Color.WHITE);

        JLabel confirmPasswordHeader = createLabel("Confirm New Password", FontType.FONT_12_BOLD);
        confirmPasswordHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.62), changePasswordPanel.getWidth(),15);

        confirmPasswordText = new JPasswordField("");
        confirmPasswordText.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - (int) (changePasswordPanel.getWidth() * 0.25),
                (int) (changePasswordPanel.getHeight() * 0.68),
                (int) (changePasswordPanel.getWidth() * 0.5),
                30);
        confirmPasswordText.setBackground(Color.WHITE);

        cancelButton = createButton("Cancel");
        cancelButton.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.5) - ((int) (changePasswordPanel.getWidth() * 0.2)/2),
                (int) (changePasswordPanel.getHeight() * 0.83),
                (int) (changePasswordPanel.getWidth() * 0.20),
                30);

        changePasswordButton = createButton("Change Password");
        changePasswordButton.setBounds(
                (int) (changePasswordPanel.getWidth() * 0.40) - (int) (changePasswordPanel.getWidth() * 0.10),
                (int) (changePasswordPanel.getHeight() * 0.77),
                (int) (changePasswordPanel.getWidth() * 0.40),
                30);

        changePasswordPanel.add(schoolLogo);
        changePasswordPanel.add(mangoLogo);
        changePasswordPanel.add(titleHeader);
        changePasswordPanel.add(createAccountHeader);
        changePasswordPanel.add(separatorHeader);
        changePasswordPanel.add(passwordHeader);
        changePasswordPanel.add(confirmPasswordHeader);
        changePasswordPanel.add(passwordText);
        changePasswordPanel.add(confirmPasswordText);
        changePasswordPanel.add(cancelButton);
        changePasswordPanel.add(changePasswordButton);
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

    public RoundedPanel getChangePasswordPanel() { return changePasswordPanel; }

    public JButton getChangePasswordButton(){ return changePasswordButton; }
    public JButton getCancelButton(){ return cancelButton; }
    public JTextField getPasswordText(){ return passwordText; }
    public JTextField getConfirmPasswordText(){ return confirmPasswordText; }
    public int getTeacher_id(){ return teacher_id; }
}
