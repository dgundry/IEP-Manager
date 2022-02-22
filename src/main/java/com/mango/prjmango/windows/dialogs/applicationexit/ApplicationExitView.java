package com.mango.prjmango.windows.dialogs.applicationexit;

import com.mango.prjmango.utilities.Images;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import lombok.Getter;

public class ApplicationExitView extends JFrame {

    private final Dimension DIMENSIONS = new Dimension(305, 138);

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    private JPanel panel;

    private JLabel confirmLabel;
    @Getter private JLabel exitLabel;
    @Getter private JLabel cancelLabel;

    public ApplicationExitView() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(DIMENSIONS);
        setMinimumSize(DIMENSIONS);
        setSize(DIMENSIONS);
        setResizable(false);
        setUndecorated(true);

        createPanel();
        createComponents();
        createLayout();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setBackground(DARK_GREY);
        panel.setBorder(new LineBorder(LIGHT_GREY, 1, true));
    }

    private void createComponents() {
        confirmLabel = new JLabel("Are you sure you want to exit?");
        confirmLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        confirmLabel.setForeground(LIGHT_GREY);
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);

        exitLabel = new JLabel(Images.APP_EXIT_NO_HOVER.getImageIcon());
        cancelLabel = new JLabel(Images.APP_CANCEL_NO_HOVER.getImageIcon());
    }

    private void createLayout() {
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(confirmLabel, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(exitLabel)
                                .addGap(18, 18, 18)
                                .addComponent(cancelLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(confirmLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(exitLabel)
                                        .addComponent(cancelLabel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
        );
    }
}
