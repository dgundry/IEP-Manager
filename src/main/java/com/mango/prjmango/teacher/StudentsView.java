package com.mango.prjmango.teacher;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.student.CreateAStudentView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentsView extends BackgroundPanel {

    private static BackgroundPanel backgroundPanel;
    private static BackgroundPanel wrapPanel;
    private static BackgroundPanel headerPanel;

    private static JButton myAccountButton;
    private static JButton studentsButton;
    private static JButton fullReportsButton;
    private static JButton activitiesButton;
    private static JButton helpButton;
    private static JButton createStudentButton;
    private static JButton logOutButton;

    private JPanel studentsPanel = new JPanel(new GridLayout());
    private JPanel addPanel = new JPanel();

    private JTable studentsTable;
    private DefaultTableModel tableModel;

    private static final Logger logger = Logger.getLogger(CreateAStudentView.class.getName());

    public StudentsView() {

        try{
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

    private void createComponents(){

        JLabel header = createLabel("Students Table", FontType.FONT_35_BOLD);
        header.setBounds(0,(int) (headerPanel.getHeight() * 0.05), headerPanel.getWidth(), 45);

        headerPanel.add(header);
    }
    private JLabel createLabel(String text, Font font){
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    public void createPanel() {
        try {
            backgroundPanel = new BackgroundPanel();
            backgroundPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/BackgroundTeacherImage.PNG")));
            backgroundPanel.setLayout(null);
            backgroundPanel.setBounds(
                    (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                    (int) (Main.SCREEN_HEIGHT * 0.125),
                    (int) (Main.SCREEN_WIDTH * 0.3),
                    (int) (Main.SCREEN_HEIGHT * 0.70));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
        try{
            wrapPanel = new BackgroundPanel();
            wrapPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/black.PNG")));
            wrapPanel.setLayout(null);
            wrapPanel.setBounds(
                    (100),
                    (173),
                    (int) (Main.SCREEN_WIDTH * 0.935),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Wrap image. ");
        }
        try {
            headerPanel = new BackgroundPanel();
            headerPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            headerPanel.setLayout(null);
            headerPanel.setBounds(
                    (300),
                    (250),
                    (int) (Main.SCREEN_WIDTH * 0.765),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Header image. ");

        }
        add(wrapPanel);
        add(headerPanel);
    }

    public JButton getMyAccountButton() { return myAccountButton; };
    public JButton getStudentsButton() { return studentsButton; }
    public JButton getFullReportsButton() { return fullReportsButton; }
    public JButton getActivitiesButton() { return activitiesButton; }
    public JButton getHelpButton() { return helpButton; }
    public JButton getLogOutButton() { return helpButton; }
    public JButton getCreateStudentButton() { return createStudentButton; }
}
