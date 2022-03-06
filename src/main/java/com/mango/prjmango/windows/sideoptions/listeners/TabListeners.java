package com.mango.prjmango.windows.sideoptions.listeners;

import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.account.AccountController;
import com.mango.prjmango.windows.account.AccountView;
import com.mango.prjmango.windows.activities.ActivitiesController;
import com.mango.prjmango.windows.activities.ActivitiesView;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Handles the user interaction with the side tabs.
 */
public class TabListeners implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;

    private final Tabs tab;

    /**
     * Constructor. Initializes instance variables that will be used in the {@link MouseListener} methods.
     *
     * @param label          the specific {@link JLabel} that is associated with the {@link Tabs}
     * @param noHoveredImage the {@link ImageIcon} when the user is {@code not} hovering over the tab
     * @param hoveredImage   the {@link ImageIcon} when the user is hovering over the tab
     * @param tab            the {@link Tabs} that is associated with the specified {@link JLabel}
     */
    public TabListeners(JLabel label, ImageIcon noHoveredImage, ImageIcon hoveredImage, Tabs tab) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.tab = tab;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        MainWindowView.previouslyActiveTab = MainWindowView.currentlyActiveTab;
        MainWindowView.currentlyActiveTab = tab;
        label.setIcon(hoveredImage);
        resetLabelImages();

        if (tab == Tabs.ACCOUNT) {
            AccountView accountView = new AccountView();
            new AccountController(accountView);

            MainWindowView.displayActiveTab(accountView);
        } else if (tab == Tabs.ACTIVITIES) {
            new ActivitiesController(new ActivitiesView());

            MainWindowView.displayActiveTab(ActivitiesView.getActivitiesBackgroundLabel());
        } else if (tab == Tabs.STUDENTS) {
            //students
        } else {
            //report
        }
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (MainWindowView.currentlyActiveTab != tab) {
            label.setIcon(hoveredImage);
        }
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (MainWindowView.currentlyActiveTab != tab) {
            label.setIcon(noHoveredImage);
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mousePressed(MouseEvent e) { /* Not needed */ }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseReleased(MouseEvent e) { /* Not needed */ }

    private void resetLabelImages() {
        Tabs previouslyActiveTab = MainWindowView.previouslyActiveTab;
        switch (previouslyActiveTab.ordinal()) {
            case 0:
                SideOptionsView.getAccountTabLabel().setIcon(ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon());
                break;
            case 1:
                SideOptionsView.getStudentsTabLabel().setIcon(ImageIcons.STUDENT_TAB_NO_HOVER.getImageIcon());
                break;
            case 2:
                SideOptionsView.getActivitiesTabLabel().setIcon(ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
                break;
            case 3:
                SideOptionsView.getReportsTabLabel().setIcon(ImageIcons.REPORTS_TAB_NO_HOVER.getImageIcon());
            default:
                break;
        }
    }
}
