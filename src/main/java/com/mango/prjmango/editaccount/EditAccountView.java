package com.mango.prjmango.editaccount;


import com.mango.prjmango.Main;
import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.mainloginpage.MainLoginView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class EditAccountView extends BackgroundPanel{

    private static BackgroundPanel editAccountPanel;
    private static BackgroundPanel changePasswordPanel;
    private static BackgroundPanel changeEmailPanel;
    private static BackgroundPanel wrapPanel;

    private static JButton myAccountButton;
    private static JButton studentsButton;
    private static JButton fullReportsButton;
    private static JButton activitiesButton;
    private static JButton helpButton;
    private static JButton createStudentButton;
    private static JButton logOutButton;


    private JTextField currentPassText;
    private JTextField newPassText;
    private JTextField confirmNewPassText;
    private static JButton savePassword;

    private JTextField currentEmailText;
    private JTextField newEmailText;
    private JTextField confirmPassText;
    private static JButton saveEmail;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    private static final Logger logger = Logger.getLogger(MainLoginView.class.getName());

    public EditAccountView() {
        try {
            this.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/BackgroundTeacherImage.PNG")));
            this.setLayout(null);
            this.setBounds(
                    0,
                    0,
                    Main.SCREEN_WIDTH,
                    Main.SCREEN_HEIGHT);
            createPanel();
            createComponents();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
    }

    private void createComponents() {
        //change password panel
        JLabel changePasswordHeader = createLabel("Change Password", FontType.FONT_35_BOLD);
        changePasswordHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.05) , changePasswordPanel.getWidth(),45);

        JSeparator separatorHeader4 = new JSeparator(SwingConstants.CENTER);
        separatorHeader4.setBounds(
                (changePasswordPanel.getWidth()) - (changePasswordPanel.getWidth()),
                (int) (changePasswordPanel.getHeight() * 0.20),
                (changePasswordPanel.getWidth()),
                1);
        separatorHeader4.setBackground(Color.WHITE);

        JLabel currentPassword = new JLabel("Current password: ");
        currentPassword.setBounds(10, (int) (changePasswordPanel.getHeight() * 0.3), changePasswordPanel.getWidth(), 25);
        currentPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        currentPassword.setForeground(Color.WHITE);

        currentPassText = new JTextField("Password");
        currentPassText.setBounds(180, (int) (changePasswordPanel.getHeight() * 0.3), 180, 25);

        JLabel newPassword = new JLabel("New password:");
        newPassword.setBounds(35, (int) (changePasswordPanel.getHeight() * 0.4), changePasswordPanel.getWidth(), 25);
        newPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        newPassword.setForeground(Color.WHITE);

        newPassText = new JTextField("Password");
        newPassText.setBounds(180, (int) (changePasswordPanel.getHeight() * 0.4), 180, 25);

        JLabel confirmNewPassword = new JLabel("Confirm password:");
        confirmNewPassword.setBounds(7, (int) (changePasswordPanel.getHeight() * 0.5), changePasswordPanel.getWidth(), 25);
        confirmNewPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        confirmNewPassword.setForeground(Color.WHITE);

        confirmNewPassText = new JTextField("Password");
        confirmNewPassText.setBounds(180, (int) (changePasswordPanel.getHeight() * 0.5), 180, 25);

        savePassword = createButton("Save");
        savePassword.setFont(new Font("Arial", Font.PLAIN, 25));
        savePassword.setBounds(
                (changePasswordPanel.getWidth()) - (changePasswordPanel.getWidth()),
                (int) (changePasswordPanel.getHeight() * 0.8),
                (changePasswordPanel.getWidth()),
                30);

        //change password panel

        changePasswordPanel.add(changePasswordHeader);
        changePasswordPanel.add(separatorHeader4);
        changePasswordPanel.add(currentPassword);
        changePasswordPanel.add(currentPassText);
        changePasswordPanel.add(newPassword);
        changePasswordPanel.add(newPassText);
        changePasswordPanel.add(confirmNewPassword);
        changePasswordPanel.add(confirmNewPassText);
        changePasswordPanel.add(savePassword);


        //change email panel

        JLabel changeEmailHeader = createLabel("Change Email", FontType.FONT_35_BOLD);
        changeEmailHeader.setBounds(0, (int) (changeEmailPanel.getHeight() * 0.05) , changeEmailPanel.getWidth(),45);

        JSeparator separatorHeader5 = new JSeparator(SwingConstants.CENTER);
        separatorHeader5.setBounds(
                (changeEmailPanel.getWidth()) - (changeEmailPanel.getWidth()),
                (int) (changeEmailPanel.getHeight() * 0.20),
                (changeEmailPanel.getWidth()),
                1);
        separatorHeader5.setBackground(Color.WHITE);

        JLabel currentEmail = new JLabel("Current email:");
        currentEmail.setBounds(50, (int) (changeEmailPanel.getHeight() * 0.3), (int) changeEmailPanel.getWidth(), 25);
        currentEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        currentEmail.setForeground(Color.WHITE);

        currentEmailText = new JTextField("Email");
        currentEmailText.setBounds(180, (int) (changeEmailPanel.getHeight() * 0.3), 180, 25);

        JLabel newEmail = new JLabel("New email:");
        newEmail.setBounds(75, (int) (changeEmailPanel.getHeight() * 0.4), changeEmailPanel.getWidth(), 25);
        newEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        newEmail.setForeground(Color.WHITE);

        newEmailText = new JTextField("Email");
        newEmailText.setBounds(180, (int) (changeEmailPanel.getHeight() * 0.4), 180, 25);

        JLabel confirmPassword = new JLabel("Confirm password:");
        confirmPassword.setBounds(7, (int) (changeEmailPanel.getHeight() * 0.5), changeEmailPanel.getWidth(), 25);
        confirmPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        confirmPassword.setForeground(Color.WHITE);

        confirmPassText = new JTextField("Password");
        confirmPassText.setBounds(180, (int) (changeEmailPanel.getHeight() * 0.5), 180, 25);

        saveEmail = createButton("Save");
        saveEmail.setFont(new Font("Arial", Font.PLAIN, 25));
        saveEmail.setBounds(
                (changeEmailPanel.getWidth()) - (changeEmailPanel.getWidth()),
                (int) (changeEmailPanel.getHeight() * 0.8),
                (changeEmailPanel.getWidth()),
                30);

        //change email panel

        changeEmailPanel.add(changeEmailHeader);
        changeEmailPanel.add(separatorHeader5);
        changeEmailPanel.add(currentEmail);
        changeEmailPanel.add(currentEmailText);
        changeEmailPanel.add(newEmail);
        changeEmailPanel.add(newEmailText);
        changeEmailPanel.add(confirmPassword);
        changeEmailPanel.add(confirmPassText);
        changeEmailPanel.add(saveEmail);

    }

    private JLabel createLabel(String text, Font font){
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
    private void createPanel() {
       try {
            changePasswordPanel = new BackgroundPanel();
            changePasswordPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/grey.png")));
            changePasswordPanel.setLayout(null);
            changePasswordPanel.setBounds(
                    (400),
                    (300),
                    (int) (Main.SCREEN_WIDTH * 0.25),
                    (int) (Main.SCREEN_HEIGHT * 0.4));
            this.add(changePasswordPanel);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Password image. ");
        }try {
            changeEmailPanel = new BackgroundPanel();
            changeEmailPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/grey.png")));
            changeEmailPanel.setLayout(null);
            changeEmailPanel.setBounds(
                    (1000),
                    (300),
                    (int) (Main.SCREEN_WIDTH * 0.25),
                    (int) (Main.SCREEN_HEIGHT * 0.4));
            this.add(changeEmailPanel);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Email image. ");
        }
        try {
            wrapPanel = new BackgroundPanel();
            wrapPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/black.PNG")));
            wrapPanel.setLayout(null);
            wrapPanel.setBounds(
                    (100),
                    (173),
                    (int) (Main.SCREEN_WIDTH * 0.935),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
            this.add(wrapPanel);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Wrap image. ");
        }

        add(changePasswordPanel);
        add(changeEmailPanel);
        add(wrapPanel);
    }

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public JButton getMyAccountButton() { return myAccountButton; }
    public JButton getStudentsButton() { return studentsButton; }
    public JButton getFullReportsButton() { return fullReportsButton; }
    public JButton getActivitiesButton() { return activitiesButton; }
    public JButton getHelpButton() { return helpButton; }
    public JButton getLogOutButton() { return helpButton; }
    public JButton getCreateStudentButton() { return createStudentButton; }
    public JTextField getCurrentPassText() { return currentPassText; }
    public JTextField getNewPassText() { return newPassText; }
    public JTextField getConfirmNewPassText() { return confirmNewPassText; }
    public JButton getSavePassword() { return savePassword; }
    public JTextField getCurrentEmailText() { return currentEmailText; }
    public JTextField getNewEmailText() { return newEmailText; }
    public JTextField getConfirmPassText() { return confirmPassText; }
    public JButton getSaveEmail() { return saveEmail; }


}