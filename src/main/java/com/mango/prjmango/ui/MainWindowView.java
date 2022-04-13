package com.mango.prjmango.ui;

import com.mango.prjmango.Main;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.ui.dialogs.confirmation.Dialogs;
import com.mango.prjmango.ui.sideoptions.SideOptionsController;
import com.mango.prjmango.ui.sideoptions.SideOptionsView;
import com.mango.prjmango.utilities.Tabs;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import lombok.Getter;
import lombok.Setter;

public class MainWindowView {

    private static final Dimension INITIAL_DIMENSIONS = new Dimension(Main.rect.width, Main.rect.height);

    @Getter private static final JFrame frame = new JFrame();
    @Getter private static final JPanel mainPanel = new JPanel();

    private static final LoginViewLayout loginViewLayout = new LoginViewLayout();

    @Getter @Setter private static Tabs currentlyActiveTab = Tabs.STUDENTS;
    @Getter @Setter private static Tabs previouslyActiveTab = null;

    private static SideOptionsView sideOptionsView;

    /**
     * Constructor. Instantiates the {@link JFrame} and calls methods to create the layout.
     */
    public MainWindowView() {
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setBackground(Colors.DARK_GREY);

        createPanel();
        createLayout();

        frame.pack();
        frame.setPreferredSize(INITIAL_DIMENSIONS);
        frame.setMinimumSize(INITIAL_DIMENSIONS);
        frame.setLocation(new Point(-5,0));
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ConfirmationView applicationExitView =
                        new ConfirmationView("Are you sure you want to exit?", Dialogs.CLOSE_APPLICATION);
                new ConfirmationController(applicationExitView);
            }
        });
        frame.addComponentListener(new ComponentListener() {

            /**
             * Handles the componentResized event by invoking the
             * componentResized methods on listener-a and listener-b.
             * @param e the component event
             */
            @Override
            public void componentResized(ComponentEvent e) {
                mainPanel.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
                mainPanel.updateUI();
                mainPanel.repaint();
            }

            /**
             * Handles the componentMoved event by invoking the
             * componentMoved methods on listener-a and listener-b.
             * @param e the component event
             */
            @Override
            public void componentMoved(ComponentEvent e) { /* Not needed */ }

            /**
             * Handles the componentShown event by invoking the
             * componentShown methods on listener-a and listener-b.
             * @param e the component event
             */
            @Override
            public void componentShown(ComponentEvent e) { /* Not needed */ }

            /**
             * Handles the componentHidden event by invoking the
             * componentHidden methods on listener-a and listener-b.
             * @param e the component event
             */
            @Override
            public void componentHidden(ComponentEvent e) { /* Not needed */ }
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
