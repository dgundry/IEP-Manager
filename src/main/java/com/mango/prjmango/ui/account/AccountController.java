package com.mango.prjmango.ui.account;

import com.mango.prjmango.utilities.subtabs.AccountSubTabs;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.account.listeners.AccountSubTabListener;
import javax.swing.JLabel;

public class AccountController {

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
