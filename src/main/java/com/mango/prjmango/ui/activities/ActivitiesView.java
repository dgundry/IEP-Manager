package com.mango.prjmango.ui.activities;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.ui.account.AccountView;
import com.mango.prjmango.ui.activities.create.CreateController;
import com.mango.prjmango.ui.activities.create.CreateView;
import com.mango.prjmango.ui.activities.sightwords.SightController;
import com.mango.prjmango.ui.activities.sightwords.SightView;
import com.mango.prjmango.ui.activities.upload.UploadController;
import com.mango.prjmango.ui.activities.upload.UploadView;
import com.mango.prjmango.utilities.ImageUtils;
import com.mango.prjmango.utilities.subtabs.ActivitiesSubTabs;
import com.mango.prjmango.ui.activities.math.MathController;
import com.mango.prjmango.ui.activities.math.MathView;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ActivitiesView {

    private static JLabel pickAssignmentHeaderLabel;

    @Getter private static JLabel activitiesBackgroundLabel;

    @Getter private static JLabel mathLabel;
    @Getter private static JLabel fryLabel;
    @Getter private static JLabel dolchLabel;
    @Getter private static JLabel uploadAssignmentLabel;
    @Getter private static JLabel createAssignmentLabel;

    private static JSeparator horizSeparator;
    private static JSeparator vertSeparator;

    public static ActivitiesSubTabs currentlyActiveTab = ActivitiesSubTabs.MATH;
    public static ActivitiesSubTabs previouslyActiveTab = null;

    public ActivitiesView() {
        createComponents();
        initLastUsedSubTab();

        activitiesBackgroundLabel.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                activitiesBackgroundLabel.setIcon(ImageUtils.getImageIcon(
                        ActivitiesView.class,
                        "/images/common/active-tab-background.png",
                        activitiesBackgroundLabel.getWidth(),
                        activitiesBackgroundLabel.getHeight()));
                activitiesBackgroundLabel.updateUI();
                activitiesBackgroundLabel.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) { /* Not needed */ }

            @Override
            public void componentShown(ComponentEvent e) { /* Not needed */ }

            @Override
            public void componentHidden(ComponentEvent e) { /* Not needed */ }
        });
    }

    private static void initLastUsedSubTab() {
        switch (LoggedInUser.getActivitiesSubTabIndex()) {
            case 0:
                MathView mathView = new MathView();
                new MathController(mathView);
                setActiveDisplay(mathView);
                break;
            case 1:
            case 2:
                SightView fryView = new SightView();
                new SightController(fryView);
                setActiveDisplay(fryView);
                break;
            case 3:
                UploadView uploadView = new UploadView();
                new UploadController(uploadView);
                setActiveDisplay(uploadView);
                break;
            case 4:
                CreateView createView = new CreateView();
                new CreateController(createView);
                setActiveDisplay(createView);
                break;
            default:
                break;
        }
    }

    private static void createComponents() {
        activitiesBackgroundLabel = new JLabel();
        activitiesBackgroundLabel.setIcon(ImageIcons.ACTIVE_TAB_BACKGROUND.getImageIcon());

        pickAssignmentHeaderLabel = Components.JLabel(
                "Pick an Assignment",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);

        mathLabel             = new JLabel(ImageIcons.ACTIVITIES_MATH_NO_HOVER.getImageIcon());
        fryLabel              = new JLabel(ImageIcons.ACTIVITIES_FRY_NO_HOVER.getImageIcon());
        dolchLabel            = new JLabel(ImageIcons.ACTIVITIES_DOLCH_NO_HOVER.getImageIcon());
        uploadAssignmentLabel = new JLabel(ImageIcons.ACTIVITIES_UPLOAD_NO_HOVER.getImageIcon());
        createAssignmentLabel = new JLabel(ImageIcons.ACTIVITIES_CREATE_ASSIGNMENT_NO_HOVER.getImageIcon());
        setSelectedSubTab();

        horizSeparator = Components.JSeparator(SwingConstants.HORIZONTAL);
        vertSeparator  = Components.JSeparator(SwingConstants.VERTICAL);
    }

    private static void setSelectedSubTab() {
        switch (LoggedInUser.getActivitiesSubTabIndex()) {
            case 0:
                mathLabel.setIcon(ImageIcons.ACTIVITIES_MATH_SELECTED.getImageIcon());
                break;
            case 1:
                fryLabel.setIcon(ImageIcons.ACTIVITIES_FRY_SELECTED.getImageIcon());
                break;
            case 2:
                dolchLabel.setIcon(ImageIcons.ACTIVITIES_DOLCH_SELECTED.getImageIcon());
                break;
            case 3:
                uploadAssignmentLabel.setIcon(ImageIcons.ACTIVITIES_UPLOAD_SELECTED.getImageIcon());
                break;
            case 4:
                createAssignmentLabel.setIcon(ImageIcons.ACTIVITIES_CREATE_ASSIGNMENT_SELECTED.getImageIcon());
                break;
            default:
                break;
        }
    }

    public static void setActiveDisplay(JPanel displayPanel) {
        activitiesBackgroundLabel.removeAll();

        GroupLayout pickAnAssignmentPanelLayout = new GroupLayout(activitiesBackgroundLabel);
        activitiesBackgroundLabel.setLayout(pickAnAssignmentPanelLayout);
        pickAnAssignmentPanelLayout.setHorizontalGroup(
                pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(horizSeparator)
                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pickAssignmentHeaderLabel)
                                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                        .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(
                                                                GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(
                                                                        fryLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(
                                                                        mathLabel,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(
                                                                dolchLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                uploadAssignmentLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                createAssignmentLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(
                                                        vertSeparator,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        18,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(
                                                        displayPanel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(325, Short.MAX_VALUE))
        );
        pickAnAssignmentPanelLayout.setVerticalGroup(
                pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                .addComponent(
                                        pickAssignmentHeaderLabel,
                                        GroupLayout.PREFERRED_SIZE,
                                        59,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(
                                        horizSeparator,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(vertSeparator)
                                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(pickAnAssignmentPanelLayout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                        .addGroup(pickAnAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(
                                                                        mathLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        fryLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        dolchLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        uploadAssignmentLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        createAssignmentLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                                        .addGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                pickAnAssignmentPanelLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(
                                                                        displayPanel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE))))))
        );

        activitiesBackgroundLabel.updateUI();
    }
}
