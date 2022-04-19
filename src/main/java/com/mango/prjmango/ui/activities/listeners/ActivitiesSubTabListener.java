package com.mango.prjmango.ui.activities.listeners;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.ui.activities.create.CreateController;
import com.mango.prjmango.ui.activities.create.CreateView;
import com.mango.prjmango.ui.activities.remove.RemoveController;
import com.mango.prjmango.ui.activities.remove.RemoveView;
import com.mango.prjmango.utilities.subtabs.ActivitiesSubTabs;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.activities.math.MathController;
import com.mango.prjmango.ui.activities.math.MathView;
import com.mango.prjmango.ui.activities.sightwords.SightController;
import com.mango.prjmango.ui.activities.sightwords.SightView;
import com.mango.prjmango.ui.activities.upload.UploadController;
import com.mango.prjmango.ui.activities.upload.UploadView;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Handles all user interaction with sub-tabs in the Activities tab.
 */
public class ActivitiesSubTabListener implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;
    private final ImageIcon selectedImage;

    private final ActivitiesSubTabs activitiesSubTab;

    /**
     * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener} methods.
     *
     * @param label            the specified {@link JLabel}
     * @param noHoveredImage   the {@link ImageIcons} reference when the image is not in a hovered state
     * @param hoveredImage     the {@link ImageIcons} reference when the image is in a hovered state
     * @param selectedImage    the {@link ImageIcons} reference when the image is in a selected state
     * @param activitiesSubTab the specific {@link ActivitiesSubTabs}
     */
    public ActivitiesSubTabListener(
            JLabel label,
            ImageIcon noHoveredImage,
            ImageIcon hoveredImage,
            ImageIcon selectedImage,
            ActivitiesSubTabs activitiesSubTab) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.selectedImage = selectedImage;
        this.activitiesSubTab = activitiesSubTab;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        ActivitiesView.previouslyActiveTab = ActivitiesView.currentlyActiveTab;
        ActivitiesView.currentlyActiveTab = activitiesSubTab;
        resetLabelImages();
        label.setIcon(selectedImage);

        switch (ActivitiesView.currentlyActiveTab.ordinal()) {
            case 0:
                LoggedInUser.setActivitiesSubTabIndex(0);
                MathView mathView = new MathView();
                new MathController(mathView);
                ActivitiesView.setActiveDisplay(mathView);
                break;
            case 1:
                LoggedInUser.setActivitiesSubTabIndex(1);
                SightView fryView = new SightView();
                new SightController(fryView);
                ActivitiesView.setActiveDisplay(fryView);
                break;
            case 2:
                LoggedInUser.setActivitiesSubTabIndex(2);
                SightView dolchView = new SightView();
                new SightController(dolchView);
                ActivitiesView.setActiveDisplay(dolchView);
                break;
            case 3:
                LoggedInUser.setActivitiesSubTabIndex(3);
                UploadView uploadView = new UploadView();
                new UploadController(uploadView);
                ActivitiesView.setActiveDisplay(uploadView);
                break;
            case 4:
                LoggedInUser.setActivitiesSubTabIndex(4);
                CreateView createView = new CreateView();
                new CreateController(createView);
                ActivitiesView.setActiveDisplay(createView);
                break;
            case 5:
                LoggedInUser.setActivitiesSubTabIndex(5);
                RemoveView removeView = new RemoveView();
                new RemoveController(removeView);
                ActivitiesView.setActiveDisplay(removeView);
            default:
                break;
        }
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (label.getIcon().equals(noHoveredImage)) {
            label.setIcon(hoveredImage);
        }

        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (label.getIcon().equals(hoveredImage)) {
            label.setIcon(noHoveredImage);
        }

        label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        ActivitiesSubTabs previouslyActiveTab = ActivitiesView.previouslyActiveTab;
        switch (previouslyActiveTab.ordinal()) {
            case 0:
                ActivitiesView.getMathLabel().setIcon(ImageIcons.ACTIVITIES_MATH_NO_HOVER.getImageIcon());
                break;
            case 1:
                ActivitiesView.getFryLabel().setIcon(ImageIcons.ACTIVITIES_FRY_NO_HOVER.getImageIcon());
                break;
            case 2:
                ActivitiesView.getDolchLabel().setIcon(ImageIcons.ACTIVITIES_DOLCH_NO_HOVER.getImageIcon());
                break;
            case 3:
                ActivitiesView.getUploadAssignmentLabel().setIcon(ImageIcons.ACTIVITIES_UPLOAD_NO_HOVER.getImageIcon());
                break;
            case 4:
                ActivitiesView.getCreateAssignmentLabel().setIcon(ImageIcons.ACTIVITIES_CREATE_ASSIGNMENT_NO_HOVER.getImageIcon());
                break;
            case 5:
                ActivitiesView.getRemoveAssignmentLabel().setIcon(ImageIcons.ACTIVITIES_DELETE_ASSIGNMENT_NO_HOVER.getImageIcon());
                break;
            default:
                break;
        }
    }
}
