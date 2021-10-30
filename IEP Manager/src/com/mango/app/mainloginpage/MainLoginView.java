package com.mango.app.mainloginpage;

import com.mango.app.Main;
import com.mango.app.components.BackgroundPanel;
import com.mango.app.components.RoundedPanel;
import java.awt.Dimension;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainLoginView {

    private JFrame loginWindow;

    private static BackgroundPanel backgroundLoginPanel;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    private static final Logger logger = Logger.getLogger(MainLoginView.class.getName());

    public MainLoginView() {
        createFrame();
        createPanel();

        loginWindow.getContentPane().add(backgroundLoginPanel);
        loginWindow.pack();
        loginWindow.setLocationRelativeTo(null);
        loginWindow.setVisible(true);
    }

    private void createFrame() {
        loginWindow = new JFrame();
        loginWindow.setPreferredSize(WINDOW_DIMENSIONS);
        loginWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        loginWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void createPanel() {
        try {
            backgroundLoginPanel = new BackgroundPanel();
            backgroundLoginPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/Ariel-City-of-Lawrenceburg1.png")));
            backgroundLoginPanel.setLayout(null);
            backgroundLoginPanel.setBounds(0, 0, 100, 100);
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
        backgroundLoginPanel.removeAll();
        backgroundLoginPanel.add(panel);
        backgroundLoginPanel.updateUI();
    }

    public JFrame getLoginWindow() { return loginWindow; }
}
