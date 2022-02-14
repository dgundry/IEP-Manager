package com.mango.prjmango.student;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import lombok.Getter;

public class CreateAStudentView extends BackgroundPanel{



    private static BackgroundPanel backgroundCASPanel;
    private static BackgroundPanel wrapPanel;
    private static BackgroundPanel headerPanel;

    private static BackgroundPanel firstNamePanel;
    private static BackgroundPanel firstNameTextPanel;

    private static BackgroundPanel lastNamePanel;
    private static BackgroundPanel lastNameTextPanel;

    private static BackgroundPanel goalListPanel;
    private static BackgroundPanel goalListTextPanel;

    private static BackgroundPanel gradePanel;
    private static BackgroundPanel gradeTextPanel;

    private static BackgroundPanel goalDesPanel;
    private static BackgroundPanel goalDesTextPanel;

    private static BackgroundPanel saveButtonPanel;

    private static JButton myAccountButton;
    private static JButton studentsButton;
    private static JButton fullReportsButton;
    private static JButton activitiesButton;
    private static JButton helpButton;
    private static JButton createStudentButton;
    private static JButton logOutButton;
    private @Getter JButton saveButton;

    private @Getter JTextField firstNameText;
    private @Getter JTextField lastNameText;
    private @Getter JTextField gradeText;
    private @Getter JTextArea goalListText;
    private @Getter JTextField bioText;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    private static final Logger logger = Logger.getLogger(CreateAStudentView.class.getName());

    public CreateAStudentView() {

        try {
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

    private void createComponents() {

        //header panel
        JLabel header = createLabel("Create A Student", FontType.FONT_35_BOLD);
        header.setBounds(0, (int) (headerPanel.getHeight() * 0.05) , headerPanel.getWidth(),45);

        //header panel
        headerPanel.add(header);

        //first name panel
        JLabel firstName = createLabel("First name:", FontType.FONT_35_BOLD);
        firstName.setBounds(0, (int) (firstNamePanel.getHeight() * 0.05) , firstNamePanel.getWidth(),45);

        firstNameText = new JTextField("First name");
        firstNameText.setBounds(0, 0, firstNameTextPanel.getWidth(), firstNameTextPanel.getHeight());

        //first name panel
        firstNamePanel.add(firstName);
        firstNameTextPanel.add(firstNameText);

        //last name panel
        JLabel lastName = createLabel("Last name:", FontType.FONT_35_BOLD);
        lastName.setBounds(0, (int) (lastNamePanel.getHeight() * 0.05) , lastNamePanel.getWidth(),45);

        lastNameText = new JTextField("Last name");
        lastNameText.setBounds(0, 0, lastNameTextPanel.getWidth(), lastNameTextPanel.getHeight());

        //last name panel
        lastNamePanel.add(lastName);
        lastNameTextPanel.add(lastNameText);

        //goal list panel
        JLabel goalList = createLabel("List of goals:", FontType.FONT_35_BOLD);
        goalList.setBounds(0, (int) (goalListPanel.getHeight() * 0.05) , goalListPanel.getWidth(),45);

        goalListText = new JTextArea("List of goals");
        goalListText.setBounds(0, 0, goalListTextPanel.getWidth(), goalListTextPanel.getHeight());

        //goal list panel
        goalListPanel.add(goalList);
        goalListTextPanel.add(goalListText);

        //grade panel
        JLabel grade = createLabel("Grade:", FontType.FONT_35_BOLD);
        grade.setBounds(0, (int) (gradePanel.getHeight() * 0.05) , gradePanel.getWidth(),45);

        gradeText = new JTextField("Grade");
        gradeText.setBounds(0, 0, gradeTextPanel.getWidth(), gradeTextPanel.getHeight());

        //grade panel
        gradePanel.add(grade);
        gradeTextPanel.add(gradeText);

        //goal description panel
        JLabel goalDes = createLabel("Goal descriptions:", FontType.FONT_35_BOLD);
        goalDes.setBounds(0, (int) (goalDesPanel.getHeight() * 0.05) , goalDesPanel.getWidth(),45);

        bioText = new JTextField("Goal descriptions");
        bioText.setBounds(0, 0, goalDesTextPanel.getWidth(), goalDesTextPanel.getHeight());

        //goal description panel
        goalDesPanel.add(goalDes);
        goalDesTextPanel.add(bioText);

        //save button panel
        saveButton = createButton("Save");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 25));
        saveButton.setBounds(0, 0, (saveButtonPanel.getWidth()), (saveButtonPanel.getHeight()));

        //save button panel
        saveButtonPanel.add(saveButton);
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


    private void createPanel() {
        try {
            backgroundCASPanel = new BackgroundPanel();
            backgroundCASPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/BackgroundTeacherImage.PNG")));
            backgroundCASPanel.setLayout(null);
            backgroundCASPanel.setBounds(
                    (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                    (int) (Main.SCREEN_HEIGHT * 0.125),
                    (int) (Main.SCREEN_WIDTH * 0.3),
                    (int) (Main.SCREEN_HEIGHT * 0.70));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load background image.");
        }
        try {
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
        try {
            firstNamePanel = new BackgroundPanel();
            firstNamePanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            firstNamePanel.setLayout(null);
            firstNamePanel.setBounds(
                    (325),
                    (325),
                    (int) (Main.SCREEN_WIDTH * 0.15),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load First Name image. ");
        }
        try {
            firstNameTextPanel = new BackgroundPanel();
            firstNameTextPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            firstNameTextPanel.setLayout(null);
            firstNameTextPanel.setBounds(
                    (325),
                    (380),
                    (int) (Main.SCREEN_WIDTH * 0.15),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load First Name Textbox image. ");
        }
        try {
            lastNamePanel = new BackgroundPanel();
            lastNamePanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            lastNamePanel.setLayout(null);
            lastNamePanel.setBounds(
                    (600),
                    (325),
                    (int) (Main.SCREEN_WIDTH * 0.15),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Last Name image. ");
        }
        try {
            lastNameTextPanel = new BackgroundPanel();
            lastNameTextPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            lastNameTextPanel.setLayout(null);
            lastNameTextPanel.setBounds(
                    (600),
                    (380),
                    (int) (Main.SCREEN_WIDTH * 0.15),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Last Name Textbox image. ");
        }
        try {
            goalListPanel = new BackgroundPanel();
            goalListPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            goalListPanel.setLayout(null);
            goalListPanel.setBounds(
                    (1000),
                    (325),
                    (int) (Main.SCREEN_WIDTH * 0.2),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Goal List image. ");
        }
        try {
            goalListTextPanel = new BackgroundPanel();
            goalListTextPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            goalListTextPanel.setLayout(null);
            goalListTextPanel.setBounds(
                    (1000),
                    (380),
                    (int) (Main.SCREEN_WIDTH * 0.2),
                    (int) (Main.SCREEN_HEIGHT * 0.3));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Goal List Textbox image. ");
        }
        try {
            gradePanel = new BackgroundPanel();
            gradePanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            gradePanel.setLayout(null);
            gradePanel.setBounds(
                    (325),
                    (500),
                    (int) (Main.SCREEN_WIDTH * 0.15),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Grade image. ");
        }
        try {
            gradeTextPanel = new BackgroundPanel();
            gradeTextPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            gradeTextPanel.setLayout(null);
            gradeTextPanel.setBounds(
                    (325),
                    (555),
                    (int) (Main.SCREEN_WIDTH * 0.15),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Grade Textbox image. ");
        }
        try {
            goalDesPanel = new BackgroundPanel();
            goalDesPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            goalDesPanel.setLayout(null);
            goalDesPanel.setBounds(
                    (325),
                    (650),
                    (int) (Main.SCREEN_WIDTH * 0.2),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Goal Description image. ");
        }
        try {
            goalDesTextPanel = new BackgroundPanel();
            goalDesTextPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/orange.PNG")));
            goalDesTextPanel.setLayout(null);
            goalDesTextPanel.setBounds(
                    (325),
                    (705),
                    (int) (Main.SCREEN_WIDTH * 0.4),
                    (int) (Main.SCREEN_HEIGHT * 0.15));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Goal Description Textbox image. ");
        }
        try {
            saveButtonPanel = new BackgroundPanel();
            saveButtonPanel.setBackground(
                    ImageIO.read(new File("src/main/java/com/mango/prjmango/utilities/images/black.PNG")));
            saveButtonPanel.setLayout(null);
            saveButtonPanel.setBounds(
                    (1100),
                    (780),
                    (int) (Main.SCREEN_WIDTH * 0.09),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Save Button image. ");
        }

        add(wrapPanel);
        add(headerPanel);

        add(firstNamePanel);
        add(firstNameTextPanel);

        add(lastNamePanel);
        add(lastNameTextPanel);

        add(goalListPanel);
        add(goalListTextPanel);

        add(gradePanel);
        add(gradeTextPanel);

        add(goalDesPanel);
        add(goalDesTextPanel);

        add(saveButtonPanel);
    }


    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public JButton getMyAccountButton() { return myAccountButton; }
    public JButton getStudentsButton() { return studentsButton; }
    public JButton getFullReportsButton() { return fullReportsButton; }
    public JButton getActivitiesButton() { return activitiesButton; }
    public JButton getHelpButton() { return helpButton; }
    public JButton getLogOutButton() { return helpButton; }
    public JButton getCreateStudentButton() { return createStudentButton; }
    public JTextField getFirstNameText() { return firstNameText; }
    public JTextField getLastNameText() { return lastNameText; }
    public JTextArea getGoalListText() { return goalListText; }
    public JTextField getGradeText() { return gradeText; }
    public JTextField getBioText() { return bioText; }
    public JButton getSaveButton() { return saveButton; }
}
