package com.mango.prjmango.windows.activities.listeners;

import com.mango.prjmango.utilities.subtabs.ActivitiesSubTab;
import com.mango.prjmango.windows.activities.ActivitiesView;
import com.mango.prjmango.windows.activities.dolch.DolchController;
import com.mango.prjmango.windows.activities.dolch.DolchView;
import com.mango.prjmango.windows.activities.fry.FryController;
import com.mango.prjmango.windows.activities.fry.FryView;
import com.mango.prjmango.windows.activities.math.MathController;
import com.mango.prjmango.windows.activities.math.MathView;
import com.mango.prjmango.windows.activities.upload.UploadController;
import com.mango.prjmango.windows.activities.upload.UploadView;
import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class ActivitiesSubTabListener implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;
    private final ImageIcon selectedImage;

    private ActivitiesView activitiesView;

    private ActivitiesSubTab activitiesSubTab;

    /**
     * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener} methods.
     *
     * @param label            the specified {@link JLabel}
     * @param noHoveredImage   the {@link ImageIcons} reference when the image is not in a hovered state
     * @param hoveredImage     the {@link ImageIcons} reference when the image is in a hovered state
     * @param selectedImage    the {@link ImageIcons} reference when the image is in a selected state
     * @param activitiesSubTab the specific {@link ActivitiesSubTab}
     * @param activitiesView   the {@link ActivitiesView} so we can access other {@link JComponent}'s
     */
    public ActivitiesSubTabListener(
            JLabel label,
            ImageIcon noHoveredImage,
            ImageIcon hoveredImage,
            ImageIcon selectedImage,
            ActivitiesSubTab activitiesSubTab,
            ActivitiesView activitiesView) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.selectedImage = selectedImage;
        this.activitiesSubTab = activitiesSubTab;
        this.activitiesView = activitiesView;
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
                MathView mathView = new MathView();
                new MathController(mathView);
                activitiesView.setActiveDisplay(mathView);
                break;
            case 1:
                FryView fryView = new FryView();
                new FryController(fryView);
                activitiesView.setActiveDisplay(fryView);
                break;
            case 2:
                DolchView dolchView = new DolchView();
                new DolchController(dolchView);
                activitiesView.setActiveDisplay(dolchView);
                break;
            case 3:
                UploadView uploadView = new UploadView();
                new UploadController(uploadView);
                activitiesView.setActiveDisplay(uploadView);
                break;
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
        ActivitiesSubTab previouslyActiveTab = ActivitiesView.previouslyActiveTab;
        switch (previouslyActiveTab.ordinal()) {
            case 0:
                activitiesView.getMathLabel().setIcon(ImageIcons.ACTIVITIES_MATH_NO_HOVER.getImageIcon());
                break;
            case 1:
                activitiesView.getFryLabel().setIcon(ImageIcons.ACTIVITIES_FRY_NO_HOVER.getImageIcon());
                break;
            case 2:
                activitiesView.getDolchLabel().setIcon(ImageIcons.ACTIVITIES_DOLCH_NO_HOVER.getImageIcon());
                break;
            case 3:
                activitiesView.getUploadAssignmentLabel().setIcon(ImageIcons.ACTIVITIES_UPLOAD_NO_HOVER.getImageIcon());
                break;
        }
    }
}
