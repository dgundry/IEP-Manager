package com.mango.prjmango.teacher;

import com.mango.prjmango.Main;
import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.FontType;
import lombok.Getter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import static com.mango.prjmango.Main.activeUser;

public class TeacherView extends BackgroundPanel{

    private GridBagConstraints gbc;
    private static @Getter BackgroundPanel gradientPanel;
    private static @Getter  BackgroundPanel optionsTeacherPanel;
    private static @Getter JPanel mainPanel;

    private static @Getter  JButton myAccountButton;
    private static @Getter  JButton studentsButton;
    private static @Getter  JButton fullReportsButton;
    private static @Getter  JButton activitiesButton;
    private static @Getter  JButton helpButton;
    private static @Getter  JButton createStudentButton;
    private static @Getter  JButton logOutButton;

    private static final Logger logger = Logger.getLogger(MainFrame.class.getName());

    public TeacherView() {
        gbc = new GridBagConstraints();
        try {
            this.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/BackgroundTeacherImage.PNG")));
            this.setLayout(null);
            this.setBounds(0,
                    0,
                    Main.SCREEN_WIDTH,
                    Main.SCREEN_HEIGHT);
            createPanel();
            createComponents();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
    }public TeacherView(JPanel mainPanel) {
        gbc = new GridBagConstraints();
        try {
            this.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/BackgroundTeacherImage.PNG")));
            this.setLayout(null);
            this.setBounds(0,
                   0,
                    Main.SCREEN_WIDTH,
                    Main.SCREEN_HEIGHT);
            createPanel();
            createComponents();
            this.add(mainPanel);
            add(mainPanel);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
    }

    private void createComponents() {
        JLabel welcomeText = createLabel("Welcome, " + activeUser.getFirstName(), FontType.FONT_35_BOLD);
        welcomeText.setBounds(0, (int) (gradientPanel.getHeight() * 0.14), gradientPanel.getWidth(), 45);

        //options teacher panel

        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/main/java/com/mango/prjmango/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (optionsTeacherPanel.getWidth() * 0.5) - 50,
                (int) (optionsTeacherPanel.getHeight() * 0.005),
                (229 / 2),
                110);
        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (optionsTeacherPanel.getHeight() * 0.14), optionsTeacherPanel.getWidth(), 45);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.20),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JSeparator separatorHeader2 = new JSeparator(SwingConstants.CENTER);
        separatorHeader2.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.25),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader2.setBackground(Color.WHITE);


        studentsButton = createButton("Students");
        studentsButton.setFont(new Font("Arial", Font.PLAIN, 35));
        studentsButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.26),
                (optionsTeacherPanel.getWidth()),
                45);
        studentsButton.setOpaque(false);

        myAccountButton = createButton("My Account");
        myAccountButton.setFont(new Font("Arial", Font.PLAIN, 35));
        myAccountButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.32),
                (optionsTeacherPanel.getWidth()),
                45);
        myAccountButton.setOpaque(false);


        fullReportsButton = createButton("Full Reports");
        fullReportsButton.setFont(new Font("Arial", Font.PLAIN, 35));
        fullReportsButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.38),
                (optionsTeacherPanel.getWidth()),
                45);
        fullReportsButton.setOpaque(false);

        activitiesButton = createButton("Activities");
        activitiesButton.setFont(new Font("Arial", Font.PLAIN, 35));
        activitiesButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.44),
                (optionsTeacherPanel.getWidth()),
                45);
        activitiesButton.setOpaque(false);

        helpButton = createButton("Help");
        helpButton.setFont(new Font("Arial", Font.PLAIN, 35));
        helpButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.50),
                (optionsTeacherPanel.getWidth()),
                45);
        helpButton.setOpaque(false);

        JSeparator separatorHeader3 = new JSeparator(SwingConstants.CENTER);
        separatorHeader3.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.56),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader3.setBackground(Color.WHITE);

        logOutButton = createButton("Log Out");
        logOutButton.setFont(new Font("Arial", Font.PLAIN, 25));
        logOutButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.87),
                (optionsTeacherPanel.getWidth()),
                30);
        logOutButton.setOpaque(false);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/main/java/com/mango/prjmango/utilities/images/Mango3.png",
                50,
                50)));
        mangoLogo.setBounds(
                (int) (optionsTeacherPanel.getWidth() * 0.5) - 25,
                (optionsTeacherPanel.getHeight() - 75),
                50,
                50);
        createStudentButton = createButton("Create Student");
        createStudentButton.setFont(new Font("Ariel", Font.PLAIN, 25));
        createStudentButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.70),
                (optionsTeacherPanel.getWidth()),
                30);
        createStudentButton.setOpaque(false);


        //options teacher panel

        optionsTeacherPanel.add(schoolLogo);
        optionsTeacherPanel.add(mangoLogo);
        optionsTeacherPanel.add(titleHeader);
        optionsTeacherPanel.add(separatorHeader);
        optionsTeacherPanel.add(separatorHeader2);
        optionsTeacherPanel.add(myAccountButton);
        optionsTeacherPanel.add(studentsButton);
        optionsTeacherPanel.add(fullReportsButton);
        optionsTeacherPanel.add(activitiesButton);
        optionsTeacherPanel.add(helpButton);
        optionsTeacherPanel.add(createStudentButton);
        optionsTeacherPanel.add(separatorHeader3);
        optionsTeacherPanel.add(logOutButton);

        gradientPanel.add(welcomeText);
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
            optionsTeacherPanel = new BackgroundPanel();
            optionsTeacherPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/OptionsTeacherPanel.PNG")));
            optionsTeacherPanel.setLayout(null);
            optionsTeacherPanel.setBounds(
                    (0),
                    (0),
                    (int) (Main.SCREEN_WIDTH * 0.2),
                    Main.SCREEN_HEIGHT);
            this.add(optionsTeacherPanel);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Options image. ");
        }
        try {
            gradientPanel = new BackgroundPanel();
            gradientPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/GradientPanel.PNG")));
            gradientPanel.setLayout(null);
            gradientPanel.setBounds(
                    (0),
                    (0),
                    (int) (Main.SCREEN_WIDTH * 1),
                    (int) (Main.SCREEN_HEIGHT * 0.25));
            this.add(gradientPanel);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load gradient image.");
        }
    }
    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
