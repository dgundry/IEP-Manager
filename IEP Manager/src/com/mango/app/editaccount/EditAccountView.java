package com.mango.app.editaccount;

public class EditAccountView {
<<<<<<< Updated upstream
}
=======

    private JFrame editAccountWindow;

    private static BackgroundPanel editAccountPanel;
    private static BackgroundPanel gradientPanel;
    private static BackgroundPanel optionsTeacherPanel;
    private static BackgroundPanel changePasswordPanel;
    private static BackgroundPanel changeEmailPanel;
    private static BackgroundPanel wrapPanel;

    private static JButton myAccountButton;
    private static JButton studentsButton;
    private static JButton fullReportsButton;
    private static JButton activitiesButton;
    private static JButton helpButton;
    private static JButton createStudentButton;
    private static JButton logOutButton;


    private JTextField currentPassText;
    private JTextField newPassText;
    private JTextField confirmNewPassText;
    private static JButton savePassword;

    private JTextField currentEmailText;
    private JTextField newEmailText;
    private JTextField confirmPassText;
    private static JButton saveEmail;

    private final Dimension WINDOW_DIMENSIONS = new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

    private static final Logger logger = Logger.getLogger(MainLoginView.class.getName());

    public EditAccountView() {

        createFrame();
        createPanel();
        createComponents();


        editAccountWindow.getContentPane().add(editAccountPanel);
        editAccountWindow.pack();
        editAccountWindow.setLocationRelativeTo(null);
        editAccountWindow.setVisible(true);


    }

    private void createComponents() {
        JLabel gradientPhoto = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/GradientPanel.PNG",
                (229/2),
                110)));
        JLabel grad = new JLabel("Test");
        grad.setBounds(10,10,100,25);

        //options teacher panel

        JLabel schoolLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/PawLogo.png",
                (229 / 2),
                110)));
        schoolLogo.setBounds(
                (int) (optionsTeacherPanel.getWidth() * 0.5) - 50,
                (int) (optionsTeacherPanel.getHeight() * 0.005),
                (229 / 2),
                110);
        JLabel titleHeader = createLabel("IEP Manager", FontType.FONT_35_BOLD);
        titleHeader.setBounds(0, (int) (optionsTeacherPanel.getHeight() * 0.14) , optionsTeacherPanel.getWidth(),45);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.20),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader.setBackground(Color.WHITE);

        JSeparator separatorHeader2 = new JSeparator(SwingConstants.CENTER);
        separatorHeader2.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.25),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader2.setBackground(Color.WHITE);

        myAccountButton = createButton("My Account");
        myAccountButton.setFont(new Font("Arial", Font.PLAIN, 35));
        myAccountButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.26),
                (optionsTeacherPanel.getWidth()),
                45);
        myAccountButton.setOpaque(true);

        studentsButton = createButton("Students");
        studentsButton.setFont(new Font("Arial", Font.PLAIN, 35));
        studentsButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.32),
                (optionsTeacherPanel.getWidth()),
                45);
        studentsButton.setOpaque(false);

        fullReportsButton = createButton("Full Reports");
        fullReportsButton.setFont(new Font("Arial", Font.PLAIN, 35));
        fullReportsButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.38),
                (optionsTeacherPanel.getWidth()),
                45);
        fullReportsButton.setOpaque(false);

        activitiesButton = createButton("Activities");
        activitiesButton.setFont(new Font("Arial", Font.PLAIN, 35));
        activitiesButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.44),
                (optionsTeacherPanel.getWidth()),
                45);
        activitiesButton.setOpaque(false);

        helpButton = createButton("Help");
        helpButton.setFont(new Font("Arial", Font.PLAIN, 35));
        helpButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.50),
                (optionsTeacherPanel.getWidth()),
                45);
        helpButton.setOpaque(false);

        JSeparator separatorHeader3 = new JSeparator(SwingConstants.CENTER);
        separatorHeader3.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.56),
                (optionsTeacherPanel.getWidth()),
                1);
        separatorHeader3.setBackground(Color.WHITE);

        logOutButton = createButton("Log Out");
        logOutButton.setFont(new Font("Arial", Font.PLAIN, 25));
        logOutButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.87),
                (optionsTeacherPanel.getWidth()),
                30);
        logOutButton.setOpaque(false);

        JLabel mangoLogo = new JLabel(new ImageIcon(getScaledImage(
                "src/com/mango/app/utilities/images/Mango3.png",
                50,
                50)));
        mangoLogo.setBounds(
                (int) (optionsTeacherPanel.getWidth() * 0.5) - 25,
                (optionsTeacherPanel.getHeight() - 75),
                50,
                50);
        createStudentButton = createButton("Create Student");
        createStudentButton.setFont(new Font("Ariel", Font.PLAIN, 25));
        createStudentButton.setBounds(
                (0),
                (int) (optionsTeacherPanel.getHeight() * 0.70),
                (optionsTeacherPanel.getWidth()),
                30);
        createStudentButton.setOpaque(false);

        //options teacher panel

        optionsTeacherPanel.add(schoolLogo);
        optionsTeacherPanel.add(mangoLogo);
        optionsTeacherPanel.add(titleHeader);
        optionsTeacherPanel.add(separatorHeader);
        optionsTeacherPanel.add(separatorHeader2);
        optionsTeacherPanel.add(myAccountButton);
        optionsTeacherPanel.add(studentsButton);
        optionsTeacherPanel.add(fullReportsButton);
        optionsTeacherPanel.add(activitiesButton);
        optionsTeacherPanel.add(createStudentButton);
        optionsTeacherPanel.add(helpButton);

        optionsTeacherPanel.add(separatorHeader3);
        optionsTeacherPanel.add(logOutButton);


        //change password panel

        JLabel changePasswordHeader = createLabel("Change Password", FontType.FONT_35_BOLD);
        changePasswordHeader.setBounds(0, (int) (changePasswordPanel.getHeight() * 0.05) , changePasswordPanel.getWidth(),45);

        JSeparator separatorHeader4 = new JSeparator(SwingConstants.CENTER);
        separatorHeader4.setBounds(
                (changePasswordPanel.getWidth()) - (changePasswordPanel.getWidth()),
                (int) (changePasswordPanel.getHeight() * 0.20),
                (changePasswordPanel.getWidth()),
                1);
        separatorHeader4.setBackground(Color.WHITE);

        JLabel currentPassword = new JLabel("Current password: ");
        currentPassword.setBounds(10, (int) (changePasswordPanel.getHeight() * 0.3), changePasswordPanel.getWidth(), 25);
        currentPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        currentPassword.setForeground(Color.WHITE);

        currentPassText = new JTextField("Password");
        currentPassText.setBounds(180, (int) (changePasswordPanel.getHeight() * 0.3), 180, 25);

        JLabel newPassword = new JLabel("New password:");
        newPassword.setBounds(35, (int) (changePasswordPanel.getHeight() * 0.4), changePasswordPanel.getWidth(), 25);
        newPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        newPassword.setForeground(Color.WHITE);

        newPassText = new JTextField("Password");
        newPassText.setBounds(180, (int) (changePasswordPanel.getHeight() * 0.4), 180, 25);

        JLabel confirmNewPassword = new JLabel("Confirm password:");
        confirmNewPassword.setBounds(7, (int) (changePasswordPanel.getHeight() * 0.5), changePasswordPanel.getWidth(), 25);
        confirmNewPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        confirmNewPassword.setForeground(Color.WHITE);

        confirmNewPassText = new JTextField("Password");
        confirmNewPassText.setBounds(180, (int) (changePasswordPanel.getHeight() * 0.5), 180, 25);

        savePassword = createButton("Save");
        savePassword.setFont(new Font("Arial", Font.PLAIN, 25));
        savePassword.setBounds(
                (changePasswordPanel.getWidth()) - (changePasswordPanel.getWidth()),
                (int) (changePasswordPanel.getHeight() * 0.8),
                (changePasswordPanel.getWidth()),
                30);

        //change password panel

        changePasswordPanel.add(changePasswordHeader);
        changePasswordPanel.add(separatorHeader4);
        changePasswordPanel.add(currentPassword);
        changePasswordPanel.add(currentPassText);
        changePasswordPanel.add(newPassword);
        changePasswordPanel.add(newPassText);
        changePasswordPanel.add(confirmNewPassword);
        changePasswordPanel.add(confirmNewPassText);
        changePasswordPanel.add(savePassword);


        //change email panel

        JLabel changeEmailHeader = createLabel("Change Email", FontType.FONT_35_BOLD);
        changeEmailHeader.setBounds(0, (int) (changeEmailPanel.getHeight() * 0.05) , changeEmailPanel.getWidth(),45);

        JSeparator separatorHeader5 = new JSeparator(SwingConstants.CENTER);
        separatorHeader5.setBounds(
                (changeEmailPanel.getWidth()) - (changeEmailPanel.getWidth()),
                (int) (changeEmailPanel.getHeight() * 0.20),
                (changeEmailPanel.getWidth()),
                1);
        separatorHeader5.setBackground(Color.WHITE);

        JLabel currentEmail = new JLabel("Current email:");
        currentEmail.setBounds(50, (int) (changeEmailPanel.getHeight() * 0.3), (int) changeEmailPanel.getWidth(), 25);
        currentEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        currentEmail.setForeground(Color.WHITE);

        currentEmailText = new JTextField("Email");
        currentEmailText.setBounds(180, (int) (changeEmailPanel.getHeight() * 0.3), 180, 25);

        JLabel newEmail = new JLabel("New email:");
        newEmail.setBounds(75, (int) (changeEmailPanel.getHeight() * 0.4), changeEmailPanel.getWidth(), 25);
        newEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        newEmail.setForeground(Color.WHITE);

        newEmailText = new JTextField("Email");
        newEmailText.setBounds(180, (int) (changeEmailPanel.getHeight() * 0.4), 180, 25);

        JLabel confirmPassword = new JLabel("Confirm password:");
        confirmPassword.setBounds(7, (int) (changeEmailPanel.getHeight() * 0.5), changeEmailPanel.getWidth(), 25);
        confirmPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        confirmPassword.setForeground(Color.WHITE);

        confirmPassText = new JTextField("Password");
        confirmPassText.setBounds(180, (int) (changeEmailPanel.getHeight() * 0.5), 180, 25);

        saveEmail = createButton("Save");
        saveEmail.setFont(new Font("Arial", Font.PLAIN, 25));
        saveEmail.setBounds(
                (changeEmailPanel.getWidth()) - (changeEmailPanel.getWidth()),
                (int) (changeEmailPanel.getHeight() * 0.8),
                (changeEmailPanel.getWidth()),
                30);

        //change email panel

        changeEmailPanel.add(changeEmailHeader);
        changeEmailPanel.add(separatorHeader5);
        changeEmailPanel.add(currentEmail);
        changeEmailPanel.add(currentEmailText);
        changeEmailPanel.add(newEmail);
        changeEmailPanel.add(newEmailText);
        changeEmailPanel.add(confirmPassword);
        changeEmailPanel.add(confirmPassText);
        changeEmailPanel.add(saveEmail);

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
        editAccountWindow = new JFrame();
        editAccountWindow.setPreferredSize(WINDOW_DIMENSIONS);
        editAccountWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        editAccountWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void createPanel() {
        try {
            editAccountPanel = new BackgroundPanel();
            editAccountPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/BackgroundTeacherImage.PNG")));
            editAccountPanel.setLayout(null);
            editAccountPanel.setBounds(
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
                    (int) (Main.SCREEN_HEIGHT * 0.2));
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
                    (int) (Main.SCREEN_WIDTH * 0.17),
                    (int) (Main.SCREEN_HEIGHT * 1.0));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Options image. ");
        }try {
            changePasswordPanel = new BackgroundPanel();
            changePasswordPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/grey.png")));
            changePasswordPanel.setLayout(null);
            changePasswordPanel.setBounds(
                    (400),
                    (300),
                    (int) (Main.SCREEN_WIDTH * 0.25),
                    (int) (Main.SCREEN_HEIGHT * 0.4));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Password image. ");
        }try {
            changeEmailPanel = new BackgroundPanel();
            changeEmailPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/grey.png")));
            changeEmailPanel.setLayout(null);
            changeEmailPanel.setBounds(
                    (1000),
                    (300),
                    (int) (Main.SCREEN_WIDTH * 0.25),
                    (int) (Main.SCREEN_HEIGHT * 0.4));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Email image. ");
        }
        try {
            wrapPanel = new BackgroundPanel();
            wrapPanel.setBackground(
                    ImageIO.read(new File("src/com/mango/app/utilities/images/black.PNG")));
            wrapPanel.setLayout(null);
            wrapPanel.setBounds(
                    (100),
                    (173),
                    (int) (Main.SCREEN_WIDTH * 0.935),
                    (int) (Main.SCREEN_HEIGHT * 0.05));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not load Wrap image. ");
        }

        editAccountPanel.add(optionsTeacherPanel);
        editAccountPanel.add(gradientPanel);
        editAccountPanel.add(changePasswordPanel);
        editAccountPanel.add(changeEmailPanel);
        editAccountPanel.add(wrapPanel);
    }

    /**
     * Swaps out the panels.
     *
     * @param panel the panel to display
     */
    public static void setActivePanel(RoundedPanel panel) {
        editAccountPanel.removeAll();
        editAccountPanel.add(panel);
        editAccountPanel.updateUI();
        editAccountPanel.add(gradientPanel);

    }

    private Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public JFrame getTeacherWindow() { return editAccountWindow; }
    public JButton getMyAccountButton() { return myAccountButton; }
    public JButton getStudentsButton() { return studentsButton; }
    public JButton getFullReportsButton() { return fullReportsButton; }
    public JButton getActivitiesButton() { return activitiesButton; }
    public JButton getHelpButton() { return helpButton; }
    public JButton getLogOutButton() { return helpButton; }
    public JButton getCreateStudentButton() { return createStudentButton; }
    public JTextField getCurrentPassText() { return currentPassText; }
    public JTextField getNewPassText() { return newPassText; }
    public JTextField getConfirmNewPassText() { return confirmNewPassText; }
    public JButton getSavePassword() { return savePassword; }
    public JTextField getCurrentEmailText() { return currentEmailText; }
    public JTextField getNewEmailText() { return newEmailText; }
    public JTextField getConfirmPassText() { return confirmPassText; }
    public JButton getSaveEmail() { return saveEmail; }


}
>>>>>>> Stashed changes
