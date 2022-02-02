package com.mango.prjmango;

import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.mainloginpage.MainLoginView;
import com.mango.prjmango.teacher.TeacherController;
import com.mango.prjmango.teacher.TeacherView;
import lombok.Getter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame{
    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    private static final Logger logger = Logger.getLogger(MainFrame.class.getName());
    private static @Getter JFrame frame;

    private static @Getter BackgroundPanel backgroundLoginPanel;

    private static @Getter BackgroundPanel backgroundTeacherPanel;
    private static @Getter BackgroundPanel gradientPanel;
    private static @Getter  BackgroundPanel optionsTeacherPanel;

    public MainFrame(){
        frame = new JFrame("IEP Manager");
        frame.setPreferredSize(WINDOW_DIMENSIONS);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public void setLoginPage(){
        createLoginView();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void setTeacherView(){
        createTeacherView();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static LoginPageView createLoginViewController(){
        LoginPageView loginPageView = new LoginPageView();
        new LoginPageController(loginPageView);
        return loginPageView;
    }
    private static TeacherView createTeacherViewController(){
        TeacherView teacherView = new TeacherView();
        new TeacherController(teacherView);
        return teacherView;
    }
    private void createLoginView(){
        try {
            backgroundLoginPanel = new BackgroundPanel();
            backgroundLoginPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/Ariel-City-of-Lawrenceburg1.png")));
            backgroundLoginPanel.setLayout(null);
            backgroundLoginPanel.setBounds(0, 0, 100, 100);
            frame.add(backgroundLoginPanel);
            backgroundLoginPanel.add(createLoginViewController());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
    }
    private static void createTeacherView(){
        try {
            backgroundTeacherPanel = new BackgroundPanel();
            backgroundTeacherPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/BackgroundTeacherImage.PNG")));
            backgroundTeacherPanel.setLayout(null);
            backgroundTeacherPanel.setBounds(
                    (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                    (int) (Main.SCREEN_HEIGHT * 0.125),
                    (int) (Main.SCREEN_WIDTH * 0.3),
                    (int) (Main.SCREEN_HEIGHT * 0.70));
            frame.add(backgroundTeacherPanel);
            backgroundTeacherPanel.add(createTeacherViewController());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
    }
    public static void setActivePanel(RoundedPanel panel){
        backgroundLoginPanel.removeAll();
        backgroundLoginPanel.add(panel);
        backgroundLoginPanel.updateUI();
    }
    public static void setTeacherPanel(RoundedPanel panel){

    }
}
