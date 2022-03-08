package com.mango.prjmango;

import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
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

    private static LoginPageView createLoginViewController(){
        LoginPageView loginPageView = new LoginPageView();
        new LoginPageController(loginPageView);
        return loginPageView;
    }

    private static void createLoginView(){
        backgroundLoginPanel = new BackgroundPanel();
        backgroundLoginPanel.setBackground(Images.CLASSROOM_BACKGROUND.getBufferedImage());
        backgroundLoginPanel.setLayout(null);
        backgroundLoginPanel.setBounds(0, 0,(Main.SCREEN_WIDTH),(Main.SCREEN_HEIGHT));
        mainPanel.add(backgroundLoginPanel);
        backgroundLoginPanel.add(createLoginViewController());
    }

    public static void setActivePanel(RoundedPanel panel){
        backgroundLoginPanel.removeAll();
        backgroundLoginPanel.add(panel);
        backgroundLoginPanel.updateUI();
    }
}
