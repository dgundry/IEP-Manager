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
    private static @Getter BackgroundPanel backgroundLoginPanel;
    private static @Getter TeacherView teacherView;
    private static @Getter JFrame frame;

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
        frame.removeAll();
        createTeacherView();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
    private static LoginPageView createLoginViewController(){
        LoginPageView loginPageView = new LoginPageView();
        new LoginPageController(loginPageView);
        return loginPageView;
    }
    private static void createTeacherView(){
        frame.add(createLoginViewController());
    }
    private TeacherView createTeacherViewController(){
        teacherView = new TeacherView();
        new TeacherController(teacherView);
        return teacherView;
    }
    public static void setActivePanel(RoundedPanel panel){
        backgroundLoginPanel.removeAll();
        backgroundLoginPanel.add(panel);
        backgroundLoginPanel.updateUI();
    }
    public static void setTeacherPanel(RoundedPanel panel){

    }
}
