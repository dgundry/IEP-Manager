package com.mango.prjmango.ui.sideoptions;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
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
        backgroundLabel.setBackground(Colors.DARK_GREY);
        backgroundLabel.setBorder(new LineBorder(Colors.LIGHT_GREY, 1, true));
        backgroundLabel.setMaximumSize(DIMENSIONS);
        backgroundLabel.setMinimumSize(DIMENSIONS);

        pawLogoLabel = new JLabel(ImageIcons.PAW_LOGO.getImageIcon());

        welcomeLabel = new JLabel();
        welcomeLabel.setForeground(Colors.LIGHT_GREY);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setText("Welcome, " + LoggedInUser.getFirstName() + "!");
        welcomeLabel.setFont(Fonts.SEGOE_UI_23.getFont());

        accountTabLabel    = new JLabel(ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon());
        studentsTabLabel   = new JLabel(ImageIcons.STUDENT_TAB_NO_HOVER.getImageIcon());
        activitiesTabLabel = new JLabel(ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
        reportsTabLabel    = new JLabel(ImageIcons.REPORTS_TAB_NO_HOVER.getImageIcon());
        setActiveTabIcon();

        logOutLabel = new JLabel(ImageIcons.LOG_OUT_NO_HOVER.getImageIcon());

        topSeparator = Components.JSeparator(SwingConstants.HORIZONTAL);
        topSeparator.setPreferredSize(new Dimension(246, 1));

        bottomSeparator = Components.JSeparator(SwingConstants.HORIZONTAL);
        bottomSeparator.setPreferredSize(new Dimension(246, 1));
    }
    public static void updateWelcomeLabel(){
        welcomeLabel.setText("Welcome, " + LoggedInUser.getFirstName() + "!");
        switch(LoggedInUser.getFirstName().length()){
            case 10:
                welcomeLabel.setFont(Fonts.SEGOE_UI_12.getFont());
                break;
            default:
                welcomeLabel.setFont(Fonts.SEGOE_UI_28.getFont());
                break;
        }
    }

    private static void setActiveTabIcon() {
        switch (MainWindowView.getCurrentlyActiveTab().ordinal()) {
            case 0:
                accountTabLabel.setIcon(ImageIcons.ACCOUNT_TAB_HOVERED.getImageIcon());
                break;
            case 1:
                studentsTabLabel.setIcon(ImageIcons.STUDENT_TAB_HOVERED.getImageIcon());
                break;
            case 2:
                activitiesTabLabel.setIcon(ImageIcons.ACTIVITIES_TAB_HOVERED.getImageIcon());
                break;
            case 3:
                reportsTabLabel.setIcon(ImageIcons.REPORTS_TAB_HOVERED.getImageIcon());
                break;
            default:
                break;
        }
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
                                                .addComponent(
                                                        pawLogoLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(
                                                        accountTabLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        246,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(optionsPanelLayout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                        .addGroup(optionsPanelLayout.createParallelGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addComponent(
                                                                        topSeparator,
                                                                        GroupLayout.Alignment.LEADING,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(
                                                                        welcomeLabel,
                                                                        GroupLayout.Alignment.LEADING,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(
                                                                bottomSeparator,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                studentsTabLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                246,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                activitiesTabLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                246,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(logOutLabel)
                                                        .addComponent(
                                                                reportsTabLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                246,
                                                                GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionsPanelLayout.setVerticalGroup(
                optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(
                                        pawLogoLabel,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(welcomeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        topSeparator,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accountTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentsTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(activitiesTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reportsTabLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(
                                        bottomSeparator,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(logOutLabel)
                                .addGap(63, 63, 63))
        );
    }
}
