package com.mango.prjmango.windows.sideoptions;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.utilities.Fonts;
import com.mango.prjmango.utilities.ImageIcons;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import lombok.Getter;

/**
 * The user interface design of the side options on the left side.
 */
public class SideOptionsView {

    private static JLabel pawLogoLabel;

    @Getter private static JLabel backgroundLabel;
    @Getter private static JLabel welcomeLabel;
    @Getter private static JLabel accountTabLabel;
    @Getter private static JLabel studentsTabLabel;
    @Getter private static JLabel activitiesTabLabel;
    @Getter private static JLabel reportsTabLabel;
    @Getter private static JLabel logOutLabel;

    private static JSeparator topSeparator;
    private static JSeparator bottomSeparator;

    private static final Color DARK_GREY  = new Color(19, 18, 18);
    private static final Color LIGHT_GREY = new Color(216, 216, 216);

    private static final Dimension DIMENSIONS = new Dimension(340, Main.rect.height);

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public SideOptionsView() {
        createComponents();
        createLayout();
    }

    private static void createComponents() {
        backgroundLabel = new JLabel();
        backgroundLabel.setBackground(DARK_GREY);
        backgroundLabel.setBorder(new LineBorder(LIGHT_GREY, 1, true));
        backgroundLabel.setMaximumSize(DIMENSIONS);
        backgroundLabel.setMinimumSize(DIMENSIONS);

        pawLogoLabel = new JLabel(ImageIcons.PAW_LOGO.getImageIcon());

        welcomeLabel = new JLabel();
        welcomeLabel.setFont(Fonts.SEGOE_UI_28.getFont());
        welcomeLabel.setForeground(LIGHT_GREY);
        welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        welcomeLabel.setText("Welcome, " + LoggedInUser.getFirstName() + "!");

        accountTabLabel    = new JLabel(ImageIcons.ACCOUNT_TAB_HOVERED.getImageIcon());
        studentsTabLabel   = new JLabel(ImageIcons.STUDENT_TAB_NO_HOVER.getImageIcon());
        activitiesTabLabel = new JLabel(ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
        reportsTabLabel    = new JLabel(ImageIcons.REPORTS_TAB_NO_HOVER.getImageIcon());

        logOutLabel = new JLabel(ImageIcons.LOG_OUT_NO_HOVER.getImageIcon());

        topSeparator = new JSeparator();
        topSeparator.setForeground(LIGHT_GREY);
        topSeparator.setPreferredSize(new Dimension(246, 1));

        bottomSeparator = new JSeparator();
        bottomSeparator.setForeground(LIGHT_GREY);
        bottomSeparator.setPreferredSize(new Dimension(246, 1));
    }

    private static void createLayout() {
        GroupLayout optionsPanelLayout = new GroupLayout(backgroundLabel);
        backgroundLabel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
                optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(pawLogoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(accountTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(topSeparator, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(welcomeLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(bottomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentsTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(activitiesTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(logOutLabel)
                                                        .addComponent(reportsTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionsPanelLayout.setVerticalGroup(
                optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(pawLogoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(welcomeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(topSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accountTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentsTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(activitiesTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reportsTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bottomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logOutLabel)
                                .addGap(63, 63, 63))
        );
    }
}
