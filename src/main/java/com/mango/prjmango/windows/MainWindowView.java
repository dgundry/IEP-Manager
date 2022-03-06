package com.mango.prjmango.windows;

import com.mango.prjmango.Main;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.windows.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.windows.dialogs.confirmation.Dialogs;
import com.mango.prjmango.windows.sideoptions.SideOptionsController;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;
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

    @Getter private static JFrame frame;

    @Getter private static JPanel mainPanel = new JPanel();

    private static LoginViewLayout loginViewLayout = new LoginViewLayout();

    public static Tabs currentlyActiveTab = Tabs.ACCOUNT;
    public static Tabs previouslyActiveTab = null;

    private static SideOptionsView sideOptionsView;

    /**
     * Constructor. Instantiates the {@link JFrame} and calls methods to create the layout.
     */
    public MainWindowView() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setBackground(Colors.DARK_GREY);

        createPanel();
        createLayout();

        frame.pack();
        frame.setPreferredSize(INITIAL_DIMENSIONS);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ConfirmationView applicationExitView =
                        new ConfirmationView("Are you sure you want to exit?", Dialogs.CLOSE_APPLICATION);
                new ConfirmationController(applicationExitView);
            }
        });
    }

    private static void createPanel() {
        mainPanel.setBackground(Colors.DARK_GREY);
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
                        .addComponent(
                                loginViewLayout,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                loginViewLayout,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );

        mainPanel.updateUI();
    }

    public static void displayActiveTab(JLabel activeLabel) {
        if (sideOptionsView == null) {
            sideOptionsView = new SideOptionsView();
            new SideOptionsController();
        }

        mainPanel.removeAll();
        mainPanel.updateUI();

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(
                                        SideOptionsView.getBackgroundLabel(),
                                        GroupLayout.PREFERRED_SIZE,
                                        268,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(
                                        activeLabel,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                SideOptionsView.getBackgroundLabel(), GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(
                                        activeLabel,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap())
        );

        mainPanel.updateUI();
    }
}
