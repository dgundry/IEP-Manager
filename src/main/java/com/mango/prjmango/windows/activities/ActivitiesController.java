package com.mango.prjmango.windows.activities;

import com.mango.prjmango.utilities.subtabs.ActivitiesSubTab;
import com.mango.prjmango.windows.activities.listeners.ActivitiesSubTabListener;
import com.mango.prjmango.windows.common.ImageIcons;
import javax.swing.JLabel;

public class ActivitiesController {

    public ActivitiesController(ActivitiesView view) {
        JLabel mathLabel             = view.getMathLabel();
        JLabel fryLabel              = view.getFryLabel();
        JLabel dolchLabel            = view.getDolchLabel();
        JLabel uploadAssignmentLabel = view.getUploadAssignmentLabel();

        mathLabel.addMouseListener(new ActivitiesSubTabListener(
                mathLabel,
                ImageIcons.ACTIVITIES_MATH_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_MATH_HOVERED.getImageIcon(),
                ImageIcons.ACTIVITIES_MATH_SELECTED.getImageIcon(),
                ActivitiesSubTab.MATH,
                view));
        fryLabel.addMouseListener(new ActivitiesSubTabListener(
                fryLabel,
                ImageIcons.ACTIVITIES_FRY_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_FRY_HOVERED.getImageIcon(),
                ImageIcons.ACTIVITIES_FRY_SELECTED.getImageIcon(),
                ActivitiesSubTab.FRY,
                view));
        dolchLabel.addMouseListener(new ActivitiesSubTabListener(
                dolchLabel,
                ImageIcons.ACTIVITIES_DOLCH_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_DOLCH_HOVERED.getImageIcon(),
                ImageIcons.ACTIVITIES_DOLCH_SELECTED.getImageIcon(),
                ActivitiesSubTab.DOLCH,
                view));
        uploadAssignmentLabel.addMouseListener(new ActivitiesSubTabListener(
                uploadAssignmentLabel,
                ImageIcons.ACTIVITIES_UPLOAD_NO_HOVER.getImageIcon(),
                ImageIcons.ACTIVITIES_UPLOAD_HOVERED.getImageIcon(),
                ImageIcons.ACTIVITIES_UPLOAD_SELECTED.getImageIcon(),
                ActivitiesSubTab.UPLOAD_AN_ASSIGNMENT,
                view));
    }
}
