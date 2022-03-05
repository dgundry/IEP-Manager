package com.mango.prjmango.windows.sideoptions.listeners;

import com.mango.prjmango.utilities.ImageIcons;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Handles the user interaction with the side tabs.
 */
public class TabListeners implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;

    private SideOptionsView view;

    private Tabs tab;

    /**
     * Constructor. Initializes instance variables that will be used in the {@link MouseListener} methods.
     *
     * @param label          the specific {@link JLabel} that is associated with the {@link Tabs}
     * @param noHoveredImage the {@link ImageIcon} when the user is {@code not} hovering over the tab
     * @param hoveredImage   the {@link ImageIcon} when the user is hovering over the tab
     * @param tab            the {@link Tabs} that is associated with the specified {@link JLabel}
     * @param view           the {@link SideOptionsView} to access other {@link JComponent}'s
     */
    public TabListeners(
            JLabel label,
            ImageIcon noHoveredImage,
            ImageIcon hoveredImage,
            Tabs tab,
            SideOptionsView view) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.tab = tab;
        this.view = view;
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
                view.getAccountTabLabel().setIcon(ImageIcons.ACCOUNT_TAB_NO_HOVER.getImageIcon());
                break;
            case 1:
                view.getStudentsTabLabel().setIcon(ImageIcons.STUDENT_TAB_NO_HOVER.getImageIcon());
                break;
            case 2:
                view.getActivitiesTabLabel().setIcon(ImageIcons.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
                break;
            case 3:
                view.getReportsTabLabel().setIcon(ImageIcons.REPORTS_TAB_NO_HOVER.getImageIcon());
            default:
                break;
        }
    }
}
