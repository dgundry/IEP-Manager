package com.mango.prjmango.ui.account.listeners;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.subtabs.AccountSubTabs;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.account.AccountView;
import com.mango.prjmango.ui.account.editprofile.EditProfileController;
import com.mango.prjmango.ui.account.editprofile.EditProfileView;
import com.mango.prjmango.ui.account.password.PasswordController;
import com.mango.prjmango.ui.account.password.PasswordView;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Handles the user interaction with the {@link AccountSubTabs} that are displayed on the
 * {@link AccountView}.
 */
public class AccountSubTabListener implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;
    private final ImageIcon selectedImage;

    private final AccountView accountView;
    private final AccountSubTabs accountSubTabs;

    /**
     * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener} methods.
     *
     * @param label          the specified {@link JLabel}
     * @param noHoveredImage the {@link ImageIcons} reference when the image is not in a hovered state
     * @param hoveredImage   the {@link ImageIcons} reference when the image is in a hovered state
     * @param selectedImage  the {@link ImageIcons} reference when the image is in a selected state
     * @param accountSubTabs the specific {@link AccountSubTabs}
     * @param accountView    the {@link AccountView} so we can access other {@link JComponent}'s
     */
    public AccountSubTabListener(
            JLabel label,
            ImageIcon noHoveredImage,
            ImageIcon hoveredImage,
            ImageIcon selectedImage,
            AccountSubTabs accountSubTabs,
            AccountView accountView) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.selectedImage = selectedImage;
        this.accountSubTabs = accountSubTabs;
        this.accountView = accountView;
    }

    /**
     * Invoked when the mouse clicks a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        AccountView.previouslyActiveTab = AccountView.currentlyActiveTab;
        AccountView.currentlyActiveTab = accountSubTabs;
        resetLabelImages();
        label.setIcon(selectedImage);

        switch (AccountView.currentlyActiveTab.ordinal()) {
            case 0:
                LoggedInUser.setAccountSubTabIndex(0);
                EditProfileView editProfileView = new EditProfileView();
                new EditProfileController(editProfileView);
                accountView.setActiveDisplay(editProfileView);
                break;
            case 1:
                LoggedInUser.setAccountSubTabIndex(1);
                PasswordView passwordSecurityView = new PasswordView();
                new PasswordController(passwordSecurityView);
                accountView.setActiveDisplay(passwordSecurityView);
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
        AccountSubTabs previouslyActiveTab = AccountView.previouslyActiveTab;
        switch (previouslyActiveTab.ordinal()) {
            case 0:
                accountView.getEditProfileLabel().setIcon(ImageIcons.EDIT_PROFILE_NO_HOVER.getImageIcon());
                break;
            case 1:
                accountView.getPasswordSecurityLabel().setIcon(ImageIcons.PASSWORD_SECURITY_NO_HOVER.getImageIcon());
                break;
            default:
                break;
        }
    }
}

