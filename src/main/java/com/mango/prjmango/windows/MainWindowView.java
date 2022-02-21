package com.mango.prjmango.windows;

import com.mango.prjmango.windows.account.AccountController;
import com.mango.prjmango.windows.account.AccountView;
import com.mango.prjmango.windows.login.LoginController;
import com.mango.prjmango.windows.login.LoginView;
import com.mango.prjmango.windows.sideoptions.SideOptionsController;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import lombok.Getter;

public class MainWindowView {

    private static final Dimension INITIAL_DIMENSIONS = new Dimension(1440, 1024);

    private static final Color DARK_GREY = new Color(19, 18, 18);

    @Getter private static JFrame frame;

    @Getter private static JPanel mainPanel;

    public MainWindowView() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //change
        frame.setBackground(DARK_GREY);

        createPanel();
        createLayout();

        frame.pack();
        frame.setPreferredSize(INITIAL_DIMENSIONS);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createPanel() {
        mainPanel = new JPanel();
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
                                .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }

    public static void setLoginPage() {
        mainPanel.removeAll();

        LoginView loginView = new LoginView();
        new LoginController(loginView);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel.updateUI();
    }

    public static void setAccountView() {
        mainPanel.removeAll();
        mainPanel.updateUI();

        AccountView accountView = new AccountView();
        new AccountController(accountView);

        SideOptionsView sideOptionsView = new SideOptionsView();
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
