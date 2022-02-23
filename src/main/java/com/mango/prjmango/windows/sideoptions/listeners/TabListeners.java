package com.mango.prjmango.windows.sideoptions.listeners;

import com.mango.prjmango.Main;
import com.mango.prjmango.utilities.Images;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TabListeners implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;

    private final boolean changeCursor;

    private SideOptionsView view;

    private Tabs tab = null;

    public TabListeners(
            JLabel label,
            ImageIcon noHoveredImage,
            ImageIcon hoveredImage,
            boolean changeCursor,
            Tabs tab,
            SideOptionsView view) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.changeCursor = changeCursor;
        this.tab = tab;
        this.view = view;
    }

    public TabListeners(JLabel label, ImageIcon noHoveredImage, ImageIcon hoveredImage, boolean changeCursor) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.changeCursor = changeCursor;
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
        System.out.println(MainWindowView.currentlyActiveTab);
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (changeCursor) {
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

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
        if (changeCursor) {
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

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
                view.getHomeTabLabel().setIcon(Images.HOME_TAB_NO_HOVER.getImageIcon());
                break;
            case 1:
                view.getAccountTabLabel().setIcon(Images.ACCOUNT_TAB_NO_HOVER.getImageIcon());
                break;
            case 2:
                view.getStudentsTabLabel().setIcon(Images.STUDENT_TAB_NO_HOVER.getImageIcon());
                break;
            case 3:
                view.getActivitiesTabLabel().setIcon(Images.ACTIVITIES_TAB_NO_HOVER.getImageIcon());
                break;
            case 4:
                view.getReportsTabLabel().setIcon(Images.REPORTS_TAB_NO_HOVER.getImageIcon());
            default:
                break;
        }
    }
}
