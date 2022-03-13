package com.mango.prjmango.ui.dialogs.confirmation;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import lombok.Getter;

public class ConfirmationView extends JFrame {

    private final Dimension DIMENSIONS = new Dimension(305, 138);

    private JPanel panel;

    private JLabel confirmLabel;
    @Getter private JLabel exitLabel;
    @Getter private JLabel cancelLabel;

    @Getter private Dialogs selectedDialog;

    private String displayText;

    public ConfirmationView(String displayText, Dialogs selectedDialog) {
        this.displayText = displayText;
        this.selectedDialog = selectedDialog;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(DIMENSIONS);
        setMinimumSize(DIMENSIONS);
        setSize(DIMENSIONS);
        setResizable(false);
        setUndecorated(true);

        createPanel();
        createComponents();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setBackground(Colors.DARK_GREY);
        panel.setBorder(new LineBorder(Colors.LIGHT_GREY, 1, true));
    }

    private void createComponents() {
        confirmLabel = new JLabel(displayText);
        confirmLabel.setFont(Fonts.SEGOE_UI_16.getFont());
        confirmLabel.setForeground(Colors.LIGHT_GREY);
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);

        switch (selectedDialog.ordinal()) {
            case 0:
                exitLabel   = new JLabel(ImageIcons.APP_LOG_OUT_NO_HOVER.getImageIcon());
                cancelLabel = new JLabel(ImageIcons.APP_CANCEL_NO_HOVER.getImageIcon());
                createLayoutOne();
                break;
            case 1:
                exitLabel   = new JLabel(ImageIcons.APP_EXIT_NO_HOVER.getImageIcon());
                cancelLabel = new JLabel(ImageIcons.APP_CANCEL_NO_HOVER.getImageIcon());
                createLayoutOne();
                break;
            case 2:
                exitLabel   = new JLabel(ImageIcons.APP_EXIT_NO_HOVER.getImageIcon());
                cancelLabel = new JLabel();
                createLayoutTwo();
                break;
            case 3:
                exitLabel   = new JLabel(ImageIcons.OK_BUTTON_NO_HOVER.getImageIcon());
                cancelLabel = new JLabel();
                createLayoutTwo();
                break;
            default:
                break;
        }
    }

    private void createLayoutOne() {
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(
                                        confirmLabel,
                                        GroupLayout.PREFERRED_SIZE,
                                        304,
                                        GroupLayout.PREFERRED_SIZE)
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

    private void createLayoutTwo() {
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(confirmLabel, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(exitLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(confirmLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exitLabel)
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
