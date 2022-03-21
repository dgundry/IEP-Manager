package com.mango.prjmango.ui.sideoptions.listeners;

import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.account.AccountController;
import com.mango.prjmango.ui.account.AccountView;
import com.mango.prjmango.ui.activities.ActivitiesController;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.sideoptions.SideOptionsView;
import com.mango.prjmango.ui.students.StudentsController;
import com.mango.prjmango.ui.students.StudentsView;
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
        MainWindowView.setPreviouslyActiveTab(MainWindowView.getCurrentlyActiveTab());
        MainWindowView.setCurrentlyActiveTab(tab);
        resetLabelImages();
        label.setIcon(hoveredImage);

        if (tab == Tabs.ACCOUNT) {
            AccountView accountView = new AccountView();
            new AccountController(accountView);
            MainWindowView.displayActiveTab(accountView);
        } else if (tab == Tabs.ACTIVITIES) {
            new ActivitiesController(new ActivitiesView());
            MainWindowView.displayActiveTab(ActivitiesView.getActivitiesBackgroundLabel());
        } else if (tab == Tabs.STUDENTS) {
            new StudentsController(new StudentsView());

            MainWindowView.displayActiveTab(StudentsView.getStudentBackgroundLabel());
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
        if (MainWindowView.getCurrentlyActiveTab() != tab) {
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
        if (MainWindowView.getCurrentlyActiveTab() != tab) {
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
        Tabs previouslyActiveTab = MainWindowView.getPreviouslyActiveTab();
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
                break;
            default:
                break;
        }
    }
}
