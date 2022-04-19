package com.mango.prjmango.ui.account;

import com.mango.prjmango.utilities.subtabs.AccountSubTabs;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.account.listeners.AccountSubTabListener;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * Handles all user interaction with the Account sub-tab container.
 */
public class AccountController {

    /**
     * Constructs the controller for the {@link AccountView}. Adds {@link MouseListener}'s to the {@link JLabel}'s
     * that the user will interact with.
     *
     * @param view the instance of the {@link AccountView}
     */
    public AccountController(AccountView view) {
        JLabel editProfileLabel = view.getEditProfileLabel();
        JLabel passwordSecurityLabel = view.getPasswordSecurityLabel();

        editProfileLabel.addMouseListener(new AccountSubTabListener(
                editProfileLabel,
                ImageIcons.EDIT_PROFILE_NO_HOVER.getImageIcon(),
                ImageIcons.EDIT_PROFILE_HOVERED.getImageIcon(),
                ImageIcons.EDIT_PROFILE_SELECTED.getImageIcon(),
                AccountSubTabs.EDIT_PROFILE,
                view));
        passwordSecurityLabel.addMouseListener(new AccountSubTabListener(
                passwordSecurityLabel,
                ImageIcons.PASSWORD_SECURITY_NO_HOVER.getImageIcon(),
                ImageIcons.PASSWORD_SECURITY_HOVERED.getImageIcon(),
                ImageIcons.PASSWORD_SECURITY_SELECTED.getImageIcon(),
                AccountSubTabs.PASSWORD_AND_SECURITY,
                view));
    }
}
