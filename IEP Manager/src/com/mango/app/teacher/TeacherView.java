package com.mango.app.teacher;

import com.mango.app.Main;
import com.mango.app.components.BackgroundPanel;
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
                    (int) (Main.SCREEN_HEIGHT * 0.25));
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
                    (int) (Main.SCREEN_WIDTH * 0.2),
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

}