package com.mango.app.teacher;

import com.mango.app.Main;
import com.mango.app.components.BackgroundPanel;
import com.mango.app.components.FontType;
import com.mango.app.components.GradientPanel;
import com.mango.app.components.RoundedPanel;
import com.mango.app.mainloginpage.MainLoginView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherView {

    private JFrame teacherWindow;

    private static BackgroundPanel backgroundTeacherPanel;
    private static BackgroundPanel gradientPanel;
    private static BackgroundPanel optionsTeacherPanel;

    private static JButton myAccountButton;
    private static JButton studentsButton;
    private static JButton fullReportsButton;
    private static JButton activitiesButton;
    private static JButton helpButton;
    private static JButton logOutButton;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    private static final Logger logger = Logger.getLogger(MainLoginView.class.getName());

    public TeacherView() {

        createFrame();
        createPanel();
        createComponents();


        teacherWindow.getContentPane().add(backgroundTeacherPanel);
        teacherWindow.pack();
        teacherWindow.setLocationRelativeTo(null);
        teacherWindow.setVisible(true);


    }

    private void createComponents() {
        JLabel gradientPhoto = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/GradientPanel.PNG",
                (229/2),
                110)));
        JLabel grad = new JLabel("Test");
        grad.setBounds(10,10,100,25);

        //options teacher panel

        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (optionsTeacherPanel.getWidth() * 0.5) - 50,
                (int) (optionsTeacherPanel.getHeight() * 0.005),
                (229 / 2),
                110);
        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (optionsTeacherPanel.getHeight() * 0.14) , optionsTeacherPanel.getWidth(),45);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                 (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.20),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JSeparator separatorHeader2 = new JSeparator(SwingConstants.CENTER);
        separatorHeader2.setBounds(
                (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.25),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader2.setBackground(Color.WHITE);

        myAccountButton = createButton("My Account");
        myAccountButton.setFont(new Font("Arial", Font.PLAIN, 35));
        myAccountButton.setBounds(
                 (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.26),
                (optionsTeacherPanel.getWidth()),
                45);
        myAccountButton.setOpaque(false);

        studentsButton = createButton("Students");
        studentsButton.setFont(new Font("Arial", Font.PLAIN, 35));
        studentsButton.setBounds(
                (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.32),
                (optionsTeacherPanel.getWidth()),
                45);
        studentsButton.setOpaque(false);

        fullReportsButton = createButton("Full Reports");
        fullReportsButton.setFont(new Font("Arial", Font.PLAIN, 35));
        fullReportsButton.setBounds(
                (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.38),
                (optionsTeacherPanel.getWidth()),
                45);
        fullReportsButton.setOpaque(false);

        activitiesButton = createButton("Activities");
        activitiesButton.setFont(new Font("Arial", Font.PLAIN, 35));
        activitiesButton.setBounds(
                (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.44),
                (optionsTeacherPanel.getWidth()),
                45);
        activitiesButton.setOpaque(false);

        helpButton = createButton("Help");
        helpButton.setFont(new Font("Arial", Font.PLAIN, 35));
        helpButton.setBounds(
                (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.50),
                (optionsTeacherPanel.getWidth()),
                45);
        helpButton.setOpaque(false);

        JSeparator separatorHeader3 = new JSeparator(SwingConstants.CENTER);
        separatorHeader3.setBounds(
                (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.56),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader3.setBackground(Color.WHITE);

        logOutButton = createButton("Log Out");
        logOutButton.setFont(new Font("Arial", Font.PLAIN, 25));
        logOutButton.setBounds(
                (optionsTeacherPanel.getWidth()) - (optionsTeacherPanel.getWidth()),
                (int) (optionsTeacherPanel.getHeight() * 0.87),
                (optionsTeacherPanel.getWidth()),
                30);
        logOutButton.setOpaque(false);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/Mango3.png",
                50,
                50)));
        mangoLogo.setBounds(
                (int) (optionsTeacherPanel.getWidth() * 0.5) - 25,
                (optionsTeacherPanel.getHeight() - 75),
                50,
                50);

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
        optionsTeacherPanel.add(separatorHeader3);
        optionsTeacherPanel.add(logOutButton);

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

    private void createFrame() {
        teacherWindow = new JFrame();
        teacherWindow.setPreferredSize(WINDOW_DIMENSIONS);
        teacherWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        teacherWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void createPanel() {
        try {
            backgroundTeacherPanel = new BackgroundPanel();
            backgroundTeacherPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/BackgroundTeacherImage.PNG")));
            backgroundTeacherPanel.setLayout(null);
            backgroundTeacherPanel.setBounds(
                    (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                    (int) (Main.SCREEN_HEIGHT * 0.125),
                    (int) (Main.SCREEN_WIDTH * 0.3),
                    (int) (Main.SCREEN_HEIGHT * 0.70));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
        try {
            gradientPanel = new BackgroundPanel();
            gradientPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/GradientPanel.PNG")));
            gradientPanel.setLayout(null);
            gradientPanel.setBounds(
                    (0),
                    (0),
                    (int) (Main.SCREEN_WIDTH * 1),
                    (int) (Main.SCREEN_HEIGHT * 0.2));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load gradient image.");
        }
        try {
            optionsTeacherPanel = new BackgroundPanel();
            optionsTeacherPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/OptionsTeacherPanel.PNG")));
            optionsTeacherPanel.setLayout(null);
            optionsTeacherPanel.setBounds(
                    (0),
                    (0),
                    (int) (Main.SCREEN_WIDTH * 0.17),
                    (int) (Main.SCREEN_HEIGHT * 1.0));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Options image. ");
        }

        backgroundTeacherPanel.add(optionsTeacherPanel);
        backgroundTeacherPanel.add(gradientPanel);
    }

    /**
     * Swaps out the panels.
     *
     * @param panel the panel to display
     */
    public static void setActivePanel(RoundedPanel panel) {
        backgroundTeacherPanel.removeAll();
        backgroundTeacherPanel.add(panel);
        backgroundTeacherPanel.updateUI();
        backgroundTeacherPanel.add(gradientPanel);

    }

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public JFrame getTeacherWindow() { return teacherWindow; }
    public JButton getMyAccountButton() { return myAccountButton; }
    public JButton getStudentsButton() { return studentsButton; }
    public JButton getFullReportsButton() { return fullReportsButton; }
    public JButton getActivitiesButton() { return activitiesButton; }
    public JButton getHelpButton() { return helpButton; }
    public JButton getLogOutButton() { return helpButton; }


}