package com.mango.prjmango.windows;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.account.AccountController;
import com.mango.prjmango.windows.account.AccountView;
import com.mango.prjmango.windows.dialogs.applicationexit.ApplicationExitController;
import com.mango.prjmango.windows.dialogs.applicationexit.ApplicationExitView;
import com.mango.prjmango.windows.sideoptions.SideOptionsController;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import lombok.Getter;

public class MainWindowView {

    private static final Dimension INITIAL_DIMENSIONS = new Dimension(Main.rect.width, Main.rect.height);

    private static final Color DARK_GREY = new Color(19, 18, 18);

    @Getter private static JFrame frame;

    @Getter private static JPanel mainPanel = new JPanel();

    private static LoginViewLayout loginViewLayout = new LoginViewLayout();

    public static Tabs currentlyActiveTab = Tabs.ACCOUNT; //change to home
    public static Tabs previouslyActiveTab = null;

    /**
     * Constructor. Instantiates the {@link JFrame} and calls methods to create the layout.
     */
    public MainWindowView() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setBackground(DARK_GREY);

        createPanel();
        createLayout();

        frame.pack();
        frame.setPreferredSize(INITIAL_DIMENSIONS);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ApplicationExitView applicationExitView = new ApplicationExitView();
                new ApplicationExitController(applicationExitView);
            }
        });
    }

    private static void createPanel() {
        mainPanel.setBackground(DARK_GREY);
        mainPanel.setMinimumSize(INITIAL_DIMENSIONS);
        mainPanel.setPreferredSize(INITIAL_DIMENSIONS);
    }

    private void createLayout() {
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(
                                        mainPanel,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }

    /**
     * This method will switch out the rounded "panel" (which is actually a {@link JLabel}) on the Login screen.
     *
     * @param label the {@link JLabel} that acts as a {@link JPanel} which holds {@link JComponent}'s.
     */
    public static void setActiveDisplay(JLabel label) {
        mainPanel.removeAll();

        loginViewLayout.setLayout(label);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginViewLayout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginViewLayout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel.updateUI();
    }

    public static void setAccountView(LoggedInUser user) {
        mainPanel.removeAll();
        mainPanel.updateUI();

        AccountView accountView = new AccountView();
        new AccountController(accountView);

        SideOptionsView sideOptionsView = new SideOptionsView(user);
        new SideOptionsController(sideOptionsView);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(sideOptionsView, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(accountView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sideOptionsView, GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(accountView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.updateUI();
    }
}
