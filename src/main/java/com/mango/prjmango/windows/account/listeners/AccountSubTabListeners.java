package com.mango.prjmango.windows.account.listeners;

import com.mango.prjmango.utilities.AccountSubTabs;
import com.mango.prjmango.utilities.ImageIcons;
import com.mango.prjmango.utilities.Tabs;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.account.AccountView;
import com.mango.prjmango.windows.account.editprofile.EditProfileController;
import com.mango.prjmango.windows.account.editprofile.EditProfileView;
import com.mango.prjmango.windows.account.passwordsecurity.PasswordSecurityController;
import com.mango.prjmango.windows.account.passwordsecurity.PasswordSecurityView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AccountSubTabListeners implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;
    private final ImageIcon selectedImage;

    private AccountView accountView;

    private AccountSubTabs accountSubTabs;


    public AccountSubTabListeners(
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

    @Override
    public void mouseClicked(MouseEvent e){
        AccountView.previouslyActiveTab = AccountView.currentlyActiveTab;
        AccountView.currentlyActiveTab = accountSubTabs;
        label.setIcon(selectedImage);
        resetLabelImages();

        if(AccountView.currentlyActiveTab == AccountSubTabs.PASSWORD_AND_SECURITY){
            PasswordSecurityView passwordSecurityView = new PasswordSecurityView();
            new PasswordSecurityController(passwordSecurityView);
            accountView.setMainPageLayout(passwordSecurityView);
        }
        else{
            EditProfileView editProfileView = new EditProfileView();
            new EditProfileController(editProfileView);
            accountView.setMainPageLayout(editProfileView);
        }
    }


    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (label.getIcon().equals(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon())) {
            label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon());
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
        if (label.getIcon().equals(ImageIcons.EDIT_PROFILE_EDIT_ICON_HOVERED.getImageIcon())) {
            label.setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
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

        }
    }
}

