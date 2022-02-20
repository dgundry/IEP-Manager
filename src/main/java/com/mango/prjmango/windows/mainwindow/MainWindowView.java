package com.mango.prjmango.windows.mainwindow;

import com.mango.prjmango.windows.account.AccountController;
import com.mango.prjmango.windows.account.AccountView;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import lombok.Getter;

public class MainWindowView {

    private final Dimension INITIAL_DIMENSIONS = new Dimension(1440, 1024);

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    @Getter private JFrame frame;

    @Getter private static JPanel mainPanel;
    @Getter private static JPanel sideOptionsPanel;

    public MainWindowView(JPanel sideOptionsPanel) {
        this.sideOptionsPanel = sideOptionsPanel;

        AccountView accountView = new AccountView();  //<---just for testing the AccountView gui
        new AccountController(accountView); //<---also here

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //change
        frame.setBackground(DARK_GREY);
        frame.setDefaultLookAndFeelDecorated(true);

        createPanels();
        createComponents();
        createLayout();
        setLayout(sideOptionsPanel, accountView); //<----also here

        frame.pack();
        frame.setPreferredSize(INITIAL_DIMENSIONS);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createPanels() {
        mainPanel = new JPanel();
        mainPanel.setBackground(DARK_GREY);
        mainPanel.setMinimumSize(INITIAL_DIMENSIONS);
        mainPanel.setPreferredSize(INITIAL_DIMENSIONS);
    }

    private void createComponents() {

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

    private static void setLayout(JPanel sideOptionsPanel, JPanel displayPanel) {
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(sideOptionsPanel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sideOptionsPanel, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    public static void setLayout(JPanel displayPanel) {
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(sideOptionsPanel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sideOptionsPanel, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }
}
