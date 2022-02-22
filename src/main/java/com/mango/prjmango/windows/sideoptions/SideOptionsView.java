package com.mango.prjmango.windows.sideoptions;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.utilities.Images;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import lombok.Getter;

public class SideOptionsView extends JPanel {

    private JLabel pawLogoLabel;

    @Getter private JLabel welcomeLabel;
    @Getter private JLabel homeTabLabel;
    @Getter private JLabel accountTabLabel;
    @Getter private JLabel studentsTabLabel;
    @Getter private JLabel activitiesTabLabel;
    @Getter private JLabel reportsTabLabel;
    @Getter private JLabel logOutLabel;

    private JSeparator topSeparator;
    private JSeparator bottomSeparator;

    private final Color DARK_GREY  = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    private final Dimension DIMENSIONS = new Dimension(340, Main.rect.height);

    private final LoggedInUser user;

    public SideOptionsView(LoggedInUser user) {
        this.user = user;

        setBackground(DARK_GREY);
        setBorder(new LineBorder(LIGHT_GREY, 1, true));
        setMaximumSize(DIMENSIONS);
        setMinimumSize(DIMENSIONS);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        pawLogoLabel = new JLabel(Images.PAW_LOGO.getImageIcon());

        welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        welcomeLabel.setForeground(LIGHT_GREY);
        welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        welcomeLabel.setText("Welcome, " + user.getFirstName() + "!");

        homeTabLabel       = new JLabel(Images.HOME_TAB_NO_HOVER.getImageIcon());
        accountTabLabel    = new JLabel(Images.ACCOUNT_TAB_NO_HOVER.getImageIcon());
        studentsTabLabel   = new JLabel(Images.STUDENT_TAB_NO_HOVER.getImageIcon());
        activitiesTabLabel = new JLabel(Images.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
        reportsTabLabel    = new JLabel(Images.REPORTS_TAB_NO_HOVER.getImageIcon());

        logOutLabel = new JLabel(Images.LOG_OUT_NO_HOVER.getImageIcon());

        topSeparator = new JSeparator();
        topSeparator.setForeground(LIGHT_GREY);
        topSeparator.setPreferredSize(new Dimension(246, 1));

        bottomSeparator = new JSeparator();
        bottomSeparator.setForeground(LIGHT_GREY);
        bottomSeparator.setPreferredSize(new Dimension(246, 1));
    }

    private void createLayout() {
        GroupLayout optionsPanelLayout = new GroupLayout(this);
        setLayout(optionsPanelLayout);
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
