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
    @Getter private static JLabel homeTabLabel;
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

        homeTabLabel       = new JLabel(ImageIcons.HOME_TAB_NO_HOVER.getImageIcon());
        accountTabLabel    = new JLabel(ImageIcons.ACCOUNT_TAB_HOVERED.getImageIcon()); //since Account is active tab from login
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
                                                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(bottomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(activitiesTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(GroupLayout.Alignment.LEADING, optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(studentsTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(GroupLayout.Alignment.LEADING, optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(accountTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(GroupLayout.Alignment.LEADING, optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                                        .addComponent(topSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(welcomeLabel, GroupLayout.Alignment.LEADING))
                                                                                                .addComponent(homeTabLabel, GroupLayout.Alignment.LEADING))))))
                                                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                                                .addGap(74, 74, 74)
                                                                .addComponent(pawLogoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(reportsTabLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logOutLabel)
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentsTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(activitiesTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reportsTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bottomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logOutLabel)
                                .addGap(63, 63, 63))
        );
    }
}
