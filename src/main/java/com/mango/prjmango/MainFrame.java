package com.mango.prjmango;

import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.teacher.TeacherController;
import com.mango.prjmango.teacher.TeacherView;
import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.windows.common.Images;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import lombok.Getter;

public class MainFrame {

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    private static @Getter JFrame frame;

    private static @Getter JPanel mainPanel;
    private static @Getter BackgroundPanel backgroundLoginPanel;

    private static @Getter BackgroundPanel backgroundTeacherPanel;
    private static @Getter BackgroundPanel gradientPanel;
    private static @Getter BackgroundPanel optionsTeacherPanel;

    //private static final BufferedImage BACKGROUND_IMAGE = Images.getBackgroundImage();

    public MainFrame() {
        frame = new JFrame("IEP Manager");
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.setPreferredSize(WINDOW_DIMENSIONS);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,1));
        frame.add(mainPanel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                DatabaseConnection.closeConnection();
            }
        });
    }

    public static void setLoginPage() {
        Main.activeUser = null;
        mainPanel.removeAll();
        createLoginView();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        mainPanel.updateUI();
    }

    public static void setTeacherView() {
        mainPanel.removeAll();
        createTeacherView();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        mainPanel.updateUI();
    }

    public static void setTeacherView(JPanel panel){
        mainPanel.removeAll();
        createTeacherView(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        mainPanel.updateUI();
    }

    private static LoginPageView createLoginViewController(){
        LoginPageView loginPageView = new LoginPageView();
        new LoginPageController(loginPageView);
        return loginPageView;
    }

    private static TeacherView createTeacherViewController(JPanel panel){
        TeacherView teacherView = new TeacherView(panel);
        new TeacherController(teacherView);
        return teacherView;
    }

    private static TeacherView createTeacherViewController(){
        TeacherView teacherView = new TeacherView();
        new TeacherController(teacherView);
        return teacherView;
    }

    private static void createLoginView(){
        backgroundLoginPanel = new BackgroundPanel();
        backgroundLoginPanel.setBackground(Images.CLASSROOM_BACKGROUND.getBufferedImage());
        backgroundLoginPanel.setLayout(null);
        backgroundLoginPanel.setBounds(0, 0,(Main.SCREEN_WIDTH),(Main.SCREEN_HEIGHT));
        mainPanel.add(backgroundLoginPanel);
        backgroundLoginPanel.add(createLoginViewController());
    }

    private static void createTeacherView(JPanel panel){
        mainPanel.add(createTeacherViewController(panel));
    }

    private static void createTeacherView(){
        backgroundTeacherPanel = new BackgroundPanel();
        //backgroundTeacherPanel.setBackground(BACKGROUND_IMAGE);
        backgroundTeacherPanel.setLayout(null);
        backgroundTeacherPanel.setBounds(
                0,
                0,
                Main.SCREEN_WIDTH,
                Main.SCREEN_HEIGHT);
        mainPanel.add(backgroundTeacherPanel);
        backgroundTeacherPanel.add(createTeacherViewController());
    }

    public static void setActivePanel(RoundedPanel panel){
        backgroundLoginPanel.removeAll();
        backgroundLoginPanel.add(panel);
        backgroundLoginPanel.updateUI();
    }

    public static void setTeacherPanel(RoundedPanel panel){

    }
}
