package com.mango.app.teacher;

import com.mango.app.Main;
import com.mango.app.components.BackgroundPanel;
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

    private final RoundedPanel teacherPanel;
    private JFrame teacherWindow;

    private static BackgroundPanel backgroundTeacherPanel;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    private static final Logger logger = Logger.getLogger(MainLoginView.class.getName());

    public TeacherView() {
        teacherPanel = new RoundedPanel();
        
        createFrame();
        createPanel();

        teacherWindow.getContentPane().add(backgroundTeacherPanel);
        teacherWindow.pack();
        teacherWindow.setLocationRelativeTo(null);
        teacherWindow.setVisible(true);
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
            backgroundTeacherPanel.setBounds(0, 0, 100, 100);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
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

    }

    public JFrame getTeacherWindow() { return teacherWindow; }
    
    public RoundedPanel getTeacherPanel() { return teacherPanel; }

}