package com.mango.prjmango.windows.sideoptions;

import com.mango.prjmango.utilities.Images;
import com.mango.prjmango.windows.sideoptions.listeners.TabListeners;
import javax.swing.JLabel;

public class SideOptionsController {

    public SideOptionsController(SideOptionsView view) {
        JLabel homeTabLabel       = view.getHomeTabLabel();
        JLabel accountTabLabel    = view.getAccountTabLabel();
        JLabel studentsTabLabel   = view.getStudentsTabLabel();
        JLabel activitiesTabLabel = view.getActivitiesTabLabel();
        JLabel reportsTabLabel    = view.getReportsTabLabel();
        JLabel logOutLabel        = view.getLogOutLabel();

        homeTabLabel.addMouseListener(new TabListeners(
                homeTabLabel,
                Images.HOME_TAB_NO_HOVER.getImageIcon(),
                Images.HOME_TAB_HOVERED.getImageIcon(),
                false));
        accountTabLabel.addMouseListener(new TabListeners(
                accountTabLabel,
                Images.ACCOUNT_TAB_NO_HOVER.getImageIcon(),
                Images.ACCOUNT_TAB_HOVERED.getImageIcon(),
                false));
        studentsTabLabel.addMouseListener(new TabListeners(
                studentsTabLabel,
                Images.STUDENT_TAB_NO_HOVER.getImageIcon(),
                Images.STUDENT_TAB_HOVERED.getImageIcon(),
                false));
        activitiesTabLabel.addMouseListener(new TabListeners(
                activitiesTabLabel,
                Images.ACTIVITIES_TAB_NO_HOVER.getImageIcon(),
                Images.ACTIVITIES_TAB_HOVERED.getImageIcon(),
                false));
        reportsTabLabel.addMouseListener(new TabListeners(
                reportsTabLabel,
                Images.REPORTS_TAB_NO_HOVER.getImageIcon(),
                Images.REPORTS_TAB_HOVERED.getImageIcon(),
                false));
        logOutLabel.addMouseListener(new TabListeners(
                logOutLabel,
                Images.LOG_OUT_NO_HOVER.getImageIcon(),
                Images.LOG_OUT_HOVERED.getImageIcon(),
                true));
    }
}
