package com.mango.prjmango.utilities;

import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import lombok.Getter;
import lombok.Setter;

public enum Tab {

    HOME, ACCOUNT, STUDENTS, ACTIVITIES, REPORTS;

    @Getter
    @Setter
    private boolean isActiveStatus;

    @Getter
    private static List<Tab> list;

    public static void configureActiveTab(Tab tab) {
        list = Arrays.asList(Tab.class.getEnumConstants());

        for (Tab t : list) {
            if (t == tab) {
                t.setActiveStatus(true);
            } else {
                t.setActiveStatus(false);
            }
        }
    }

    public static ImageIcon getCorrespondingImageIcon(Tab tab) {
        ImageIcon icon = null;
        switch(tab) {
            case HOME:
                icon = Images.HOME_TAB_HOVERED.getImageIcon();
                break;
            case ACCOUNT:
                icon = Images.ACCOUNT_TAB_HOVERED.getImageIcon();
                break;
            case STUDENTS:
                icon = Images.STUDENT_TAB_HOVERED.getImageIcon();
                break;
            case ACTIVITIES:
                icon = Images.ACTIVITIES_TAB_HOVERED.getImageIcon();
                break;
            case REPORTS:
                icon = Images.REPORTS_TAB_HOVERED.getImageIcon();
                break;
            default:
                break;
        }
        return icon;
    }
}
