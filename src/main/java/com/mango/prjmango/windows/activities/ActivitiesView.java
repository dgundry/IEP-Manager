package com.mango.prjmango.windows.activities;

import com.mango.prjmango.utilities.subtabs.ActivitiesSubTab;
import com.mango.prjmango.windows.activities.math.MathController;
import com.mango.prjmango.windows.activities.math.MathView;
import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.Components;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

public class ActivitiesView extends JLabel {

    private JLabel pickAssignmentHeaderLabel;

    @Getter private JLabel mathLabel;
    @Getter private JLabel fryLabel;
    @Getter private JLabel dolchLabel;
    @Getter private JLabel uploadAssignmentLabel;

    private JSeparator horizSeparator;
    private JSeparator vertSeparator;

    public static ActivitiesSubTab currentlyActiveTab = ActivitiesSubTab.MATH;
    public static ActivitiesSubTab previouslyActiveTab = null;

    public ActivitiesView() {
        setIcon(ImageIcons.ACTIVE_TAB_BACKGROUND.getImageIcon());

        createComponents();

        MathView mathView = new MathView();
        new MathController(mathView);

        setActiveDisplay(mathView);
    }

    private void createComponents() {
        pickAssignmentHeaderLabel = Components.JLabel(
                "Pick an Assignment",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);

        mathLabel             = new JLabel(ImageIcons.ACTIVITIES_MATH_SELECTED.getImageIcon());
        fryLabel              = new JLabel(ImageIcons.ACTIVITIES_FRY_NO_HOVER.getImageIcon());
        dolchLabel            = new JLabel(ImageIcons.ACTIVITIES_DOLCH_NO_HOVER.getImageIcon());
        uploadAssignmentLabel = new JLabel(ImageIcons.ACTIVITIES_UPLOAD_NO_HOVER.getImageIcon());

        horizSeparator = Components.JSeparator(SwingConstants.HORIZONTAL);
        vertSeparator  = Components.JSeparator(SwingConstants.VERTICAL);
    }

    public void setActiveDisplay(JPanel displayPanel) {
        removeAll();

        GroupLayout pickAnAssignmentPanelLayout = new GroupLayout(this);
        setLayout(pickAnAssignmentPanelLayout);
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
                                                                .addContainerGap())
                                                        .addGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                pickAnAssignmentPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(
                                                                        displayPanel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE))))))
        );

        updateUI();
    }
}
