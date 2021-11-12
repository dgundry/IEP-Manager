package com.mango.prjmango.forgotpassword.email;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EmailView {
    private final RoundedPanel emailPanel;

    private JButton nextButton;
    private JButton cancelButton;

    private JTextField emailText;

    public EmailView() {
        emailPanel = new RoundedPanel();
        emailPanel.setLayout(null);
        emailPanel.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
    }

    private void createComponents() {
        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/main/java/com/mango/prjmango/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (emailPanel.getWidth() * 0.5) - 50,
                (int) (emailPanel.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/main/java/com/mango/prjmango/utilities/images/Mango3.png",
                50,
                50)));
        mangoLogo.setBounds(
                (int) (emailPanel.getWidth() * 0.5) - 25,
                (emailPanel.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (emailPanel.getHeight() * 0.28) , emailPanel.getWidth(),45);

        JLabel createAccountHeader = createLabel("Reset Password", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (emailPanel.getHeight() * 0.38), emailPanel.getWidth(),30);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (emailPanel.getWidth() * 0.5) - (int) (emailPanel.getWidth() * 0.20),
                (int) (emailPanel.getHeight() * 0.45),
                (int) (emailPanel.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JLabel enterEmailHeader = createLabel("Enter Email", FontType.FONT_12_BOLD);
        enterEmailHeader.setBounds(0,( int) (emailPanel.getHeight() * 0.48), emailPanel.getWidth(),15);

        emailText = new JTextField("Email");
        emailText.setBounds(
                (int) (emailPanel.getWidth() * 0.5) - (int) (emailPanel.getWidth() * 0.25),
                (int) (emailPanel.getHeight() * 0.51),
                (int) (emailPanel.getWidth() * 0.5),
                30);
        emailText.setBackground(Color.WHITE);

        nextButton = createButton("Next");
        nextButton.setBounds(
                (int) (emailPanel.getWidth() * 0.65) - (int) (emailPanel.getWidth() * 0.10),
                (int) (emailPanel.getHeight() * 0.77),
                (int) (emailPanel.getWidth() * 0.20),
                30);

        cancelButton = createButton("Cancel");
        cancelButton.setBounds(
                (int) (emailPanel.getWidth() * 0.35) - (int) (emailPanel.getWidth() * 0.10),
                (int) (emailPanel.getHeight() * 0.77),
                (int) (emailPanel.getWidth() * 0.20),
                30);

        emailPanel.add(schoolLogo);
        emailPanel.add(mangoLogo);
        emailPanel.add(titleHeader);
        emailPanel.add(createAccountHeader);
        emailPanel.add(separatorHeader);
        emailPanel.add(enterEmailHeader);
        emailPanel.add(emailText);
        emailPanel.add(nextButton);
        emailPanel.add(cancelButton);
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

    public RoundedPanel getEmailPanel() { return emailPanel; }

    public JButton getNextButton(){ return nextButton; }
    public JButton getCancelButton(){ return cancelButton; }
    public JTextField getEmailText(){ return emailText; }
}
