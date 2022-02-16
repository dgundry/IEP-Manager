package com.mango.prjmango.teacher;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.student.CreateAStudentView;
import com.mango.prjmango.utilities.Images;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


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
        this.setBackground(Images.getBackgroundTeacherImage());
        this.setLayout(null);
        this.setBounds(
                0,
                0,
                Main.SCREEN_WIDTH,
                Main.SCREEN_HEIGHT);
        createPanel();
        createComponents();
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
        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setBackground(Images.getBackgroundTeacherImage());
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        wrapPanel = new BackgroundPanel();
        wrapPanel.setBackground(Images.getBlackImage());
        wrapPanel.setLayout(null);
        wrapPanel.setBounds(
                (100),
                (173),
                (int) (Main.SCREEN_WIDTH * 0.935),
                (int) (Main.SCREEN_HEIGHT * 0.05));

            headerPanel = new BackgroundPanel();
            headerPanel.setBackground(Images.getOrangeImage());
            headerPanel.setLayout(null);
            headerPanel.setBounds(
                    (300),
                    (250),
                    (int) (Main.SCREEN_WIDTH * 0.765),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
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
