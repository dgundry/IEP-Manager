package com.mango.prjmango.components.dialogs.account;

import com.mango.prjmango.components.dialogs.Dialog;
import com.mango.prjmango.utilities.ImageIcons;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * This class creates the {@link JFrame} for the
 * {@link Dialog#ACCOUNT_CREATED} message type.
 *
 * @author  Kellen Campbell
 * @version 1.0
 * @since   2021-11-25
 */
public class AccountCreatedView extends JFrame {

    private JPanel panel;

    private JLabel checkLabel;
    private JLabel successLabel;
    private JLabel infoLabel;

    private @Getter JLabel okLabel;

    private static final int PANEL_WIDTH = 316;
    private static final int CHECK_LABEL_WIDTH = 100;
    private static final int OK_LABEL_WIDTH = 132;
    private static final int INFO_LABEL_WIDTH = 316;
    private static final int SUCCESS_LABEL_WIDTH = 316;

    private static final int PANEL_HEIGHT = 224;
    private static final int CHECK_LABEL_HEIGHT = 83;
    private static final int OK_LABEL_HEIGHT = 31;
    private static final int INFO_LABEL_HEIGHT = 19;
    private static final int SUCCESS_LABEL_HEIGHT = 32;

    /**
     * Constructor, calls multiple methods such as:
     * <p>
     * <ul>
     *     <li>{@link AccountCreatedView#createPanel}</li>
     *     <li>{@link AccountCreatedView#createComponents}</li>
     *     <li>{@link AccountCreatedView#createLayout()}</li>
     *     <li>{@link AccountCreatedView#createFrameLayout}</li>
     * </ul>
     * These methods help set up the look and layout of the dialog.
     */
    public AccountCreatedView() {
        createPanel();
        createComponents();
        createLayout();
        createFrameLayout();

        this.setUndecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(316, 224));
    }

    private void createComponents() {
        checkLabel = new JLabel(ImageIcons.CHECK_MARK_ICON);

        successLabel = new JLabel("Success");
        successLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        successLabel.setForeground(new Color(0, 168, 30));
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successLabel.setPreferredSize(new Dimension(316, 32));

        infoLabel = new JLabel("Your account has been successfully created!");
        infoLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        okLabel = new JLabel(ImageIcons.OK_NO_HOVER_ICON);
    }

    private void createLayout() {
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);

        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(okLabel, OK_LABEL_WIDTH, OK_LABEL_WIDTH, OK_LABEL_WIDTH)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) //change
                        .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(infoLabel, INFO_LABEL_WIDTH, INFO_LABEL_WIDTH, INFO_LABEL_WIDTH)
                                        .addComponent(successLabel, SUCCESS_LABEL_WIDTH, SUCCESS_LABEL_WIDTH, SUCCESS_LABEL_WIDTH)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(checkLabel, CHECK_LABEL_WIDTH, CHECK_LABEL_WIDTH, CHECK_LABEL_WIDTH)
                                                .addGap(108, 108, 108)))
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(checkLabel, CHECK_LABEL_HEIGHT, CHECK_LABEL_HEIGHT, CHECK_LABEL_HEIGHT)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(successLabel, SUCCESS_LABEL_HEIGHT, SUCCESS_LABEL_HEIGHT, SUCCESS_LABEL_HEIGHT)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoLabel, INFO_LABEL_HEIGHT, INFO_LABEL_HEIGHT, INFO_LABEL_HEIGHT)
                                .addGap(16, 16, 16)
                                .addComponent(okLabel, OK_LABEL_HEIGHT, OK_LABEL_HEIGHT, OK_LABEL_HEIGHT)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void createFrameLayout() {
        GroupLayout frameLayout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(frameLayout);

        frameLayout.setHorizontalGroup(
                frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, PANEL_WIDTH, PANEL_WIDTH, PANEL_WIDTH)
        );

        frameLayout.setVerticalGroup(
                frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, PANEL_HEIGHT, PANEL_HEIGHT, PANEL_HEIGHT)
        );
    }
}
